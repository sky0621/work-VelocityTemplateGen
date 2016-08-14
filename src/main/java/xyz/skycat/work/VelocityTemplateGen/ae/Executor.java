package xyz.skycat.work.VelocityTemplateGen.ae;

import xyz.skycat.work.VelocityTemplateGen.ae.error.VelocityTemplateGenException;

/**
 * Created by SS on 2016/08/07.
 */
public class Executor {

    public void run(ExecMode mode) throws VelocityTemplateGenException {
        try {
            Class clz = Class.forName(mode.getExecutorClassName());
            IfGenExecutor executor = (IfGenExecutor) clz.newInstance();
            executor.run();
        } catch (Exception e) {
            throw new VelocityTemplateGenException(e);
        }
    }

}
