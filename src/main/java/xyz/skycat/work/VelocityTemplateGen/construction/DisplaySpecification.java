package xyz.skycat.work.VelocityTemplateGen.construction;

import xyz.skycat.work.VelocityTemplateGen.Config;

/**
 * Created by SS on 2016/08/07.
 */
public class DisplaySpecification {

    // 項目番号
    public int rowNum;

    // 説明
    public String explain;

    // 置換対象
    public String targetString;

    // 置換変数
    public String convertString;

    // 型
    public String convertType;

    public DisplaySpecification() {

    }

    public DisplaySpecification(
            int rowNum,
            String explain,
            String targetString,
            String convertString,
            String convertType) {
        this.rowNum = rowNum;
        this.explain = explain;
        this.targetString = targetString;
        if(convertString.contains(Config.includeConvertStr)) {
            this.convertString = convertString;
        }else {
            this.convertString = "$!{" + Config.prefixConvertString + convertString + "}";
        }
        this.convertType = convertType;
    }

}
