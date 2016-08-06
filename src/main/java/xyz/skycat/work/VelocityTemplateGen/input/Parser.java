package xyz.skycat.work.VelocityTemplateGen.input;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import xyz.skycat.work.VelocityTemplateGen.construction.ExampleSentence;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

/**
 * Created by SS on 2016/08/07.
 */
public interface Parser {

    List<ExampleSentence> parse(Path inputPath) throws IOException, InvalidFormatException;

}
