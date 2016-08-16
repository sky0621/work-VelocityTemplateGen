package xyz.skycat.work.VelocityTemplateGen.ae.parser.excel.element;

import org.apache.poi.ss.usermodel.Row;
import xyz.skycat.work.VelocityTemplateGen.ae.construct.excel.VelocityTemplate;

/**
 * Created by SS on 2016/08/15.
 */
public interface IfRowParser {

    boolean parse(Row row, VelocityTemplate velocityTemplate);
}
