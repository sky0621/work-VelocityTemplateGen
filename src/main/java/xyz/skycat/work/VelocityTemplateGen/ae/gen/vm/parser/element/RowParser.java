package xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.parser.element;

import org.apache.poi.ss.usermodel.Row;
import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.constructer.VelocityTemplate;
import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.parser.element.row.DisplaySpecificationRowParser;
import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.parser.element.row.SampleMailRowParser;
import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.parser.element.row.TitleRowParser;

import java.util.Optional;

/**
 * Created by SS on 2016/08/12.
 */
public class RowParser {

    // 副作用。。。
    public boolean parse(Row row, VelocityTemplate velocityTemplate) {

        // VMファイル名の保持
        if(!(new TitleRowParser().parse(row, velocityTemplate))) {
            return false;
        }

        // サンプルメールの保持
        if(!(new SampleMailRowParser().parse(row, velocityTemplate))) {
            return false;
        }

        // 表示仕様の保持
        if(!(new DisplaySpecificationRowParser().parse(row, velocityTemplate))) {
            return false;
        }

        return true;
    }

}
