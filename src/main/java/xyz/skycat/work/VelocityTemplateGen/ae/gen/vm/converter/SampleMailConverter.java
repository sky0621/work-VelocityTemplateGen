package xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.converter;

import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.constructer.VelocityTemplate;
import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.constructer.element.DisplaySpecification;
import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.constructer.element.SampleMail;
import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.constructer.element.SeparateOutSpecification;
import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.expression.VarExpression;
import xyz.skycat.work.VelocityTemplateGen.ae.util.VarUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    private String templateSetString;

    private List<String> convertResultList;

    public SampleMailConverter(VelocityTemplate velocityTemplate) {
        sampleMailList = velocityTemplate.getSampleMailList();
        displaySpecificationList = velocityTemplate.getDisplaySpecificationList();
        templateFileType = velocityTemplate.getTemplateFileType();
        templateSetString = velocityTemplate.getTemplateSetString();
        separateOutSpecificationList = velocityTemplate.getSeparateOutSpecificationList();
        convertResultList = new ArrayList<>();
    }

    public String getResult() {
        String res = VarUtil.list2String(convertResultList);
        return res;
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
                        example = IncludeConverter.createIncludeString(displaySpecification.getConvertStr(), templateFileType, templateSetString);
                    }

                    // 差し込み変換用のケース
                    if (displaySpecification.getConvertStr().startsWith(configGenVm().getPlubTextStr())) {
                        example = PlugTextConverter.createPlugTextString(example, displaySpecification.getConvertStr(), templateFileType);
                    }
                }

                convertResultList.add(example);
            }

            /*
             * 出し分け仕様を反映していく
             */
            for (SeparateOutSpecification separateOutSpecification : separateOutSpecificationList) {
                // ターゲットの行番号
                int targetNo = separateOutSpecification.getNo();
                int[] targetNos = separateOutSpecification.getNos();
                if (targetNo == 0 && (targetNos == null || targetNos.length == 0)) {
                    continue;
                }

                String systemConvertStrTarget = VarExpression.exp(separateOutSpecification.getSystemConvertStrTarget(), templateFileType);
                String systemExpression = separateOutSpecification.getSystemExpression();

                // 置換方式に応じて１行ないし複数行を置換
                switch (separateOutSpecification.getConvertMethod()) {
                    case TARGET_ONLY:
                        String orgElement = convertResultList.get(targetNo - 1);
                        String cgdElement = orgElement.replace(systemConvertStrTarget, systemExpression);
                        convertResultList.set(targetNo - 1, cgdElement);
                        break;
                    case LINE_REPLACE:
                        convertResultList.set(targetNo - 1, systemExpression);
                        break;
                    case ANYLINE_SURROUND:
                        String beforeText = null;
                        if (targetNos == null) {
                            beforeText = convertResultList.get(targetNo - 1);
                        } else {
                            /*
                             * 置換前の内容を１行の文字列化
                             */
                            List<String> beforeList = new ArrayList<>();
                            for (int from = targetNos[0] - 1; from < targetNos[targetNos.length - 1]; from++) {
                                beforeList.add(convertResultList.get(from));
                            }
                            beforeText = VarUtil.list2String(beforeList);
                        }
                        /*
                         * 置換後のシステム表現を１行の文字列化（※置換前の内容取込も行う）
                         */
                        String[] systemExpressions = systemExpression.split(System.getProperty("line.separator"));
                        // Oops...
                        if (systemExpressions != null && systemExpressions.length == 1) {
                            systemExpressions = systemExpression.split("\n");
                        }
                        List<String> afterList = new ArrayList<>();
                        for (String systemExpressionParts : systemExpressions) {
                            if ("[[[置換前の内容]]]".equals(systemExpressionParts)) {
                                afterList.add(beforeText);
                            } else {
                                afterList.add(systemExpressionParts);
                            }
                        }
                        String afterText = VarUtil.list2String(afterList);

                        // Ooooooooops........
                        boolean isSet = false;
                        if (targetNos == null) {
                            convertResultList.set(targetNo - 1, afterText);
                        } else {
                            for (int from = targetNos[0] - 1; from < targetNos[targetNos.length - 1]; from++) {
                                if (isSet) {
                                    convertResultList.set(from, "UUUunsetUUU");
                                } else {
                                    convertResultList.set(from, afterText);
                                    isSet = true;
                                }
                            }
                        }
                        break;
                    default:
                        // TODO Log?
                }
            }

            // 置換完了前に行ずれが起こるのを防ぐために付加しておいたダミー文言行を削除
            convertResultList = convertResultList.stream().filter(ele -> !ele.equals("UUUunsetUUU")).collect(Collectors.toList());

        } catch (Exception e) {
            // TODO error handling.
            e.printStackTrace();
            return false;
        }

        return true;
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
