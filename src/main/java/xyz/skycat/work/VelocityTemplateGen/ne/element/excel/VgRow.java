package xyz.skycat.work.VelocityTemplateGen.ne.element.excel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SS on 2016/08/19.
 */
public class VgRow implements IfRow {

    private String name;

    private int rowNumber;

    private List<IfCell> cellList;

    private List<IfRow> dependOnRowList;

    public VgRow() {
        cellList = new ArrayList<>();
        dependOnRowList = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getRowNumber() {
        return rowNumber;
    }

    @Override
    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    @Override
    public List<IfCell> getCellList() {
        return cellList;
    }

    @Override
    public void setCellList(List<IfCell> cellList) {
        this.cellList = cellList;
    }

    @Override
    public void addCell(IfCell cell) {
        cellList.add(cell);
    }

    @Override
    public List<IfRow> getDependOnRowList() {
        return dependOnRowList;
    }

    @Override
    public void setDependOnRowList(List<IfRow> dependOnRowList) {
        this.dependOnRowList = dependOnRowList;
    }

    @Override
    public void addDependOnRow(IfRow row) {
        dependOnRowList.add(row);
    }

}
