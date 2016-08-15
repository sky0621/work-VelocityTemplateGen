package xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.parser.element.row;

import org.apache.poi.ss.usermodel.Row;
import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.constructer.VelocityTemplate;
import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.constructer.element.SeparateOutSpecification;
import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.parser.element.CellParser;
import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.parser.element.IfRowParser;

import static xyz.skycat.work.VelocityTemplateGen.ae.config.ConfigManager.configGenVm;

/**
 * Created by SS on 2016/08/15.
 */
public class SeparateOutSpecificationRowParser implements IfRowParser {

    @Override
    public boolean parse(Row row, VelocityTemplate velocityTemplate) {

        if (configGenVm().getLineIdx_sampleMail() > row.getRowNum()) {
            return true;
        }

        // TODO 例外スロー？

        CellParser cellParser = new CellParser(velocityTemplate);
        cellParser.parse(new SeparateOutSpecification(
                row.getCell(configGenVm().getColIdx_separateOutSpecification_no()),
                row.getCell(configGenVm().getColIdx_separateOutSpecification_explain()),
                row.getCell(configGenVm().getColIdx_separateOutSpecification_condition()),
                row.getCell(configGenVm().getColIdx_separateOutSpecification_systemConvertStrTarget()),
                row.getCell(configGenVm().getColIdx_separateOutSpecification_systemExpression()),
                row.getCell(configGenVm().getColIdx_separateOutSpecification_convertMethod())
        ));

        return true;
    }

}
