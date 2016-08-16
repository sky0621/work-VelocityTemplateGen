package xyz.skycat.work.VelocityTemplateGen.ae.parser.excel.element.row;

import org.apache.poi.ss.usermodel.Row;
import xyz.skycat.work.VelocityTemplateGen.ae.construct.excel.VelocityTemplate;
import xyz.skycat.work.VelocityTemplateGen.ae.construct.excel.element.SampleMail;
import xyz.skycat.work.VelocityTemplateGen.ae.parser.excel.element.CellParser;
import xyz.skycat.work.VelocityTemplateGen.ae.parser.excel.element.IfRowParser;

import static xyz.skycat.work.VelocityTemplateGen.ae.config.ConfigManager.configGenVm;

/**
 * Created by SS on 2016/08/13.
 */
public class SampleMailRowParser implements IfRowParser {

    // 副作用。。。
    public boolean parse(Row row, VelocityTemplate velocityTemplate) {

        if (configGenVm().getLineIdx_sampleMail() > row.getRowNum()) {
            return true;
        }

        // TODO 例外スロー？

        CellParser cellParser = new CellParser(velocityTemplate);
        cellParser.parse(new SampleMail(row.getCell(configGenVm().getColIdx_sampleMail_no()), row.getCell(configGenVm().getColIdx_sampleMail_example())));

        return true;
    }

}
