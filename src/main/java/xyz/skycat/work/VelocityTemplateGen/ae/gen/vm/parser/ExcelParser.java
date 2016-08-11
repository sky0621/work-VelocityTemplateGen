package xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.parser;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.constructer.VelocityTemplate;
import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.parser.element.WorkbookParser;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

/**
 * Created by SS on 2016/08/12.
 */
public class ExcelParser {

    public Optional<List<Optional<VelocityTemplate>>> parse(Path excelFilePath) {

        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create(excelFilePath.toFile(), null, true);
        } catch (IOException e) {
            // TODO Logger使用
            e.printStackTrace();
            return null;
        } catch (InvalidFormatException e) {
            // TODO Logger使用
            e.printStackTrace();
            return null;
        }
        return Optional.ofNullable(new WorkbookParser().parse(workbook));
    }

}
