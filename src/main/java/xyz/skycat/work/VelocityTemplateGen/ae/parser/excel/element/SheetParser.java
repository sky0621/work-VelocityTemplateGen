package xyz.skycat.work.VelocityTemplateGen.ae.parser.excel.element;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import xyz.skycat.work.VelocityTemplateGen.ae.construct.excel.VelocityTemplate;
import xyz.skycat.work.VelocityTemplateGen.ae.construct.excel.element.DisplaySpecification;
import xyz.skycat.work.VelocityTemplateGen.ae.construct.excel.element.SeparateOutSpecification;

import java.util.Optional;

/**
 * Created by SS on 2016/08/12.
 */
public class SheetParser {

    public Optional<VelocityTemplate> parse(Sheet sheet) {

        // Oops...
        DisplaySpecification.setDisplaySpecificationParseOn(false);
        SeparateOutSpecification.setSeparateOutSpecificationParseOn(false);

        VelocityTemplate velocityTemplate = new VelocityTemplate();
        for (Row row : sheet) {
            if(new RowParser().parse(row, velocityTemplate)) {
                continue;
            }
        }
        return Optional.ofNullable(velocityTemplate);
    }

}
