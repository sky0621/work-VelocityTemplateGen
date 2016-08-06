package xyz.skycat.work.VelocityTemplateGen.input.by;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import xyz.skycat.work.VelocityTemplateGen.input.Parser;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by SS on 2016/08/07.
 */
public class ExcelParser implements Parser {

    public List<Map<Integer, String>> parse(Path inputPath) throws IOException, InvalidFormatException {

        List<Map<Integer, String>> exampleSentenceList = new ArrayList<Map<Integer, String>>();

        Workbook workbook = WorkbookFactory.create(inputPath.toFile());
        for(Sheet sheet : workbook) {
            for (Row row : sheet) {
                int rowNum = row.getRowNum();
                System.out.println(rowNum);
                Cell cell = row.getCell(2);
                System.out.println(cell.getStringCellValue());
            }
        }
        return exampleSentenceList;
    }

}
