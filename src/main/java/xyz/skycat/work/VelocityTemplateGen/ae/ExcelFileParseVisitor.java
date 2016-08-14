package xyz.skycat.work.VelocityTemplateGen.ae;

import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.constructer.VelocityTemplate;
import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.converter.SampleMailConverter;
import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.parser.ExcelParser;
import xyz.skycat.work.VelocityTemplateGen.ae.util.FilesUtil;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by SS on 2016/08/07.
 */
public class ExcelFileParseVisitor implements FileVisitor<Path> {

    private ExcelParser parser;

    public ExcelFileParseVisitor(ExcelParser parser) {
        this.parser = parser;
    }

    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        try {
            Optional<List<Optional<VelocityTemplate>>> velocityTemplateListOptional = parser.parse(file);
            List<Optional<VelocityTemplate>> velocityTemplateList = velocityTemplateListOptional.orElse(new ArrayList<>());
            velocityTemplateList.stream().forEach(
                    velocityTemplateOptional -> {
                        // Oops...
                        VelocityTemplate velocityTemplate = velocityTemplateOptional.get();
                        if (velocityTemplate == null) {
                            // TODO Nothing to do ?
                        } else {
                            SampleMailConverter sampleMailConverter = new SampleMailConverter(velocityTemplate);

                            if(sampleMailConverter.convert()) {
                                // 出力
                                FilesUtil.outputInit(velocityTemplate.getTemplateFileName());
                                FilesUtil.output(velocityTemplate.getTemplateFileName(), sampleMailConverter.getResult());
                            }
                        }
                    }
            );
        } catch (Exception e) {
            throw new IOException(e);
        }
        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        // TODO error handling.
        System.out.println("[FAILED]" + exc.toString());
        return FileVisitResult.TERMINATE;
    }

    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

}
