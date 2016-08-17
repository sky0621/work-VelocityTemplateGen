package xyz.skycat.work.VelocityTemplateGen.ae.construct.excel.element;

import org.apache.poi.ss.usermodel.Cell;
import xyz.skycat.work.VelocityTemplateGen.ae.construct.excel.VelocityTemplate;

/**
 * Created by SS on 2016/08/18.
 */
public class TemplateFileComment implements IfVelocityTemplateElement {

    private Cell cell;

    public TemplateFileComment(Cell cell) {
        this.cell = cell;
    }

    @Override
    public void doProcess(VelocityTemplate velocityTemplate) {

        // TODO チェック処理など

        velocityTemplate.setTemplateFileComment(cell.getStringCellValue());
    }

}
