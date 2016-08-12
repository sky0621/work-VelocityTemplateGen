package xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.parser.element.row;

import org.apache.poi.ss.usermodel.Row;
import xyz.skycat.work.VelocityTemplateGen.ae.ConfigManager;
import xyz.skycat.work.VelocityTemplateGen.ae.VelocityTemplateGenException;
import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.constructer.VelocityTemplate;
import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.constructer.element.TemplateName;
import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.constructer.element.TemplateType;
import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.parser.element.CellParser;

/**
 * Created by SS on 2016/08/12.
 */
public class TitleRowParser {

    // 副作用。。。
    public boolean parse(Row row, VelocityTemplate velocityTemplate) {

        if (ConfigManager.configGenVm().getVmFileNameLineIndex() != row.getRowNum()) {
            return true;
        }

        CellParser cellParser = new CellParser(velocityTemplate);
        cellParser.parse(new TemplateName(row.getCell(ConfigManager.configGenVm().getVmFileNameColumnIndex())));
        cellParser.parse(new TemplateType(row.getCell(ConfigManager.configGenVm().getVmTypeColumnIndex())));

        return true;
    }

}
