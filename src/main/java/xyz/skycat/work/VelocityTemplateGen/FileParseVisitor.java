package xyz.skycat.work.VelocityTemplateGen;

import xyz.skycat.work.VelocityTemplateGen.construction.ConvertInfo;
import xyz.skycat.work.VelocityTemplateGen.construction.ExampleSentence;
import xyz.skycat.work.VelocityTemplateGen.construction.VelocityTemplateInfo;
import xyz.skycat.work.VelocityTemplateGen.input.Parser;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

/**
 * Created by SS on 2016/08/07.
 */
public class FileParseVisitor implements FileVisitor<java.nio.file.Path> {

    private Parser parser;

    public FileParseVisitor(Parser parser) {
        this.parser = parser;
    }

    public FileVisitResult preVisitDirectory(java.nio.file.Path dir, BasicFileAttributes attrs) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult visitFile(java.nio.file.Path file, BasicFileAttributes attrs) throws IOException {

        VelocityTemplateInfo velocityTemplateInfo = null;
        try {
            velocityTemplateInfo = parser.parse(file);

            String vmFileNameFullPath = velocityTemplateInfo.getFileName();
            outputInit(vmFileNameFullPath);

            /*
             * メール文例の変動項目を置換変数に変えていく
             */
            for (ExampleSentence es : velocityTemplateInfo.exampleSentenceList) {
                int rowNum = es.rowNum;
                String outStr = es.sentence;
                for (ConvertInfo ci : velocityTemplateInfo.convertInfoList) {
                    int chgRowNum = ci.rowNum;
                    if(rowNum == chgRowNum) {
                        String targetStr = ci.targetString;
                        String convStr = ci.convertString;
                        outStr = outStr.replace(targetStr, convStr);
                    }
                }
                output(vmFileNameFullPath, outStr);
            }

        } catch (Throwable t) {
            System.out.println("[FAILED]" + t.toString());
        }

        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult visitFileFailed(java.nio.file.Path file, IOException exc) throws IOException {
        // TODO error handling.
        System.out.println("[FAILED]" + exc.toString());
        return FileVisitResult.TERMINATE;
    }

    public FileVisitResult postVisitDirectory(java.nio.file.Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    private void outputInit(String vmFileNameFullPath) throws IOException {
        Files.deleteIfExists(Paths.get(vmFileNameFullPath));
        Files.createFile(Paths.get(vmFileNameFullPath));
    }

    private void output(String vmFileNameFullPath, String str) throws IOException {

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(vmFileNameFullPath), StandardOpenOption.APPEND)) {
            writer.write(str);
            writer.write("\n");
            writer.flush();
        } catch (IOException e) {
            throw e;
        }

    }

}
