package xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.parser.element.row;

import org.apache.poi.ss.usermodel.Row;
import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.constructer.VelocityTemplate;
import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.parser.element.IfRowParser;

/**
 * Created by SS on 2016/08/15.
 */
public class SeparateOutSpecificationRowParser implements IfRowParser {

    @Override
    public boolean parse(Row row, VelocityTemplate velocityTemplate) {

        return true;
    }

}
