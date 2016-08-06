package xyz.skycat.work.VelocityTemplateGen.input;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

/**
 * Created by SS on 2016/08/07.
 */
public interface Parser {

    List<Map<Integer, String>> parse(Path inputPath) throws IOException, InvalidFormatException;

}
