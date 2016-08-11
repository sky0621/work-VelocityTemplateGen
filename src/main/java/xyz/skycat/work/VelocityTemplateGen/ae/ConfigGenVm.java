package xyz.skycat.work.VelocityTemplateGen.ae;

/**
 * Created by SS on 2016/08/12.
 */
public class ConfigGenVm {

    private String inputDir;

    private String outputDir;

    // VMファイル名がある行
    private int vmFileNameLineIndex = 1;

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

    public int getVmFileNameLineIndex() {
        return vmFileNameLineIndex;
    }

    public void setVmFileNameLineIndex(int vmFileNameLineIndex) {
        this.vmFileNameLineIndex = vmFileNameLineIndex;
    }
}
