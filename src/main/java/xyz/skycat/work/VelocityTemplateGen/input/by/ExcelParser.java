package xyz.skycat.work.VelocityTemplateGen.input.by;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import xyz.skycat.work.VelocityTemplateGen.Config;
import xyz.skycat.work.VelocityTemplateGen.construction.ExampleSentence;
import xyz.skycat.work.VelocityTemplateGen.input.Parser;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SS on 2016/08/07.
 */
public class ExcelParser implements Parser {

    public List<ExampleSentence> parse(Path inputPath) throws IOException, InvalidFormatException {

        List<ExampleSentence> exampleSentenceList = new ArrayList();

        Workbook workbook = WorkbookFactory.create(inputPath.toFile());
        for (Sheet sheet : workbook) {
            for (Row row : sheet) {
                int rowNum = row.getRowNum();
                if (rowNum < Config.exampleSentenceStartRowNum) {
                    continue;
                }
                Cell noCell = row.getCell(0);
                if (checkErrorNoCell(noCell)) {
                    continue;
                }
                Cell exampleCell = row.getCell(2);
                if (checkErrorExampleCell(exampleCell)) {
                    continue;
                }
                ExampleSentence exampleSentence = new ExampleSentence(getRowNum(noCell), getExampleSentence(exampleCell));
                exampleSentenceList.add(exampleSentence);
            }
        }
        return exampleSentenceList;
    }

    private boolean checkErrorNoCell(Cell noCell) {
        if (noCell == null) {
            return true;
        }
        try {
            Object cellValue = getCellValue(noCell);
            if (cellValue instanceof Double) {
                Double dVal = (Double) cellValue;
                dVal.intValue();
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    private int getRowNum(Cell noCell) {
        return ((Double) getCellValue(noCell)).intValue();
    }

    private boolean checkErrorExampleCell(Cell exampleCell) {
        if (exampleCell == null) {
            return true;
        }
        try {
            Object cellValue = getCellValue(exampleCell);
            if (cellValue == null) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
        return false;
    }

    private String getExampleSentence(Cell exampleCell) {
        return exampleCell.getStringCellValue() == null ? "" : exampleCell.getStringCellValue();
    }

    private static Object getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                return cell.getRichStringCellValue().getString();
            case Cell.CELL_TYPE_NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue();
                } else {
                    return cell.getNumericCellValue();
                }
            case Cell.CELL_TYPE_BOOLEAN:
                return cell.getBooleanCellValue();
            case Cell.CELL_TYPE_FORMULA:
                return cell.getCellFormula();
            default:
                return null;
        }
    }

}
