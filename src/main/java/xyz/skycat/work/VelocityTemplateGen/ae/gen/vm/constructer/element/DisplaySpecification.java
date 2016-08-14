package xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.constructer.element;

import org.apache.poi.ss.usermodel.Cell;
import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.constructer.VelocityTemplate;
import xyz.skycat.work.VelocityTemplateGen.ae.util.PoiUtil;

import static xyz.skycat.work.VelocityTemplateGen.ae.config.ConfigManager.configGenVm;
import static xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.expression.NoExpression.EACH_VALUE_SEPS;
import static xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.expression.NoExpression.RANGE_VALUE_SEPS;

/**
 * Created by SS on 2016/08/12.
 */
public class DisplaySpecification implements IfVelocityTemplateElement {

    private static boolean displaySpecificationParseOn = false;

    private Cell noCell;

    private Cell explainCell;

    private Cell targetStrCell;

    private Cell convertStrCell;

    private Cell convertTypeCell;

    private int[] nos;

    private int no;

    private String explain;

    private String targetStr;

    private String convertStr;

    private String convertType;

    public DisplaySpecification(Cell noCell, Cell explainCell, Cell targetStrCell, Cell convertStrCell, Cell convertTypeCell) {
        this.noCell = noCell;
        this.explainCell = explainCell;
        this.targetStrCell = targetStrCell;
        this.convertStrCell = convertStrCell;
        this.convertTypeCell = convertTypeCell;
    }

    @Override
    public void doProcess(VelocityTemplate velocityTemplate) {

        if (checkErrorTargetNoCell(noCell)) {
            // TODO Logger使用
            return;
        }

        if (displaySpecificationParseOn) {
            velocityTemplate.getDisplaySpecificationList().add(this);
            expand();
        }
    }

    private boolean checkErrorTargetNoCell(Cell noCell) {
        if (noCell == null) {
            return true;
        }
        try {
            Object cellValue = PoiUtil.getCellValue(noCell);
            if (cellValue instanceof String) {
                if (configGenVm().getMarkingString_displaySpecification().equals((String) cellValue)) {
                    displaySpecificationParseOn = true;
                }
                if (!PoiUtil.splitCheck(cellValue, EACH_VALUE_SEPS)) {
                    return false;
                }
                if (!PoiUtil.splitCheck(cellValue, RANGE_VALUE_SEPS)) {
                    return false;
                }
                return true;
            }
            if (cellValue instanceof Double) {
                Double dVal = (Double) cellValue;
                dVal.intValue();
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public static boolean isDisplaySpecificationParseOn() {
        return displaySpecificationParseOn;
    }

    public static void setDisplaySpecificationParseOn(boolean displaySpecificationParseOn) {
        DisplaySpecification.displaySpecificationParseOn = displaySpecificationParseOn;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int[] getNos() {
        return nos;
    }

    public void setNos(int[] nos) {
        this.nos = nos;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getTargetStr() {
        return targetStr;
    }

    public void setTargetStr(String targetStr) {
        this.targetStr = targetStr;
    }

    public String getConvertStr() {
        return convertStr;
    }

    public void setConvertStr(String convertStr) {
        this.convertStr = convertStr;
    }

    public String getConvertType() {
        return convertType;
    }

    public void setConvertType(String convertType) {
        this.convertType = convertType;
    }

    private void expand() {
        if (noCell != null) {
            setNo(PoiUtil.getRowNum(noCell));
            if (getNo() == 0) {
                setNos(PoiUtil.getRowNums(noCell, EACH_VALUE_SEPS));
                if (getNos() == null) {
                    setNos(PoiUtil.getRowNums(noCell, RANGE_VALUE_SEPS));
                }
            }
        }
        if (explainCell != null) {
            setExplain(explainCell.getStringCellValue());
        }
        if (targetStrCell != null) {
            setTargetStr(targetStrCell.getStringCellValue());
        }
        if (convertStrCell != null) {
            setConvertStr(convertStrCell.getStringCellValue());
        }
        if (convertTypeCell != null) {
            setConvertType(convertTypeCell.getStringCellValue());
        }
    }

}
