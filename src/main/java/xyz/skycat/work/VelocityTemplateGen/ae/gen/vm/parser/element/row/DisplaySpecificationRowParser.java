package xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.parser.element.row;

import org.apache.poi.ss.usermodel.Row;
import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.constructer.VelocityTemplate;
import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.constructer.element.DisplaySpecification;
import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.parser.element.CellParser;
import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.parser.element.IfRowParser;

import static xyz.skycat.work.VelocityTemplateGen.ae.config.ConfigManager.configGenVm;

/**
 * Created by SS on 2016/08/13.
 */
public class DisplaySpecificationRowParser implements IfRowParser {

    // 副作用。。。
    public boolean parse(Row row, VelocityTemplate velocityTemplate) {

        if (configGenVm().getLineIdx_sampleMail() > row.getRowNum()) {
            return true;
        }

        // TODO 例外スロー？

        CellParser cellParser = new CellParser(velocityTemplate);
        cellParser.parse(new DisplaySpecification(
                row.getCell(configGenVm().getColIdx_displaySpecification_no()),
                row.getCell(configGenVm().getColIdx_displaySpecification_explain()),
                row.getCell(configGenVm().getColIdx_displaySpecification_targetStr()),
                row.getCell(configGenVm().getColIdx_displaySpecification_convertStr()),
                row.getCell(configGenVm().getColIdx_displaySpecification_convertType())
        ));

        return true;
    }

}
