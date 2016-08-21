package xyz.skycat.work.VelocityTemplateGen.ne.element.excel;

import java.util.List;

/**
 * Created by SS on 2016/08/19.
 */
public interface IfSheet {

    public String getName();

    public void setName(String name);

    public List<IfRow> getRowList();

    public void setRowList(List<IfRow> rowList);

    public void addRow(IfRow row);

}
