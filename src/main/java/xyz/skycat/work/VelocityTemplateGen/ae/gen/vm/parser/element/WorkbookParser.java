package xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.parser.element;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.constructer.VelocityTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by SS on 2016/08/12.
 */
public class WorkbookParser {

    public List<Optional<VelocityTemplate>> parse(Workbook workbook) {

        List<Optional<VelocityTemplate>> velocityTemplateList = new ArrayList<>();
        for (Sheet sheet : workbook) {

            velocityTemplateList.add(new SheetParser().parse(sheet));
        }
        return velocityTemplateList;
    }

}
