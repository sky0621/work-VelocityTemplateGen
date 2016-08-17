package xyz.skycat.work.VelocityTemplateGen.ae.construct.excel.element;

import org.apache.poi.ss.usermodel.Cell;
import xyz.skycat.work.VelocityTemplateGen.ae.construct.excel.VelocityTemplate;

/**
 * Created by SS on 2016/08/12.
 */
public class TemplateFileType implements IfVelocityTemplateElement {

    private Cell cell;

    public TemplateFileType(Cell cell) {
        this.cell = cell;
    }

    @Override
    public void doProcess(VelocityTemplate velocityTemplate) {

        // TODO チェック処理など

        velocityTemplate.setTemplateFileType(cell.getStringCellValue());
    }

}
