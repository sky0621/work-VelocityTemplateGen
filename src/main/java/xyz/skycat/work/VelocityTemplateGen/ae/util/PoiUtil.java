package xyz.skycat.work.VelocityTemplateGen.ae.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;

import java.util.ArrayList;
import java.util.List;

import static xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.expression.NoExpression.RANGE_VALUE_SEPS;

/**
 * Created by SS on 2016/08/13.
 */
public class PoiUtil {

    public static Object getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                return cell.getRichStringCellValue().getString();
            case Cell.CELL_TYPE_NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue();
                } else {
                    return cell.getNumericCellValue();
                }
            case Cell.CELL_TYPE_BOOLEAN:
                return cell.getBooleanCellValue();
            case Cell.CELL_TYPE_FORMULA:
                return cell.getCellFormula();
            default:
                return null;
        }
    }

    public static boolean getBooleanValue(Cell cell) {
        Object cellValue = getCellValue(cell);
        if (cellValue instanceof Boolean) {
            return cell.getBooleanCellValue();
        }
        return false;
    }

    public static int getRowNum(Cell noCell) {
        Object cellValue = getCellValue(noCell);
        if (cellValue instanceof Double) {
            return ((Double) cellValue).intValue();
        }
        return 0;
    }

    public static int[] getRowNums(Cell noCell, String splitter) {
        return split(getCellValue(noCell), splitter);
    }

    public static boolean splitCheck(Object cellValue, String splitter) {
        if (split(cellValue, splitter) == null) {
            return false;
        }
        return true;
    }

    public static int[] split(Object cellValue, String splitter) {
        if (cellValue == null) return null;
        if (!(cellValue instanceof String)) return null;
        int[] retNums = null;
        if (((String) cellValue).contains(splitter)) {
            String[] nums = ((String) cellValue).split(splitter);
            retNums = new int[nums.length];
            try {
                for (int i = 0; i < nums.length; i++) {
                    retNums[i] = Integer.parseInt(nums[i]);
                }
                // Oops...
                if (RANGE_VALUE_SEPS.equals(splitter)) {
                    List<Integer> retNumsList = new ArrayList<>();
                    int from = retNums[0];
                    int to = retNums[1];
                    while (from <= to) {
                        retNumsList.add(from);
                        from++;
                    }
                    if (retNumsList.size() > 0) {
                        int[] retNums2 = new int[retNumsList.size()];
                        for (int j = 0; j < retNumsList.size(); j++) {
                            retNums2[j] = retNumsList.get(j);
                        }
                        return retNums2;
                    }
                }
            } catch (NumberFormatException e) {
                // バッドノウハウ・・・
                // TODO Logger使用
                return null;
            }
        }
        return retNums;
    }

}
