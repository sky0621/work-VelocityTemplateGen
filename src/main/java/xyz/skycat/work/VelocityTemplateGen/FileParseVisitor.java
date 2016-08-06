package xyz.skycat.work.VelocityTemplateGen;

import xyz.skycat.work.VelocityTemplateGen.construction.ExampleSentence;
import xyz.skycat.work.VelocityTemplateGen.construction.VelocityTemplateInfo;
import xyz.skycat.work.VelocityTemplateGen.input.Parser;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
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

            for(ExampleSentence es : velocityTemplateInfo.exampleSentenceList) {
                System.out.println(String.format("[%d]: %s", es.rowNum, es.sentence));
            }

            String vmFileName = velocityTemplateInfo.getFileName();
            System.out.println("===========================" + vmFileName + "===========================");

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

}
