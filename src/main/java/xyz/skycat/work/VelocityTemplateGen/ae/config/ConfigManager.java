package xyz.skycat.work.VelocityTemplateGen.ae.config;

import org.yaml.snakeyaml.Yaml;
import xyz.skycat.work.VelocityTemplateGen.ae.error.VelocityTemplateGenException;
import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.config.ConfigGenVm;

import java.io.FileNotFoundException;
import java.io.FileReader;

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
