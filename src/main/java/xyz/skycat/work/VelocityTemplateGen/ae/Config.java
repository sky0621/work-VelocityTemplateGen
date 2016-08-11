package xyz.skycat.work.VelocityTemplateGen.ae;

import java.nio.file.Path;

/**
 * Created by SS on 2016/08/12.
 */
public class Config {

    // VMファイル出力先（※プログラム実行時のパラメータから取得）
    private static Path outputPath;

    // VMファイルのインクルード時のパス
    private static String includeVMpath;

    // インクルードを表す置換変数の一部
    private static String includeConvertStr = "$INCLUDE$";

    // 置換変数に付加するプレフィックス
    private static String prefixConvertString = "bean.";

    // VMの種別が「本体」の場合の文字列
    private static String vmTypeMain = "本体";

    /**
     * 行に関する情報
     */
    // VMファイル名がある行
    private static int vmFileNameLineIndex = 1;

    // メール文例の解析をはじめる行
    private static int exampleSentenceStartLineIndex = 4;

    /**
     * 列に関する情報
     */
    /*
     * VMファイル自体
     */
    // VM物理ファイル名がある列Index
    private static int vmFileNameColumnIndex = 8;    // I列

    // VMが本体か部品であるかがある列Index
    private static int vmMainOrPartsColumnIndex = 9;    // J列

    /*
     * メール文例関連
     */
    // No列がある列Index
    private static int noColumnIndex = 0;

    // メール文例がある列Index
    private static int exampleColumnIndex = 2;

    /*
     * 表示仕様（置換）関連
     */
    // 表示仕様の解析をはじめる上でのマーキングを行うための文字列
    private static String displaySpecificationMarkingString = "表示仕様";

    // システムカラムの解析をはじめる上でのマーキングを行うための文字列
    private static String systemColumnMarkingString = "システム補足表示仕様";

    // スキップ対象のマーキング文字列
    private static String displaySpecificationSkipString = "項目番号";

    // 「項目番号」がある列Index
    private static int targetNoColumnIndex = 5;  // F列

    // 「説明」がある列Index
    private static int explainColumnIndex = 6;   // G列

    // 「置換対象」がある列Index
    private static int targetStrColumnIndex = 7; // H列

    // 「置換変数」がある列Index
    private static int convertStrColumnIndex = 8;    // I列

    // 「型」がある列Index
    private static int convertTypeColumnIndex = 9;   // J列

    /*
     * 出し分け（#if #else #end）仕様
     */
    // 出し分け仕様の解析をはじめる上でのマーキングを行うための文字列
    private static String dividedOutSpecificationMarkingString = "出し分け仕様";

    // スキップ対象のマーキング文字列
    private static String dividedOutSpecificationSkipString = "項目番号";

}
