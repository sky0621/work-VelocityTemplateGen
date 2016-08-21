package xyz.skycat.work.VelocityTemplateGen.ne.element.excel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SS on 2016/08/19.
 */
public class VgWorkbook implements IfWorkbook {

    private String name;

    private List<IfSheet> sheetList;

    public VgWorkbook() {
        sheetList = new ArrayList<>();
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
    public List<IfSheet> getSheetList() {
        return sheetList;
    }

    @Override
    public void setSheetList(List<IfSheet> sheetList) {
        this.sheetList = sheetList;
    }

    @Override
    public void addSheetList(IfSheet sheet) {
        sheetList.add(sheet);
    }

}
