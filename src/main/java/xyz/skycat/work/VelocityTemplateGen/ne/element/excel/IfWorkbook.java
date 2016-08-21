package xyz.skycat.work.VelocityTemplateGen.ne.element.excel;

import java.util.List;

/**
 * Created by SS on 2016/08/19.
 */
public interface IfWorkbook {

    public String getName();

    public void setName(String name);

    public List<IfSheet> getSheetList();

    public void setSheetList(List<IfSheet> sheetList);

    public void addSheetList(IfSheet sheet);

}
