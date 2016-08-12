package xyz.skycat.work.VelocityTemplateGen.ae.gen.vm;

import xyz.skycat.work.VelocityTemplateGen.ae.config.ConfigManager;
import xyz.skycat.work.VelocityTemplateGen.ae.ExcelFileParseVisitor;
import xyz.skycat.work.VelocityTemplateGen.ae.GenExecutor;
import xyz.skycat.work.VelocityTemplateGen.ae.error.VelocityTemplateGenException;
import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.parser.ExcelParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by SS on 2016/08/12.
 */
public class GenVmExecutor implements GenExecutor {

    public void run() throws VelocityTemplateGenException {
        try {
            ExcelFileParseVisitor visitor = new ExcelFileParseVisitor(new ExcelParser());
            Files.walkFileTree(Paths.get(ConfigManager.configGenVm().getInputDir()), visitor);
        } catch (IOException e) {
            throw new VelocityTemplateGenException(e);
        }
    }

}
