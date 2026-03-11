package org.bgtapp.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AppJavaFX extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("BGT App");
        stage.setWidth(900);
        stage.setHeight(600);

        BorderPane raiz = new BorderPane();
        Label titulo = new Label("BGT App");
        titulo.setStyle("-fx-font-size: 30px; -fx-font-weight: bold; -fx-padding: 20px;");
        raiz.setTop(titulo);
        Scene scene = new Scene(raiz, 900, 600);

        stage.setScene(scene);
        stage.show();
    }
}
