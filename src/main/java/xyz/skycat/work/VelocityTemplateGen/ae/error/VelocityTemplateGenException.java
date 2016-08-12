package xyz.skycat.work.VelocityTemplateGen.ae.error;

/**
 * Created by SS on 2016/08/13.
 */
public class VelocityTemplateGenException extends Exception {

    public VelocityTemplateGenException() {
        super();
    }

    public VelocityTemplateGenException(String message) {
        super(message);
    }

    public VelocityTemplateGenException(Exception e) {
        super(e);
    }

    public VelocityTemplateGenException(String message, Exception e) {

        super(message, e);
    }

}
