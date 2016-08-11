package xyz.skycat.work.VelocityTemplateGen.ae;

/**
 * Created by SS on 2016/08/12.
 */
public class ConfigGenVm {

    private String inputDir;

    private String outputDir;

    public String getInputDir() {
        return inputDir;
    }

    public void setInputDir(String inputDir) {
        // TODO ユーザインプットなのでチェック処理を入れる！
        this.inputDir = inputDir;
    }

    public String getOutputDir() {
        return outputDir;
    }

    public void setOutputDir(String outputDir) {
        // TODO ユーザインプットなのでチェック処理を入れる！
        this.outputDir = outputDir;
    }

}
