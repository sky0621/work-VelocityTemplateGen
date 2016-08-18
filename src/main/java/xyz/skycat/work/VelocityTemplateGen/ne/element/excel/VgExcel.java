package xyz.skycat.work.VelocityTemplateGen.ne.element.excel;

/**
 * Created by SS on 2016/08/19.
 */
public class VgExcel implements IfExcel {

    private String name;

    private IfWorkbook workbook;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public IfWorkbook getWorkbook() {
        return workbook;
    }

    @Override
    public void setWorkbook(IfWorkbook workbook) {
        this.workbook = workbook;
    }

}
