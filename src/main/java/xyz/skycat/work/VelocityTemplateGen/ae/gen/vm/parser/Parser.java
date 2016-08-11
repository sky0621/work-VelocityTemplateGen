package xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.parser;

import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.constructer.VelocityTemplate;

import java.nio.file.Path;

/**
 * Created by SS on 2016/08/12.
 */
public interface Parser {

    VelocityTemplate parse(Path excelFilePath);

}
