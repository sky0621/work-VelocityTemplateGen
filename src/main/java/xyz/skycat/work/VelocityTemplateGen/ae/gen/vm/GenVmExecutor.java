package xyz.skycat.work.VelocityTemplateGen.ae.gen.vm;

import xyz.skycat.work.VelocityTemplateGen.ae.ConfigManager;
import xyz.skycat.work.VelocityTemplateGen.ae.ExcelFileParseVisitor;
import xyz.skycat.work.VelocityTemplateGen.ae.GenExecutor;
import xyz.skycat.work.VelocityTemplateGen.ae.VelocityTemplateGenException;
import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.parser.ExcelParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static xyz.skycat.work.VelocityTemplateGen.ae.ErrorMessage.FAILURE_READ_CONFIG_GENVM;

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
