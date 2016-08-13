package xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.parser.element;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.constructer.VelocityTemplate;
import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.constructer.element.DisplaySpecification;

import java.util.Optional;

import static java.util.Optional.ofNullable;

/**
 * Created by SS on 2016/08/12.
 */
public class SheetParser {

    public Optional<VelocityTemplate> parse(Sheet sheet) {

        // Oops...
        DisplaySpecification.setDisplaySpecificationParseOn(false);

        VelocityTemplate velocityTemplate = new VelocityTemplate();
        for (Row row : sheet) {
            if(new RowParser().parse(row, velocityTemplate)) {
                continue;
            }
        }
        return Optional.ofNullable(velocityTemplate);
    }

}
