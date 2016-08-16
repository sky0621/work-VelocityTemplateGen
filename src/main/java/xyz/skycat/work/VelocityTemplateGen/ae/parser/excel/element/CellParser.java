package xyz.skycat.work.VelocityTemplateGen.ae.parser.excel.element;

import xyz.skycat.work.VelocityTemplateGen.ae.construct.excel.VelocityTemplate;
import xyz.skycat.work.VelocityTemplateGen.ae.construct.excel.element.IfVelocityTemplateElement;

/**
 * Created by SS on 2016/08/12.
 */
public class CellParser {

    // 副作用。。。
    private VelocityTemplate velocityTemplate;

    public CellParser(VelocityTemplate velocityTemplate) {
        this.velocityTemplate = velocityTemplate;
    }

    public boolean parse(IfVelocityTemplateElement element) {

        // TODO 例外スロー？

        element.doProcess(velocityTemplate);
        return true;
    }

}
