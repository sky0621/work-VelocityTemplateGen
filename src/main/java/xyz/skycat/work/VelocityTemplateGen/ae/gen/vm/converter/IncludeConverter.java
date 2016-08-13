package xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.converter;

import xyz.skycat.work.VelocityTemplateGen.Config;

import static xyz.skycat.work.VelocityTemplateGen.ae.config.ConfigManager.configGenVm;

/**
 * Created by SS on 2016/08/14.
 */
public class IncludeConverter {

    public static String createIncludeString(String convertStr, String templateFileType) {

        String includeFileNameBase = convertStr.replace(configGenVm().getPrefixConvertString(), "");

        String setStrPrefix = "$parts.";
        if (configGenVm().getTemplateFileTypeMain().equals(templateFileType)) {
            setStrPrefix = "$bean.";
        }

        String setStr = "#set($parts = " + setStrPrefix + includeFileNameBase + "Bean)";
        String parseStr = "#parse(\"" + Config.includeVMpath + includeFileNameBase + ".vm\")";

        return setStr + System.getProperty("line.separator") + parseStr;
    }

}
