package xyz.skycat.work.VelocityTemplateGen.ae.util;

import java.util.List;

/**
 * Created by SS on 2016/08/17.
 */
public class VarUtil {

    public static String list2String(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String convertResult : list) {
            sb.append(convertResult).append(System.getProperty("line.separator"));
        }
        sb.delete(sb.lastIndexOf(System.getProperty("line.separator")), sb.length());
        return sb.toString();
    }

    public static boolean isWithin(int[] whole, int target) {
        for (int a : whole) {
            if (a == target) return true;
        }
        return false;
    }

}
