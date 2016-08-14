package xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.constructer.element;

import org.apache.poi.ss.usermodel.Cell;
import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.constructer.VelocityTemplate;
import xyz.skycat.work.VelocityTemplateGen.ae.util.PoiUtil;

/**
 * Created by SS on 2016/08/12.
 */
public class SampleMail implements IfVelocityTemplateElement {

    private Cell noCell;

    private Cell exampleCell;

    private int no;

    private String example;

    public SampleMail(Cell noCell, Cell exampleCell) {
        this.noCell = noCell;
        this.exampleCell = exampleCell;
    }

    @Override
    public void doProcess(VelocityTemplate velocityTemplate) {

        if (checkErrorNoCell(noCell)) {
            // TODO Logger使用
            return;
        }
        if (checkErrorExampleCell(exampleCell)) {
            // TODO Logger使用
        } else {
            velocityTemplate.getSampleMailList().add(this);
            expand();
        }

    }

    public int getNo() {
        return PoiUtil.getRowNum(noCell);
    }

    public String getExample() {
        return exampleCell == null ? "" : exampleCell.getStringCellValue();
    }

    private boolean checkErrorNoCell(Cell noCell) {
        if (noCell == null) {
            return true;
        }
        try {
            Object cellValue = PoiUtil.getCellValue(noCell);
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

    private boolean checkErrorExampleCell(Cell exampleCell) {
        if (exampleCell == null) {
            return false;
        }
        try {
            Object cellValue = PoiUtil.getCellValue(exampleCell);
            if (cellValue == null) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
        return false;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setExample(String example) {
        this.example = example;
    }

    private void expand() {
        setNo(PoiUtil.getRowNum(noCell));
        setExample(exampleCell == null ? "" : exampleCell.getStringCellValue());
    }

}
