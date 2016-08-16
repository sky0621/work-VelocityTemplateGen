package xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.config;

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

    // 冒頭の部品セット文
    private int colIdx_templateSetString;   // L列

    // No列がある列Index
    private int colIdx_sampleMail_no;

    // メール文例がある列Index
    private int colIdx_sampleMail_example;

    // 「項目番号」がある列Index
    private int colIdx_displaySpecification_no;  // F列

    // 「説明」がある列Index
    private int colIdx_displaySpecification_explain;   // G列

    // 「置換対象」がある列Index
    private int colIdx_displaySpecification_targetStr; // H列

    // 「置換変数」がある列Index
    private int colIdx_displaySpecification_convertStr;    // I列

    // 「型」がある列Index
    private int colIdx_displaySpecification_convertType;   // J列

    private int colIdx_separateOutSpecification_no;

    private int colIdx_separateOutSpecification_explain;

    private int colIdx_separateOutSpecification_condition;

    private int colIdx_separateOutSpecification_systemConvertStrTarget;

    private int colIdx_separateOutSpecification_systemExpression;

    private int colIdx_separateOutSpecification_convertMethod;

    private String outputFileSuffix;

    /*
     * 解析行判定マーキング用
     */
    // 表示仕様の解析をはじめる上でのマーキングを行うための文字列
    private String markingString_displaySpecification;

    // 出し分け仕様の解析をはじめる上でのマーキングを行うための文字列
    private String markingString_separateOutSpecification;

    /*
     * その他
     */
    // インクルードを表す置換変数の一部
    private String includeConvertStr;

    // VMの種別が「本体」の場合の文字列
    private String templateFileTypeMain;

    // VMファイルのインクルード時のパス
    private String includeVMpath;

    // 差し込みファイルを表す置換変数の一部
    private String plubTextStr;

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

    public int getColIdx_templateSetString() {
        return colIdx_templateSetString;
    }

    public void setColIdx_templateSetString(int colIdx_templateSetString) {
        this.colIdx_templateSetString = colIdx_templateSetString;
    }

    public int getLineIdx_sampleMail() {
        return lineIdx_sampleMail;
    }

    public void setLineIdx_sampleMail(int lineIdx_sampleMail) {
        this.lineIdx_sampleMail = lineIdx_sampleMail;
    }

    public int getColIdx_sampleMail_no() {
        return colIdx_sampleMail_no;
    }

    public void setColIdx_sampleMail_no(int colIdx_sampleMail_no) {
        this.colIdx_sampleMail_no = colIdx_sampleMail_no;
    }

    public int getColIdx_sampleMail_example() {
        return colIdx_sampleMail_example;
    }

    public void setColIdx_sampleMail_example(int colIdx_sampleMail_example) {
        this.colIdx_sampleMail_example = colIdx_sampleMail_example;
    }

    public int getColIdx_displaySpecification_no() {
        return colIdx_displaySpecification_no;
    }

    public void setColIdx_displaySpecification_no(int colIdx_displaySpecification_no) {
        this.colIdx_displaySpecification_no = colIdx_displaySpecification_no;
    }

    public int getColIdx_displaySpecification_explain() {
        return colIdx_displaySpecification_explain;
    }

    public void setColIdx_displaySpecification_explain(int colIdx_displaySpecification_explain) {
        this.colIdx_displaySpecification_explain = colIdx_displaySpecification_explain;
    }

    public int getColIdx_displaySpecification_targetStr() {
        return colIdx_displaySpecification_targetStr;
    }

    public void setColIdx_displaySpecification_targetStr(int colIdx_displaySpecification_targetStr) {
        this.colIdx_displaySpecification_targetStr = colIdx_displaySpecification_targetStr;
    }

    public int getColIdx_displaySpecification_convertStr() {
        return colIdx_displaySpecification_convertStr;
    }

    public void setColIdx_displaySpecification_convertStr(int colIdx_displaySpecification_convertStr) {
        this.colIdx_displaySpecification_convertStr = colIdx_displaySpecification_convertStr;
    }

    public int getColIdx_displaySpecification_convertType() {
        return colIdx_displaySpecification_convertType;
    }

    public void setColIdx_displaySpecification_convertType(int colIdx_displaySpecification_convertType) {
        this.colIdx_displaySpecification_convertType = colIdx_displaySpecification_convertType;
    }

    public String getMarkingString_displaySpecification() {
        return markingString_displaySpecification;
    }

    public void setMarkingString_displaySpecification(String markingString_displaySpecification) {
        this.markingString_displaySpecification = markingString_displaySpecification;
    }

    public String getMarkingString_separateOutSpecification() {
        return markingString_separateOutSpecification;
    }

    public void setMarkingString_separateOutSpecification(String markingString_separateOutSpecification) {
        this.markingString_separateOutSpecification = markingString_separateOutSpecification;
    }

    public String getIncludeConvertStr() {
        return includeConvertStr;
    }

    public void setIncludeConvertStr(String includeConvertStr) {
        this.includeConvertStr = includeConvertStr;
    }

    public String getTemplateFileTypeMain() {
        return templateFileTypeMain;
    }

    public void setTemplateFileTypeMain(String templateFileTypeMain) {
        this.templateFileTypeMain = templateFileTypeMain;
    }

    public int getColIdx_separateOutSpecification_no() {
        return colIdx_separateOutSpecification_no;
    }

    public void setColIdx_separateOutSpecification_no(int colIdx_separateOutSpecification_no) {
        this.colIdx_separateOutSpecification_no = colIdx_separateOutSpecification_no;
    }

    public int getColIdx_separateOutSpecification_explain() {
        return colIdx_separateOutSpecification_explain;
    }

    public void setColIdx_separateOutSpecification_explain(int colIdx_separateOutSpecification_explain) {
        this.colIdx_separateOutSpecification_explain = colIdx_separateOutSpecification_explain;
    }

    public int getColIdx_separateOutSpecification_condition() {
        return colIdx_separateOutSpecification_condition;
    }

    public void setColIdx_separateOutSpecification_condition(int colIdx_separateOutSpecification_condition) {
        this.colIdx_separateOutSpecification_condition = colIdx_separateOutSpecification_condition;
    }

    public int getColIdx_separateOutSpecification_systemConvertStrTarget() {
        return colIdx_separateOutSpecification_systemConvertStrTarget;
    }

    public void setColIdx_separateOutSpecification_systemConvertStrTarget(int colIdx_separateOutSpecification_systemConvertStrTarget) {
        this.colIdx_separateOutSpecification_systemConvertStrTarget = colIdx_separateOutSpecification_systemConvertStrTarget;
    }

    public int getColIdx_separateOutSpecification_systemExpression() {
        return colIdx_separateOutSpecification_systemExpression;
    }

    public void setColIdx_separateOutSpecification_systemExpression(int colIdx_separateOutSpecification_systemExpression) {
        this.colIdx_separateOutSpecification_systemExpression = colIdx_separateOutSpecification_systemExpression;
    }

    public int getColIdx_separateOutSpecification_convertMethod() {
        return colIdx_separateOutSpecification_convertMethod;
    }

    public void setColIdx_separateOutSpecification_convertMethod(int colIdx_separateOutSpecification_convertMethod) {
        this.colIdx_separateOutSpecification_convertMethod = colIdx_separateOutSpecification_convertMethod;
    }

    public String getOutputFileSuffix() {
        return outputFileSuffix;
    }

    public void setOutputFileSuffix(String outputFileSuffix) {
        this.outputFileSuffix = outputFileSuffix;
    }

    public String getIncludeVMpath() {
        return includeVMpath;
    }

    public void setIncludeVMpath(String includeVMpath) {
        this.includeVMpath = includeVMpath;
    }

    public String getPlubTextStr() {
        return plubTextStr;
    }

    public void setPlubTextStr(String plubTextStr) {
        this.plubTextStr = plubTextStr;
    }
}
