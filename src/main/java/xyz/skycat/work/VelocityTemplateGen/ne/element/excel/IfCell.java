package xyz.skycat.work.VelocityTemplateGen.ne.element.excel;

import java.util.List;

/**
 * Created by SS on 2016/08/19.
 */
public interface IfCell {

    public String getName();

    public void setName(String name);

    public int getRowNumber();

    public void setRowNumber(int rowNumber);

    public int getColumnNumber();

    public void setColumnNumber(int columnNumber);

    public List<IfRow> getDependOnRowList();

    public void setDependOnRowList(List<IfRow> dependOnRowList);

    public void addDependOnRow(IfRow row);

    public List<IfCell> getDependOnCellList();

    public void setDependOnCellList(List<IfCell> dependOnCellList);

    public void addDependOnCell(IfCell cell);

}
