package xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.expression;

import static xyz.skycat.work.VelocityTemplateGen.ae.config.ConfigManager.configGenVm;

/**
 * Created by SS on 2016/08/15.
 */
public class VarExpression {

    public static String exp(String convertTo, String templateFileType) {
        return "$!{" + getVarPrefix(templateFileType) + convertTo + "}";
    }

    public static String getVarPrefix(String templateFileType) {
        String setStrPrefix = "parts.";
        if (configGenVm().getTemplateFileTypeMain().equals(templateFileType)) {
            setStrPrefix = "bean.";
        }
        return setStrPrefix;
    }

}
