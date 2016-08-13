package xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.constructer.element;

import org.apache.poi.ss.usermodel.Cell;
import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.constructer.VelocityTemplate;
import xyz.skycat.work.VelocityTemplateGen.ae.util.PoiUtil;

import static xyz.skycat.work.VelocityTemplateGen.ae.config.ConfigManager.configGenVm;

/**
 * Created by SS on 2016/08/12.
 */
public class DisplaySpecification implements VelocityTemplateElement {

    private static boolean displaySpecificationParseOn = false;

    private Cell noCell;

    private Cell explainCell;

    private Cell targetStrCell;

    private Cell convertStrCell;

    private Cell convertTypeCell;

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

        if(displaySpecificationParseOn) {
            velocityTemplate.getDisplaySpecificationList().add(this);
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
}
