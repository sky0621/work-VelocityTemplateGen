package xyz.skycat.work.VelocityTemplateGen.ae.construct.excel.element;

import org.apache.poi.ss.usermodel.Cell;
import xyz.skycat.work.VelocityTemplateGen.ae.construct.excel.VelocityTemplate;

/**
 * Created by SS on 2016/08/17.
 */
public class TemplateSetString implements IfVelocityTemplateElement {

    private Cell cell;

    public TemplateSetString(Cell cell) {
        this.cell = cell;
    }

    @Override
    public void doProcess(VelocityTemplate velocityTemplate) {

        // TODO チェック処理など

        if (cell != null) {
            velocityTemplate.setTemplateSetString(cell.getStringCellValue());
        }
    }

}
