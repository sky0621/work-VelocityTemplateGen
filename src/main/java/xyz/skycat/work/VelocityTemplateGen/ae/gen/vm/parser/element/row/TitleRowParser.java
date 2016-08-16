package xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.parser.element.row;

import org.apache.poi.ss.usermodel.Row;
import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.constructer.VelocityTemplate;
import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.constructer.element.TemplateFileNameIf;
import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.constructer.element.TemplateFileTypeIf;
import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.constructer.element.TemplateSetString;
import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.parser.element.CellParser;
import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.parser.element.IfRowParser;

import static xyz.skycat.work.VelocityTemplateGen.ae.config.ConfigManager.configGenVm;

/**
 * Created by SS on 2016/08/12.
 */
public class TitleRowParser implements IfRowParser {

    // 副作用。。。
    public boolean parse(Row row, VelocityTemplate velocityTemplate) {

        if (configGenVm().getLineIdx_templateFileName() != row.getRowNum()) {
            return true;
        }

        // TODO 例外スロー？

        CellParser cellParser = new CellParser(velocityTemplate);
        cellParser.parse(new TemplateFileNameIf(row.getCell(configGenVm().getColIdx_templateFileName())));
        cellParser.parse(new TemplateFileTypeIf(row.getCell(configGenVm().getColIdx_templateFileType())));
        cellParser.parse(new TemplateSetString(row.getCell(configGenVm().getColIdx_templateSetString())));

        return true;
    }

}
