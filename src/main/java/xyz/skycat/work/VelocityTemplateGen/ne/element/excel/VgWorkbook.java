package xyz.skycat.work.VelocityTemplateGen.ne.element.excel;

/**
 * Created by SS on 2016/08/19.
 */
public class VgWorkbook implements IfWorkbook {

    private String name;

    private IfSheet sheet;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public IfSheet getSheet() {
        return sheet;
    }

    @Override
    public void setSheet(IfSheet sheet) {
        this.sheet = sheet;
    }
}
