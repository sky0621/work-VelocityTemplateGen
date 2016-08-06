package xyz.skycat.work.VelocityTemplateGen.construction;

/**
 * Created by SS on 2016/08/07.
 */
public class ConvertInfo {

    public int rowNum;

    public String targetString;

    public String convertString;

    public ConvertInfo() {

    }

    public ConvertInfo(int rowNum, String targetString, String convertString) {
        this.rowNum = rowNum;
        this.targetString = targetString;
        this.convertString = "$!{" + convertString + "}";
    }

}
