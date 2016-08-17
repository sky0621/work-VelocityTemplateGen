package xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.converter;

import com.google.common.base.CaseFormat;
import org.apache.poi.ss.formula.functions.Match;
import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.expression.VarExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static xyz.skycat.work.VelocityTemplateGen.ae.config.ConfigManager.configGenVm;

/**
 * Created by SS on 2016/08/14.
 */
public class IncludeConverter {

    public static String createIncludeString(String convertStr, String templateFileType, String templateSetString) {

        String includeFileNameBase = convertStr.replace(configGenVm().getIncludeConvertStr(), "");
        String beanNameBase = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, includeFileNameBase);
        beanNameBase = beanNameBase.substring(0, 1).toLowerCase() + beanNameBase.substring(1);

        String setStr = "#set($parts = $" + VarExpression.getVarPrefix(templateFileType) + beanNameBase + "Bean)";
        if (templateSetString != null && !templateSetString.equals("")) {
            setStr = "#set($parts = $" + includeFileNameBase + ")";
        }
        String parseStr = "#parse(\"" + configGenVm().getIncludeVMpath() + includeFileNameBase + configGenVm().getOutputFileSuffix() + "\")";

        return setStr + System.getProperty("line.separator") + parseStr;
    }

}
