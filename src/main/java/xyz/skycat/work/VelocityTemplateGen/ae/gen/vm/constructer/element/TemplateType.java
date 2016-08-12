package xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.constructer.element;

import org.apache.poi.ss.usermodel.Cell;
import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.constructer.VelocityTemplate;

/**
 * Created by SS on 2016/08/12.
 */
public class TemplateType implements VelocityTemplateElement {

    private Cell cell;

    public TemplateType(Cell cell) {
        this.cell = cell;
    }

    @Override
    public void doProcess(VelocityTemplate velocityTemplate) {

        // TODO チェック処理など

        velocityTemplate.setVmType(cell.getStringCellValue());
    }

}
