package org.bgtapp.app;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
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
        stage.setResizable(false);

        Label titulo = new Label("BGT APP");
        titulo.setStyle(
            "-fx-font-size: 36px;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: black;"
        );

        Button btnAnyadirSesion = crearBoton("1.  Añadir Sesión");
        Button btnVerSesiones   = crearBoton("2.  Ver Sesiones");
        Button btnSalir         = crearBoton("3.  Salir");

        btnSalir.setOnAction(e -> stage.close());

        VBox raiz = new VBox(20, titulo, btnAnyadirSesion, btnVerSesiones, btnSalir);
        raiz.setAlignment(Pos.CENTER);
        raiz.setPadding(new Insets(60));
        raiz.setStyle("-fx-background-color: #d0d0d0;");

        Scene scene = new Scene(raiz, 900, 600);
        stage.setScene(scene);
        stage.show();
    }

    private Button crearBoton(String texto) {
        Button btn = new Button(texto);
        btn.setPrefWidth(260);
        btn.setPrefHeight(48);
        btn.setStyle(
            "-fx-font-size: 15px;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: black;" +
            "-fx-background-color: #f0f0f0;" +
            "-fx-border-color: #888888;" +
            "-fx-border-width: 1.5px;" +
            "-fx-border-radius: 6px;" +
            "-fx-background-radius: 6px;" +
            "-fx-cursor: hand;"
        );
        btn.setOnMouseEntered(e -> btn.setStyle(
            "-fx-font-size: 15px;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: black;" +
            "-fx-background-color: #e0e0e0;" +
            "-fx-border-color: #444444;" +
            "-fx-border-width: 1.5px;" +
            "-fx-border-radius: 6px;" +
            "-fx-background-radius: 6px;" +
            "-fx-cursor: hand;"
        ));
        btn.setOnMouseExited(e -> btn.setStyle(
            "-fx-font-size: 15px;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: black;" +
            "-fx-background-color: #f0f0f0;" +
            "-fx-border-color: #888888;" +
            "-fx-border-width: 1.5px;" +
            "-fx-border-radius: 6px;" +
            "-fx-background-radius: 6px;" +
            "-fx-cursor: hand;"
        ));
        return btn;
    }
}
