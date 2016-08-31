# Excelの設計書からVelocityTemplateファイルを自動生成するツール
## ■言語・ツール・開発環境
###### Java8/IntelliJ/POI
## ■修正履歴
###### 2016/08/08 作成中段階で紹介ページ作成
###### 2016/08/09 インクルードロジックと変数へのプレフィックスを追加
###### 2016/08/17 ExcelからVMファイルの自動生成が完了（サンプルExcelでの完了なので、実際のメール個別定義書をフォーマット化しての動作確認は未済み）
###### 　　　　　　JavaFXで作ったUIの口も一応、用意。
###### 2016/08/30 Beanが実装ごりごりになり自動生成の域を超えてきたので頓挫。
## ■紹介
###### メールに関する案件に関わり、ちょっとメール用の設計書（Excel）をテンプレートとして整えたら、VMファイルを自動生成できるんじゃないかと考え、作りました。
## ■使い方
###### まだ作成中のため、EclipseプロジェクトでMainを叩く。
###### 実行時の引数２つ。
###### １つ目：インプットとなるExcelが置かれているディレクトリのフルパス
###### ２つ目：アウトプットとなるVMファイルを格納するディレクトリのフルパス
###### ※要Java8SDK
## ■備忘録
###### 指定ディレクトリの中で、対象とするExcelを設定ファイルに書けるようにしておいた方がいい。（今回のは部品化用なので既存は除外）
