package xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.constructer;

import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.constructer.element.SampleMail;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SS on 2016/08/12.
 */
public class VelocityTemplate {

    private String templateFileName;

    private String templateFileType;

    private List<SampleMail> sampleMailList;

    public VelocityTemplate() {
        sampleMailList = new ArrayList<>();
    }

    public String getTemplateFileName() {
        return templateFileName;
    }

    public void setTemplateFileName(String templateFileName) {
        this.templateFileName = templateFileName;
    }

    public String getTemplateFileType() {
        return templateFileType;
    }

    public void setTemplateFileType(String templateFileType) {
        this.templateFileType = templateFileType;
    }

    public List<SampleMail> getSampleMailList() {
        return sampleMailList;
    }

    public void setSampleMailList(List<SampleMail> sampleMailList) {
        this.sampleMailList = sampleMailList;
    }
}
