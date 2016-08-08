package xyz.skycat.work.VelocityTemplateGen.construction;

import xyz.skycat.work.VelocityTemplateGen.Config;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SS on 2016/08/07.
 */
public class VelocityTemplateInfo {

    private String fileName;

    private boolean vmTypeMain;

    public List<ExampleSentence> exampleSentenceList;

    public List<DisplaySpecification> displaySpecificationList;

    public VelocityTemplateInfo() {
        this.exampleSentenceList = new ArrayList();
        this.displaySpecificationList = new ArrayList();
    }

    public void setFileName(String fileName) {
        if (fileName == null || "".equals(fileName)) return;
        this.fileName = Config.outputPath.toFile().getAbsolutePath() + "\\" + fileName + ".vm";
    }

    public String getFileName() {
        return fileName;
    }

    public void setVmType(String vmType) {
        if (vmType == null || "".equals(vmType)) return;
        this.vmTypeMain = vmType.equals(Config.vmTypeMain);
    }

    public boolean isVmTypeMain() {
        return this.vmTypeMain;
    }

}
