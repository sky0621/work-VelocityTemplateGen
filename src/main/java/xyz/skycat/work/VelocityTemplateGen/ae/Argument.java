package xyz.skycat.work.VelocityTemplateGen.ae;

import xyz.skycat.work.VelocityTemplateGen.Config;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by SS on 2016/08/07.
 */
public class Argument {

    public Path targetRootPath = null;
//    public Path outputPath = null;

    public Argument(String... args) {

        if (args == null || args.length != 2) {
            throw new IllegalArgumentException("読み込み対象ファイルのルートディレクトリ（フルパス）とVMファイルの出力先ディレクトリ（フルパス）を指定する必要があります。");
        }

        String targetRootPathStr = args[0];
        targetRootPath = Paths.get(targetRootPathStr);

        String outputPathStr = args[1];
        Config.outputPath = Paths.get(outputPathStr);
    }

}
