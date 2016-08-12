package xyz.skycat.work.VelocityTemplateGen.ae.ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import xyz.skycat.work.VelocityTemplateGen.ae.*;

import static xyz.skycat.work.VelocityTemplateGen.ae.ErrorMessage.FAILURE_READ_CONFIG_GENVM;
import static xyz.skycat.work.VelocityTemplateGen.ae.ExecMode.GEN_VM;

/**
 * Created by SS on 2016/08/12.
 */
public class JavaFXMain extends Application {

    TextField inputDirTField;
    TextField outputDirTField;
    Label errorLabel;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("メール送信用テンプレートファイル自動生成ツール");

        Label explain = new Label();
        explain.setText("指定のフォーマットで書かれたExcelファイルが置かれたディレクトリと生成物の出力先を指定してください。初期状態では sample ディレクトリ配下を指定しています。");

        ConfigManager.init();
        ConfigGenVm configGenVm = ConfigManager.configGenVm();

        Label inputDirExplain = new Label();
        inputDirExplain.setText("Excelファイル格納ルートディレクトリをフルパスで入力：");

        inputDirTField = new TextField();
        inputDirTField.setText(configGenVm.getInputDir());

        Label outputDirExplain = new Label();
        outputDirExplain.setText("出力ファイル格納ディレクトリをフルパスで入力：");

        outputDirTField = new TextField();
        outputDirTField.setText(configGenVm.getOutputDir());

        Button parseBtn = new Button();
        parseBtn.setText("生成");
        parseBtn.setOnAction(actionEvent -> {
            try {
                configGenVm.setInputDir(inputDirTField.getText());
                configGenVm.setOutputDir(outputDirTField.getText());
                new Executor().run(GEN_VM);
            } catch (Throwable t) {
                t.printStackTrace();
                errorLabel.setText(t.getMessage());
            }
        });

        errorLabel = new Label();

        // Pane
        VBox pane = new VBox(10d);
        pane.setAlignment(Pos.CENTER_LEFT);
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.getChildren().add(inputDirExplain);
        pane.getChildren().add(inputDirTField);
        pane.getChildren().add(outputDirExplain);
        pane.getChildren().add(outputDirTField);
        pane.getChildren().add(parseBtn);
        pane.getChildren().add(errorLabel);

        // Scene
        Scene scene = new Scene(pane);

        // Stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
