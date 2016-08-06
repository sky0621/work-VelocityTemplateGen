package xyz.skycat.work.VelocityTemplateGen;

import xyz.skycat.work.VelocityTemplateGen.input.Parser;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

        List<Map<Integer, String>> exampleSentenceList = null;
        try {
            exampleSentenceList = parser.parse(file);

        } catch(Throwable t) {
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
