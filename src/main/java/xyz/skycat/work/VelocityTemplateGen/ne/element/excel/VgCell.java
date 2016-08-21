package xyz.skycat.work.VelocityTemplateGen.ne.element.excel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SS on 2016/08/19.
 */
public class VgCell implements IfCell {

    private String name;

    private int rowNumber;

    private int columnNumber;

    private List<IfRow> dependOnRowList;

    private List<IfCell> dependOnCellList;

    public VgCell() {
        dependOnRowList = new ArrayList<>();
        dependOnCellList = new ArrayList<>();
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
    public int getColumnNumber() {
        return columnNumber;
    }

    @Override
    public void setColumnNumber(int columnNumber) {
        this.columnNumber = columnNumber;
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

    @Override
    public List<IfCell> getDependOnCellList() {
        return dependOnCellList;
    }

    @Override
    public void setDependOnCellList(List<IfCell> dependOnCellList) {
        this.dependOnCellList = dependOnCellList;
    }

    @Override
    public void addDependOnCell(IfCell cell) {
        dependOnCellList.add(cell);
    }

}
