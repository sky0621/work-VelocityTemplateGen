package xyz.skycat.work.VelocityTemplateGen.construction;

import xyz.skycat.work.VelocityTemplateGen.Config;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SS on 2016/08/07.
 */
public class VelocityTemplateInfo {

    private String fileName;

    public List<ExampleSentence> exampleSentenceList;

    public List<ConvertInfo> convertInfoList;

    public VelocityTemplateInfo() {
        this.exampleSentenceList = new ArrayList();
        this.convertInfoList = new ArrayList();
    }

    public VelocityTemplateInfo(String fileName) {
        this.fileName = fileName;
        this.exampleSentenceList = new ArrayList();
        this.convertInfoList = new ArrayList();
    }

    public void setFileName(String fileName) {
        if (fileName == null || "".equals(fileName)) return;
        this.fileName = Config.outputPath.toFile().getAbsolutePath() + "\\" + fileName + ".vm";
    }

    public String getFileName() {
        return fileName;
    }

}
