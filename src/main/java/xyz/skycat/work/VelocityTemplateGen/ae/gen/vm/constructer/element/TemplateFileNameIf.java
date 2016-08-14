package xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.constructer.element;

import org.apache.poi.ss.usermodel.Cell;
import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.constructer.VelocityTemplate;

/**
 * Created by SS on 2016/08/12.
 */
public class TemplateFileNameIf implements IfVelocityTemplateElement {

    private Cell cell;

    public TemplateFileNameIf(Cell cell) {
        this.cell = cell;
    }

    @Override
    public void doProcess(VelocityTemplate velocityTemplate) {

        // TODO チェック処理など

        velocityTemplate.setTemplateFileName(cell.getStringCellValue());
    }

}
