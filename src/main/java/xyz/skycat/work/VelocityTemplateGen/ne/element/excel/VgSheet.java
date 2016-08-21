package xyz.skycat.work.VelocityTemplateGen.ne.element.excel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SS on 2016/08/19.
 */
public class VgSheet implements IfSheet {

    private String name;

    private List<IfRow> rowList;

    public VgSheet() {
        rowList = new ArrayList<>();
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
    public List<IfRow> getRowList() {
        return rowList;
    }

    @Override
    public void setRowList(List<IfRow> rowList) {
        this.rowList = rowList;
    }

    @Override
    public void addRow(IfRow row) {
        rowList.add(row);
    }

}
