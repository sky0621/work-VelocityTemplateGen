package xyz.skycat.work.VelocityTemplateGen.ae.construct.excel;

import xyz.skycat.work.VelocityTemplateGen.ae.construct.excel.element.DisplaySpecification;
import xyz.skycat.work.VelocityTemplateGen.ae.construct.excel.element.SampleMail;
import xyz.skycat.work.VelocityTemplateGen.ae.construct.excel.element.SeparateOutSpecification;

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

    private String templateFileComment;

    private String templateSetString;

    // メール文例
    private List<SampleMail> sampleMailList;

    // 表示仕様
    private List<DisplaySpecification> displaySpecificationList;

    // 出し分け仕様
    private List<SeparateOutSpecification> separateOutSpecificationList;

    public VelocityTemplate() {
        sampleMailList = new ArrayList<>();
        displaySpecificationList = new ArrayList<>();
        separateOutSpecificationList = new ArrayList<>();
    }

    public String getTemplateFileName() {
        String parts = "";
        if (!configGenVm().getTemplateFileTypeMain().equals(templateFileType)) {
            parts = File.separator + "parts";
        }
        return configGenVm().getOutputDir() + parts + File.separator + templateFileName + configGenVm().getOutputFileSuffix();
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

    public String getTemplateFileComment() {
        return templateFileComment;
    }

    public void setTemplateFileComment(String templateFileComment) {
        this.templateFileComment = templateFileComment;
    }

    public String getTemplateSetString() {
        return templateSetString;
    }

    public void setTemplateSetString(String templateSetString) {
        this.templateSetString = templateSetString;
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
}
