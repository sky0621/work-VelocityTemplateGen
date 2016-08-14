package xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.parser.element;

import org.apache.poi.ss.usermodel.Row;
import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.constructer.VelocityTemplate;

/**
 * Created by SS on 2016/08/15.
 */
public interface IfRowParser {

    boolean parse(Row row, VelocityTemplate velocityTemplate);
}
