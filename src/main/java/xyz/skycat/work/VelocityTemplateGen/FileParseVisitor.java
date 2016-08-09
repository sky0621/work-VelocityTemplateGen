package xyz.skycat.work.VelocityTemplateGen;

import xyz.skycat.work.VelocityTemplateGen.construction.DisplaySpecification;
import xyz.skycat.work.VelocityTemplateGen.construction.ExampleSentence;
import xyz.skycat.work.VelocityTemplateGen.construction.VelocityTemplateInfo;
import xyz.skycat.work.VelocityTemplateGen.input.Parser;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Comparator;

import static java.util.Comparator.*;
import static java.util.Comparator.comparing;

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

        VelocityTemplateInfo velocityTemplateInfo = parser.parse(file);

        String vmFileNameFullPath = velocityTemplateInfo.getFileName();
        outputInit(vmFileNameFullPath);

        // 要素を長さ重視で並べ替え（置換時に、同一行で「1」と「13」のように重複値がある場合、
        // 最短値からマッチすると正しい変換が得られないため、最長値からマッチするように並べ替える必要がある。）
        velocityTemplateInfo.displaySpecificationList.sort(comparing(x -> x.targetString.length(), reverseOrder()));

        /*
         * メール文例の変動項目を置換変数に変えていく
         */
        for (ExampleSentence es : velocityTemplateInfo.exampleSentenceList) {
            int rowNum = es.rowNum;
            String outStr = es.sentence;
            for (DisplaySpecification ci : velocityTemplateInfo.displaySpecificationList) {
                int chgRowNum = ci.rowNum;
                if (rowNum == chgRowNum) {
                    String targetStr = ci.targetString;
                    String convStr = ci.convertString;
                    outStr = outStr.replace(targetStr, convStr);
                    // インクルード文言の場合
                    if (outStr.startsWith(Config.includeConvertStr)) {
                        String vmName = outStr.replace(Config.includeConvertStr, "");
                        outStr = "#parse(\"" + Config.includeVMpath + vmName + ".vm\")";
                        String setStr = null;
                        if(velocityTemplateInfo.isVmTypeMain()) {
                            setStr = "#set($parts = $bean." + vmName + "Bean)";
                        } else {
                            setStr = "#set($parts = $parts." + vmName + "Bean)";
                        }
                        output(vmFileNameFullPath, setStr);
                    }
                }
            }
            output(vmFileNameFullPath, outStr);
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
