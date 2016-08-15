package xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.converter;

import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.constructer.VelocityTemplate;
import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.constructer.element.DisplaySpecification;
import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.constructer.element.SampleMail;
import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.constructer.element.SeparateOutSpecification;
import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.expression.VarExpression;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.Comparator.reverseOrder;
import static xyz.skycat.work.VelocityTemplateGen.ae.config.ConfigManager.configGenVm;
import static xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.expression.VarExpression.exp;

/**
 * Created by SS on 2016/08/14.
 */
public class SampleMailConverter {

    private List<SampleMail> sampleMailList;

    private List<DisplaySpecification> displaySpecificationList;

    private List<SeparateOutSpecification> separateOutSpecificationList;

    private String templateFileType;

    private List<String> convertResultList;

    public SampleMailConverter(VelocityTemplate velocityTemplate) {
        sampleMailList = velocityTemplate.getSampleMailList();
        displaySpecificationList = velocityTemplate.getDisplaySpecificationList();
        templateFileType = velocityTemplate.getTemplateFileType();
        separateOutSpecificationList = velocityTemplate.getSeparateOutSpecificationList();
        convertResultList = new ArrayList<>();
    }

    public String getResult() {
        StringBuilder sb = new StringBuilder();
        for (String convertResult : convertResultList) {
            sb.append(convertResult).append(System.getProperty("line.separator"));
        }
        return sb.toString();
    }

    public boolean convert() {
        try {
            // 置換対象値長の降順優先でマッチングしないと誤変換するため（f.e. [13] , [9130] => [$!{no}] , [9$!{no}0]）
            displaySpecificationList.sort(comparing(x -> x.getTargetStr().length(), reverseOrder()));

            for (SampleMail sampleMail : sampleMailList) {

                String example = sampleMail.getExample();

                /*
                 * メール文例の変動項目を置換変数に変えていく
                 */
                for (DisplaySpecification displaySpecification : displaySpecificationList) {
                    if (isNotTarget(sampleMail.getNo(), displaySpecification.getNo(), displaySpecification.getNos())) {
                        continue;
                    }

                    // 変動項目を $ 変数置換
                    example = replaceByConvertStr(example, displaySpecification.getTargetStr(), displaySpecification.getConvertStr(), templateFileType);

                    // インクルード変換用のケース
                    if (displaySpecification.getConvertStr().startsWith(configGenVm().getIncludeConvertStr())) {
                        example = IncludeConverter.createIncludeString(displaySpecification.getConvertStr(), templateFileType);
                    }

                    // 差し込み変換用のケース
                    if (displaySpecification.getConvertStr().startsWith(configGenVm().getPlubTextStr())) {
                        example = PlugTextConverter.createPlugTextString(example, displaySpecification.getConvertStr(), templateFileType);
                    }
                }

                /*
                 * 出し分け仕様を反映していく
                 */
                for (SeparateOutSpecification separateOutSpecification : separateOutSpecificationList) {
                    if (isNotTarget(sampleMail.getNo(), separateOutSpecification.getNo(), separateOutSpecification.getNos())) {
                        continue;
                    }

                    String systemConvertStrTarget = VarExpression.exp(separateOutSpecification.getSystemConvertStrTarget(), templateFileType);
                    String systemExpression = separateOutSpecification.getSystemExpression();

                    if (separateOutSpecification.isNewLineExists()) {
                        // 行番号が一致していたら、丸ごと置換
                        if (sampleMail.getNo() == separateOutSpecification.getNo() || isWithin(separateOutSpecification.getNos(), sampleMail.getNo())) {
                            example = systemExpression;
                        }
                    } else {
                        // 丸ごとではない場合は、置換対象ターゲットが一致していたら、その部分をシステム表現で置換
                        if (example.contains(systemConvertStrTarget)) {
                            example = example.replace(systemConvertStrTarget, systemExpression);
                        }
                    }
                }

                convertResultList.add(example);
            }
        } catch (Exception e) {
            // TODO error handling.
            e.printStackTrace();
            return false;
        }

        return true;
    }

    private boolean isWithin(int[] whole, int target) {
        for (int a : whole) {
            if (a == target) return true;
        }
        return false;
    }

    private boolean isNotTarget(int sampleMailNo, int specificationNo, int[] specificationNos) {
        if (sampleMailNo == specificationNo) {
            return false;
        }
        if (specificationNos == null) {
            return true;
        }
        for (int no : specificationNos) {
            if (sampleMailNo == no) {
                return false;
            }
        }
        return true;
    }

    public List<SampleMail> getSampleMailList() {
        return sampleMailList;
    }

    public void setSampleMailList(List<SampleMail> sampleMailList) {
        this.sampleMailList = sampleMailList;
    }

    public List<DisplaySpecification> getDisplaySpecificationList() {
        return displaySpecificationList;
    }

    public void setDisplaySpecificationList(List<DisplaySpecification> displaySpecificationList) {
        this.displaySpecificationList = displaySpecificationList;
    }

    public List<SeparateOutSpecification> getSeparateOutSpecificationList() {
        return separateOutSpecificationList;
    }

    public void setSeparateOutSpecificationList(List<SeparateOutSpecification> separateOutSpecificationList) {
        this.separateOutSpecificationList = separateOutSpecificationList;
    }

    private String replaceByConvertStr(String example, String convertFrom, String convertTo, String templateFileType) {
        return example.replace(convertFrom, exp(convertTo, templateFileType));
    }

}
