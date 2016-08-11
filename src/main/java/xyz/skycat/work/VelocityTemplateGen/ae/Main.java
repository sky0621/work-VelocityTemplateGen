package xyz.skycat.work.VelocityTemplateGen.ae;

/**
 * Created by SS on 2016/08/12.
 */
public class Main {

    // Executor.run 起動
    // JavaFX による UI 提供
    // YAML で設定（どの行から解析するか等）を保存
    // 処理対象セルに応じたクラスを用意（パース時のチェックや情報保持媒体として使う）
    // [機能]
    // 1.Excel解析⇒VMファイル生成
    // 2.VMファイル⇒Beanクラス生成
    // 3.VM+Bean by Velocity⇒メール文例出力

    public static void main(String... args) {
        try {
            new Executor().run(new Argument(args));
            System.exit(0);
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(-1);
        }
    }

}
