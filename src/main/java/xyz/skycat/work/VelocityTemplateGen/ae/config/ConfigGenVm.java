package xyz.skycat.work.VelocityTemplateGen.ae.config;

/**
 * Created by SS on 2016/08/12.
 */
public class ConfigGenVm {

    // Excel格納ディレクトリ
    private String inputDir;

    // VM出力ディレクトリ
    private String outputDir;

    /*
     * 行インデックス
     */
    // VMファイル名がある行
    private int lineIdx_templateFileName;

    // メール文例の解析をはじめる行
    private int lineIdx_sampleMail;

    /*
     * 列インデックス
     */
    // VM物理ファイル名がある列Index
    private int colIdx_templateFileName;    // I列

    // VMが本体か部品であるかがある列Index
    private int colIdx_templateFileType;    // J列

    // No列がある列Index
    private int colIdx_sampleMailNo;

    // メール文例がある列Index
    private int colIdx_sampleMailExample;

    // ----------------------------------------------------------------------------------------------------------------
    // ゲッター／セッター
    // ----------------------------------------------------------------------------------------------------------------

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

    public int getLineIdx_templateFileName() {
        return lineIdx_templateFileName;
    }

    public void setLineIdx_templateFileName(int lineIdx_templateFileName) {
        this.lineIdx_templateFileName = lineIdx_templateFileName;
    }

    public int getColIdx_templateFileName() {
        return colIdx_templateFileName;
    }

    public void setColIdx_templateFileName(int colIdx_templateFileName) {
        this.colIdx_templateFileName = colIdx_templateFileName;
    }

    public int getColIdx_templateFileType() {
        return colIdx_templateFileType;
    }

    public void setColIdx_templateFileType(int colIdx_templateFileType) {
        this.colIdx_templateFileType = colIdx_templateFileType;
    }

    public int getLineIdx_sampleMail() {
        return lineIdx_sampleMail;
    }

    public void setLineIdx_sampleMail(int lineIdx_sampleMail) {
        this.lineIdx_sampleMail = lineIdx_sampleMail;
    }

    public int getColIdx_sampleMailNo() {
        return colIdx_sampleMailNo;
    }

    public void setColIdx_sampleMailNo(int colIdx_sampleMailNo) {
        this.colIdx_sampleMailNo = colIdx_sampleMailNo;
    }

    public int getColIdx_sampleMailExample() {
        return colIdx_sampleMailExample;
    }

    public void setColIdx_sampleMailExample(int colIdx_sampleMailExample) {
        this.colIdx_sampleMailExample = colIdx_sampleMailExample;
    }
}
