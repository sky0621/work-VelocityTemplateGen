package xyz.skycat.work.VelocityTemplateGen;

import java.nio.file.Path;

/**
 * Created by SS on 2016/08/06.
 */
public class Config {

    // VMファイル出力先（※プログラム実行時のパラメータから取得）
    public static Path outputPath;

    /**
     * 行に関する情報
     */
    // VMファイル名がある行
    public static int vmFileNameLineIndex = 1;

    // メール文例の解析をはじめる行
    public static int exampleSentenceStartLineIndex = 4;

    /**
     * 列に関する情報
     */
    /*
     * VMファイル自体
     */
    public static int vmFileNameColumnIndex = 7;

    /*
     * メール文例関連
     */
    // No列がある列Index
    public static int noColumnIndex = 0;

    // メール文例がある列Index
    public static int exampleColumnIndex = 2;

    /*
     * 置換情報関連
     */
    // 置換対象Noがある列Index
    public static int targetNoColumnIndex = 4;

    public static int targetStrColumnIndex = 5;

    public static int convertStrColumnIndex = 7;

}
