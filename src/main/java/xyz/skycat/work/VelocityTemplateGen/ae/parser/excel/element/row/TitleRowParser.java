package xyz.skycat.work.VelocityTemplateGen.ae.parser.excel.element.row;

import org.apache.poi.ss.usermodel.Row;
import xyz.skycat.work.VelocityTemplateGen.ae.construct.excel.VelocityTemplate;
import xyz.skycat.work.VelocityTemplateGen.ae.construct.excel.element.TemplateFileName;
import xyz.skycat.work.VelocityTemplateGen.ae.construct.excel.element.TemplateFileType;
import xyz.skycat.work.VelocityTemplateGen.ae.construct.excel.element.TemplateSetString;
import xyz.skycat.work.VelocityTemplateGen.ae.parser.excel.element.CellParser;
import xyz.skycat.work.VelocityTemplateGen.ae.parser.excel.element.IfRowParser;

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
        cellParser.parse(new TemplateFileName(row.getCell(configGenVm().getColIdx_templateFileName())));
        cellParser.parse(new TemplateFileType(row.getCell(configGenVm().getColIdx_templateFileType())));
        cellParser.parse(new TemplateSetString(row.getCell(configGenVm().getColIdx_templateSetString())));

        return true;
    }

}
