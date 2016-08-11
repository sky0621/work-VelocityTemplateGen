package xyz.skycat.work.VelocityTemplateGen.ae;

import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.constructer.VelocityTemplate;
import xyz.skycat.work.VelocityTemplateGen.ae.gen.vm.parser.Parser;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by SS on 2016/08/07.
 */
public class FileParseVisitor implements FileVisitor<Path> {

    private Parser parser;

    public FileParseVisitor(Parser parser) {
        this.parser = parser;
    }

    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        VelocityTemplate velocityTemplateInfo = parser.parse(file);

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
