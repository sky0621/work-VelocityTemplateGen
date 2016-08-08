package xyz.skycat.work.VelocityTemplateGen.input;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import xyz.skycat.work.VelocityTemplateGen.construction.VelocityTemplateInfo;

import java.io.IOException;
import java.nio.file.Path;

/**
 * Created by SS on 2016/08/07.
 */
public interface Parser {

    VelocityTemplateInfo parse(Path inputPath) throws IOException;

}
