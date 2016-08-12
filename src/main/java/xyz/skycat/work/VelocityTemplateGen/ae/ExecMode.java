package xyz.skycat.work.VelocityTemplateGen.ae;

/**
 * Created by SS on 2016/08/12.
 */
public enum ExecMode {
    GEN_VM(1, "xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.GenVmExecutor"),
    GEN_BEAN(2, "xyz.skycat.work.VelocityTemplateGen.ae.gen.bean.GenBeanExecutor"),
    GEN_MAIL(3, "xyz.skycat.work.VelocityTemplateGen.ae.gen.mail.GenMailExecutor");

    private int execArgumentValue;

    private String executorClassName;

    ExecMode(int execArgumentValue, String executorClassName) {
        this.execArgumentValue = execArgumentValue;
        this.executorClassName = executorClassName;
    }

    public int getExecArgumentValue() {
        return execArgumentValue;
    }

    public String getExecutorClassName() {
        return executorClassName;
    }

    public static ExecMode getByArgumentValue(int execArgumentValue) {
        switch (execArgumentValue) {
            case 1:
                return GEN_VM;
            case 2:
                return GEN_BEAN;
            case 3:
                return GEN_MAIL;
            default:
                return null;
        }
    }

}
