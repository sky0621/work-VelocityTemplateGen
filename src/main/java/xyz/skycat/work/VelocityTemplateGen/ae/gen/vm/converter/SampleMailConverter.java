package xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.converter;

import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.constructer.element.DisplaySpecification;
import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.constructer.element.SampleMail;

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

    private String templateFileType;

    private List<String> convertResultList;

    public SampleMailConverter(List<SampleMail> sampleMailList, List<DisplaySpecification> displaySpecificationList, String templateFileType) {
        this.sampleMailList = sampleMailList;
        this.displaySpecificationList = displaySpecificationList;
        this.templateFileType = templateFileType;
        convertResultList = new ArrayList<>();
    }

    private void aggregateResult(String src) {
        convertResultList.add(src);
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

            /*
             * メール文例の変動項目を置換変数に変えていく
             */
            for (SampleMail sampleMail : sampleMailList) {
                String example = sampleMail.getExample();
                for (DisplaySpecification displaySpecification : displaySpecificationList) {
                    if (isNotTarget(sampleMail.getNo(), displaySpecification.getNo(), displaySpecification.getNos())) {
                        continue;
                    }

                    // 変動項目を $ 変数置換
                    example = replaceByConvertStr(example, displaySpecification.getTargetStr(), displaySpecification.getConvertStr());

                    // インクルード変換用のケース
                    if (displaySpecification.getConvertStr().startsWith(configGenVm().getIncludeConvertStr())) {
                        example = IncludeConverter.createIncludeString(displaySpecification.getConvertStr(), templateFileType);
                    }

                    // 差し込み変換用のケース
                    if (displaySpecification.getConvertStr().startsWith(configGenVm().getPlubTextStr())) {
                        example = PlugTextConverter.createPlugTextString(example, displaySpecification.getConvertStr());
                        if (convertResultList.contains(example)) {
                            example = "<<<追加しない>>>";
                            continue;
                        }
                    }
                }
                if(!"<<<追加しない>>>".equals(example)) {
                    aggregateResult(example);
                }
            }
        } catch (Exception e) {
            // TODO error handling.
            e.printStackTrace();
            return false;
        }

        return true;
    }

    private boolean isNotTarget(int sampleMailNo, int displaySpecificationNo, int[] displaySpecificationNos) {
        if (sampleMailNo == displaySpecificationNo) {
            return false;
        }
        if (displaySpecificationNos == null) {
            return true;
        }
        for (int no : displaySpecificationNos) {
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

    private String replaceByConvertStr(String example, String convertFrom, String convertTo) {
        return example.replace(convertFrom, exp(convertTo));
    }

}
