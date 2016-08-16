package xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.filewalkvisitor;

import xyz.skycat.work.VelocityTemplateGen.ae.construct.excel.VelocityTemplate;
import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.converter.SampleMailConverter;
import xyz.skycat.work.VelocityTemplateGen.ae.parser.excel.MailDefinitionExcelParser;
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

    private MailDefinitionExcelParser parser;

    public ExcelFileParseVisitor(MailDefinitionExcelParser parser) {
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

                            if (sampleMailConverter.convert()) {
                                // 出力
                                FilesUtil.outputInit(velocityTemplate.getTemplateFileName());
                                String setStr = velocityTemplate.getTemplateSetString();
                                if (setStr != null && !setStr.equals("")) {
                                    FilesUtil.output(velocityTemplate.getTemplateFileName(), setStr);
                                }
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
