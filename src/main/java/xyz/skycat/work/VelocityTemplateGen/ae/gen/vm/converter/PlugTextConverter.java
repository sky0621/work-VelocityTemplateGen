package xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.converter;

import static xyz.skycat.work.VelocityTemplateGen.ae.config.ConfigManager.configGenVm;
import static xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.expression.VarExpression.exp;

/**
 * Created by SS on 2016/08/15.
 */
public class PlugTextConverter {

    public static String createPlugTextString(String example, String convertStr) {

        String plugTextVarBase = convertStr.replace(configGenVm().getPlubTextStr(), "");
        return example.replace(example, exp(plugTextVarBase));
    }

}
