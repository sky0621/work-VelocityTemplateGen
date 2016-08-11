package xyz.skycat.work.VelocityTemplateGen.ae;

import org.yaml.snakeyaml.Yaml;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by SS on 2016/08/12.
 */
public class ConfigGenerator {

    private static ConfigGenVm configGenVm;

    public static ConfigGenVm createConfigGenVm() throws FileNotFoundException {

        if (configGenVm == null) {
            configGenVm = new Yaml().loadAs(new FileReader("config_genvm.yaml"), ConfigGenVm.class);
        }
        return configGenVm;
    }

}
