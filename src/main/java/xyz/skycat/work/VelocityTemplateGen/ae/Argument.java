package xyz.skycat.work.VelocityTemplateGen.ae;

import static xyz.skycat.work.VelocityTemplateGen.ae.ErrorMessage.ILLEGAL_ARGUMENT_EXEC;

/**
 * Created by SS on 2016/08/13.
 */
public class Argument {

    private int execMode = 0;

    public Argument(String... args) throws VelocityTemplateGenException {
        init(args);
    }

    private void init(String... args) throws VelocityTemplateGenException {
        if (args.length == 0) {
            execMode = 1;
            return;
        }
        if (args.length != 1) {
            throw new VelocityTemplateGenException(ILLEGAL_ARGUMENT_EXEC);
        }
        try {
            execMode = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            throw new VelocityTemplateGenException(ILLEGAL_ARGUMENT_EXEC);
        }
    }

    public int getExecMode() {
        return execMode;
    }

}
