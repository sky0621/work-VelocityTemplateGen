package xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.parser.element;

import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.constructer.VelocityTemplate;
import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.constructer.element.VelocityTemplateElement;

/**
 * Created by SS on 2016/08/12.
 */
public class CellParser {

    // 副作用。。。
    private VelocityTemplate velocityTemplate;

    public CellParser(VelocityTemplate velocityTemplate) {
        this.velocityTemplate = velocityTemplate;
    }

    public boolean parse(VelocityTemplateElement element) {

        // TODO 例外スロー？

        element.doProcess(velocityTemplate);
        return true;
    }

}
