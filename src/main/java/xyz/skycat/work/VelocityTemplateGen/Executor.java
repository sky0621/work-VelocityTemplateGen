package xyz.skycat.work.VelocityTemplateGen;

import xyz.skycat.work.VelocityTemplateGen.input.Parser;
import xyz.skycat.work.VelocityTemplateGen.input.by.ExcelParser;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;

/**
 * Created by SS on 2016/08/07.
 */
public class Executor {

    public void run(Argument argument) throws IOException {

        FileParseVisitor visitor = new FileParseVisitor(new ExcelParser());
        Files.walkFileTree(argument.targetRootPath, visitor);
    }

}
