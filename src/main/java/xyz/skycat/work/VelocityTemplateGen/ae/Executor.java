package xyz.skycat.work.VelocityTemplateGen.ae;

import xyz.skycat.work.VelocityTemplateGen.FileParseVisitor;
import xyz.skycat.work.VelocityTemplateGen.input.by.ExcelParser;

import java.io.IOException;
import java.nio.file.Files;

/**
 * Created by SS on 2016/08/07.
 */
public class Executor {

    public void run(Argument argument) throws IOException {

        FileParseVisitor visitor = new FileParseVisitor(new ExcelParser());
        Files.walkFileTree(argument.targetRootPath, visitor);
    }

}
