package xyz.skycat.work.VelocityTemplateGen.ae.parser.excel;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import xyz.skycat.work.VelocityTemplateGen.ae.construct.excel.VelocityTemplate;
import xyz.skycat.work.VelocityTemplateGen.ae.parser.excel.element.WorkbookParser;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

/**
 * Created by SS on 2016/08/12.
 */
public class MailDefinitionExcelParser {

    public Optional<List<Optional<VelocityTemplate>>> parse(Path excelFilePath) {

        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create(excelFilePath.toFile(), null, true);
        } catch (IOException e) {
            // TODO Logger使用
            return null;
        } catch (InvalidFormatException e) {
            // TODO Logger使用
            return null;
        }
        return Optional.ofNullable(new WorkbookParser().parse(workbook));
    }

}
