package xyz.skycat.work.VelocityTemplateGen.input.by;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import xyz.skycat.work.VelocityTemplateGen.Config;
import xyz.skycat.work.VelocityTemplateGen.construction.DisplaySpecification;
import xyz.skycat.work.VelocityTemplateGen.construction.ExampleSentence;
import xyz.skycat.work.VelocityTemplateGen.construction.VelocityTemplateInfo;
import xyz.skycat.work.VelocityTemplateGen.input.Parser;

import java.io.IOException;
import java.nio.file.Path;

/**
 * Created by SS on 2016/08/07.
 */
public class ExcelParser implements Parser {

    private boolean displaySpecificationParseOn = false;

    public VelocityTemplateInfo parse(Path inputPath) throws IOException {

        VelocityTemplateInfo velocityTemplateInfo = new VelocityTemplateInfo();

        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create(inputPath.toFile(), null, true);
        } catch (InvalidFormatException ife) {
            throw new IOException(ife);
        }
        for (Sheet sheet : workbook) {
            for (Row row : sheet) {
                /*
                 * まずは解析開始行か判定
                 */
                int rowNum = row.getRowNum();
                if (rowNum == Config.vmFileNameLineIndex) {
                    Cell vmFileNameCell = row.getCell(Config.vmFileNameColumnIndex);
                    velocityTemplateInfo.setFileName(vmFileNameCell.getStringCellValue());
                    Cell vmMainOrPartsCell = row.getCell(Config.vmMainOrPartsColumnIndex);
                    velocityTemplateInfo.setVmType(vmMainOrPartsCell.getStringCellValue());
                    if (velocityTemplateInfo.isVmTypeMain()) {
                        Config.prefixConvertString = "bean.";
                    } else {
                        Config.prefixConvertString = "parts.";
                    }
                }
                if (rowNum < Config.exampleSentenceStartLineIndex) {
                    continue;
                }

                /*
                 * メール文例の保持
                 */
                Cell noCell = row.getCell(Config.noColumnIndex);
                if (checkErrorNoCell(noCell)) {
                    continue;
                }
                Cell exampleCell = row.getCell(Config.exampleColumnIndex);
                if (checkErrorExampleCell(exampleCell)) {
//                    continue;
                } else {
                    ExampleSentence exampleSentence = new ExampleSentence(getRowNum(noCell), getExampleSentence(exampleCell));
                    velocityTemplateInfo.exampleSentenceList.add(exampleSentence);
                }

                /*
                 * ここからは置換情報の保持
                 */
                Cell targetNoCell = row.getCell(Config.targetNoColumnIndex);
                if (checkErrorTargetNoCell(targetNoCell)) {
                    continue;
                }
                Cell explainCell = row.getCell(Config.explainColumnIndex);          // 説明
                Cell targetStrCell = row.getCell(Config.targetStrColumnIndex);      // 置換対象
                Cell convertStrCell = row.getCell(Config.convertStrColumnIndex);    // 置換変数
                Cell convertTypeCell = row.getCell(Config.convertTypeColumnIndex);  // 型
                DisplaySpecification displaySpecification = new DisplaySpecification(
                        getRowNum(targetNoCell),
                        explainCell.getStringCellValue(),
                        targetStrCell.getStringCellValue(),
                        convertStrCell.getStringCellValue(),
                        convertTypeCell.getStringCellValue());
                velocityTemplateInfo.displaySpecificationList.add(displaySpecification);
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

    private boolean checkErrorTargetNoCell(Cell noCell) {
        if (noCell == null) {
            return true;
        }
        try {
            Object cellValue = getCellValue(noCell);
            if (cellValue instanceof String) {
                if (Config.displaySpecificationMarkingString.equals((String) cellValue)) {
                    displaySpecificationParseOn = true;
                }
                return true;
            }
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
