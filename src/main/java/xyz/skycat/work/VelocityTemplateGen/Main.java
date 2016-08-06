package xyz.skycat.work.VelocityTemplateGen;

/**
 * Created by SS on 2016/08/06.
 */
public class Main {

    public static void main(String... args) {
        try {
            new Executor().run(new Argument(args));
            System.exit(0);
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(-1);
        }
    }

}
