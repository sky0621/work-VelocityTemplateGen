package xyz.skycat.work.VelocityTemplateGen.input.by;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import xyz.skycat.work.VelocityTemplateGen.Config;
import xyz.skycat.work.VelocityTemplateGen.construction.ConvertInfo;
import xyz.skycat.work.VelocityTemplateGen.construction.ExampleSentence;
import xyz.skycat.work.VelocityTemplateGen.construction.VelocityTemplateInfo;
import xyz.skycat.work.VelocityTemplateGen.input.Parser;

import java.io.IOException;
import java.nio.file.Path;

/**
 * Created by SS on 2016/08/07.
 */
public class ExcelParser implements Parser {

    public VelocityTemplateInfo parse(Path inputPath) throws IOException, InvalidFormatException {

        VelocityTemplateInfo velocityTemplateInfo = new VelocityTemplateInfo();

        Workbook workbook = WorkbookFactory.create(inputPath.toFile());
        for (Sheet sheet : workbook) {
            for (Row row : sheet) {
                int rowNum = row.getRowNum();
                if (rowNum == Config.vmFileNameLineIndex) {
                    Cell vmFileNameCell = row.getCell(Config.vmFileNameColumnIndex);
                    velocityTemplateInfo.setFileName(vmFileNameCell.getStringCellValue());
                }
                if (rowNum < Config.exampleSentenceStartLineIndex) {
                    continue;
                }
                Cell noCell = row.getCell(Config.noColumnIndex);
                if (checkErrorNoCell(noCell)) {
                    continue;
                }
                Cell exampleCell = row.getCell(Config.exampleColumnIndex);
                if (checkErrorExampleCell(exampleCell)) {
                    continue;
                }
                ExampleSentence exampleSentence = new ExampleSentence(getRowNum(noCell), getExampleSentence(exampleCell));
                velocityTemplateInfo.exampleSentenceList.add(exampleSentence);

                /*
                 * ここからは置換情報の保持
                 */
                Cell targetNoCell = row.getCell(Config.targetNoColumnIndex);
                if (checkErrorNoCell(targetNoCell)) {
                    continue;
                }
                Cell targetStrCell = row.getCell(Config.targetStrColumnIndex);
                Cell convertStrCell = row.getCell(Config.convertStrColumnIndex);
                ConvertInfo convertInfo = new ConvertInfo(getRowNum(targetNoCell), targetStrCell.getStringCellValue(), convertStrCell.getStringCellValue());
                velocityTemplateInfo.convertInfoList.add(convertInfo);
            }
        }
        return velocityTemplateInfo;
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
