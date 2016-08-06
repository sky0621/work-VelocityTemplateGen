package xyz.skycat.work.VelocityTemplateGen;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by SS on 2016/08/07.
 */
public class Argument {

    public Path targetRootPath = null;

    public Argument(String... args) {

        if (args == null || args.length == 0) {
            throw new IllegalArgumentException("少なくとも読み込み対象ファイルのルートディレクトリ（フルパス）を指定する必要があります。");
        }

        String targetRootPathStr = args[0];
        targetRootPath = Paths.get(targetRootPathStr);
    }

}
