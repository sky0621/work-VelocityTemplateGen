package xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.constructer;

import xyz.skycat.work.VelocityTemplateGen.ae.config.ConfigManager;
import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.constructer.element.DisplaySpecification;
import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.constructer.element.SampleMail;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static xyz.skycat.work.VelocityTemplateGen.ae.config.ConfigManager.configGenVm;

/**
 * Created by SS on 2016/08/12.
 */
public class VelocityTemplate {

    private String templateFileName;

    private String templateFileType;

    private List<SampleMail> sampleMailList;

    private List<DisplaySpecification> displaySpecificationList;

    public VelocityTemplate() {
        sampleMailList = new ArrayList<>();
        displaySpecificationList = new ArrayList<>();
    }

    public String getTemplateFileName() {
        return configGenVm().getOutputDir() + File.separator + templateFileName + configGenVm().getOutputFileSuffix();
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

    public List<DisplaySpecification> getDisplaySpecificationList() {
        return displaySpecificationList;
    }

    public void setDisplaySpecificationList(List<DisplaySpecification> displaySpecificationList) {
        this.displaySpecificationList = displaySpecificationList;
    }

}
