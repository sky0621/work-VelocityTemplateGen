package xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.converter;

import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.constructer.element.DisplaySpecification;
import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.constructer.element.SampleMail;

import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.Comparator.reverseOrder;
import static xyz.skycat.work.VelocityTemplateGen.ae.config.ConfigManager.configGenVm;

/**
 * Created by SS on 2016/08/14.
 */
public class SampleMailConverter {

    private List<SampleMail> sampleMailList;

    private List<DisplaySpecification> displaySpecificationList;

    private String templateFileType;

    private StringBuilder sb;

    public SampleMailConverter(List<SampleMail> sampleMailList, List<DisplaySpecification> displaySpecificationList, String templateFileType) {
        this.sampleMailList = sampleMailList;
        this.displaySpecificationList = displaySpecificationList;
        this.templateFileType = templateFileType;
        sb = new StringBuilder();
    }

    private void aggregateResult(String src) {
        sb.append(src).append(System.getProperty("line.separator"));
    }

    public String getResult() {
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
                    if (sampleMail.getNo() == displaySpecification.getNo()) {
                        // 変動項目を $ 変数置換
                        example = replaceByConvertStr(example, displaySpecification.getTargetStr(), displaySpecification.getConvertStr());

                        // インクルード変換用のケース
                        if (displaySpecification.getConvertStr().startsWith(configGenVm().getIncludeConvertStr())) {
                            example = IncludeConverter.createIncludeString(displaySpecification.getConvertStr(), templateFileType);
                        }
                    }
                }
                aggregateResult(example);
            }
        } catch (Exception e) {
            // TODO error handling.
            e.printStackTrace();
            return false;
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
        return example.replace(convertFrom, "$!{" + convertTo + "}");
    }

}
