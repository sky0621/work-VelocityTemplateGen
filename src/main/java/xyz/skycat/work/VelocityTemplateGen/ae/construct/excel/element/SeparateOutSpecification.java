package xyz.skycat.work.VelocityTemplateGen.ae.construct.excel.element;

import org.apache.poi.ss.usermodel.Cell;
import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.SeparateOutSpecificationConvertMethod;
import xyz.skycat.work.VelocityTemplateGen.ae.construct.excel.VelocityTemplate;
import xyz.skycat.work.VelocityTemplateGen.ae.util.PoiUtil;

import static xyz.skycat.work.VelocityTemplateGen.ae.config.ConfigManager.configGenVm;
import static xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.expression.NoExpression.EACH_VALUE_SEPS;
import static xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.expression.NoExpression.RANGE_VALUE_SEPS;

/**
 * Created by SS on 2016/08/12.
 */
public class SeparateOutSpecification implements IfVelocityTemplateElement {

    private static boolean separateOutSpecificationParseOn = false;

    private Cell noCell;

    private Cell explainCell;

    private Cell conditionCell;

    private Cell systemConvertStrTargetCell;

    private Cell systemExpressionCell;

    private Cell convertMethodCell;

    private int[] nos;

    private int no;

    private String explain;

    private String condition;

    private String systemConvertStrTarget;

    private String systemExpression;

    private SeparateOutSpecificationConvertMethod convertMethod;

    public SeparateOutSpecification(
            Cell noCell,
            Cell explainCell,
            Cell conditionCell,
            Cell systemConvertStrTargetCell,
            Cell systemExpressionCell,
            Cell convertMethodCell) {
        this.noCell = noCell;
        this.explainCell = explainCell;
        this.conditionCell = conditionCell;
        this.systemConvertStrTargetCell = systemConvertStrTargetCell;
        this.systemExpressionCell = systemExpressionCell;
        this.convertMethodCell = convertMethodCell;
    }

    @Override
    public void doProcess(VelocityTemplate velocityTemplate) {

        if (checkErrorTargetNoCell(noCell)) {
            // TODO Logger使用
            return;
        }

        if (separateOutSpecificationParseOn) {
            velocityTemplate.getSeparateOutSpecificationList().add(this);
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
                if (configGenVm().getMarkingString_separateOutSpecification().equals((String) cellValue)) {
                    separateOutSpecificationParseOn = true;
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

    public static boolean isSeparateOutSpecificationParseOn() {
        return separateOutSpecificationParseOn;
    }

    public static void setSeparateOutSpecificationParseOn(boolean separateOutSpecificationParseOn) {
        SeparateOutSpecification.separateOutSpecificationParseOn = separateOutSpecificationParseOn;
    }

    public int[] getNos() {
        return nos;
    }

    public void setNos(int[] nos) {
        this.nos = nos;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getSystemConvertStrTarget() {
        return systemConvertStrTarget;
    }

    public void setSystemConvertStrTarget(String systemConvertStrTarget) {
        this.systemConvertStrTarget = systemConvertStrTarget;
    }

    public String getSystemExpression() {
        return systemExpression;
    }

    public void setSystemExpression(String systemExpression) {
        this.systemExpression = systemExpression;
    }

    public SeparateOutSpecificationConvertMethod getConvertMethod() {
        return convertMethod;
    }

    public void setConvertMethod(SeparateOutSpecificationConvertMethod convertMethod) {
        this.convertMethod = convertMethod;
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
        if (conditionCell != null) {
            setCondition(conditionCell.getStringCellValue());
        }
        if (systemConvertStrTargetCell != null) {
            setSystemConvertStrTarget(systemConvertStrTargetCell.getStringCellValue());
        }
        if (systemExpressionCell != null) {
            setSystemExpression(systemExpressionCell.getStringCellValue());
        }
        if (convertMethodCell != null) {
            setConvertMethod(PoiUtil.getSeparateOutSpecificationConvertMethod(convertMethodCell));
        }
    }

}
