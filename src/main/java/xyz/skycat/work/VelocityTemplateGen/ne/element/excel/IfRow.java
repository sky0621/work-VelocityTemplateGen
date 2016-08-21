package xyz.skycat.work.VelocityTemplateGen.ne.element.excel;

import java.util.List;

/**
 * Created by SS on 2016/08/19.
 */
public interface IfRow {

    public String getName();

    public void setName(String name);

    public int getRowNumber();

    public void setRowNumber(int rowNumber);

    public List<IfCell> getCellList();

    public void setCellList(List<IfCell> cellList);

    public void addCell(IfCell cell);

    public List<IfRow> getDependOnRowList();

    public void setDependOnRowList(List<IfRow> dependOnRowList);

    public void addDependOnRow(IfRow row);

}
