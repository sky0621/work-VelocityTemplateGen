package xyz.skycat.work.VelocityTemplateGen.ae;

import org.yaml.snakeyaml.Yaml;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Optional;

/**
 * Created by SS on 2016/08/12.
 */
public class ConfigManager {

    private static ConfigGenVm configGenVm;

    public static void init() throws VelocityTemplateGenException {

        if (configGenVm == null) {
            try {
                configGenVm = new Yaml().loadAs(new FileReader("config_genvm.yaml"), ConfigGenVm.class);
            } catch (FileNotFoundException e) {
                // TODO Logger使用
                throw new VelocityTemplateGenException(e);
            }
        }
    }

    public static ConfigGenVm configGenVm() {
        return configGenVm;
    }

}
