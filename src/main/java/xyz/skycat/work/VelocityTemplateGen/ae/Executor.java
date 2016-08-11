package xyz.skycat.work.VelocityTemplateGen.ae;

import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.parser.ExcelParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by SS on 2016/08/07.
 */
public class Executor {

    public void run() throws IOException {

        FileParseVisitor visitor = new FileParseVisitor(new ExcelParser());
        Files.walkFileTree(Paths.get(ConfigGenerator.createConfigGenVm().getInputDir()), visitor);
    }

}
