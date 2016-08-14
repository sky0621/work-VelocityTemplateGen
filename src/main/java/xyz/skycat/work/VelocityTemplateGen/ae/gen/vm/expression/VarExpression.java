package xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.expression;

/**
 * Created by SS on 2016/08/15.
 */
public class VarExpression {

    public static String exp(String convertTo) {
        return "$!{" + convertTo + "}";
    }

}
