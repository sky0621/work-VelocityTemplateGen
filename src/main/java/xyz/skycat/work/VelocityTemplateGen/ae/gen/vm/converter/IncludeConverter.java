package xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.converter;

import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.expression.VarExpression;

import static xyz.skycat.work.VelocityTemplateGen.ae.config.ConfigManager.configGenVm;

/**
 * Created by SS on 2016/08/14.
 */
public class IncludeConverter {

    public static String createIncludeString(String convertStr, String templateFileType) {

        String includeFileNameBase = convertStr.replace(configGenVm().getIncludeConvertStr(), "");

        String setStr = "#set($parts = $" + VarExpression.getVarPrefix(templateFileType) + includeFileNameBase + "Bean)";
        String parseStr = "#parse(\"" + configGenVm().getIncludeVMpath() + includeFileNameBase + configGenVm().getOutputFileSuffix() + "\")";

        return setStr + System.getProperty("line.separator") + parseStr;
    }

}
