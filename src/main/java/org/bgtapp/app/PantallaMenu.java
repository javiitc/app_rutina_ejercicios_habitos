package org.bgtapp.app;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class PantallaMenu {

    public static Scene crear() {
        Label titulo = new Label("BGT APP");
        titulo.setId("titulo-principal");

        Button btnAnyadirSesion = new Button("1.  Añadir Sesión");
        Button btnVerSesiones   = new Button("2.  Ver Sesiones");
        Button btnSalir         = new Button("3.  Salir");

        btnAnyadirSesion.getStyleClass().add("btn-menu");
        btnVerSesiones.getStyleClass().add("btn-menu");
        btnSalir.getStyleClass().add("btn-menu");

        btnAnyadirSesion.setOnAction(e -> AppJavaFX.mostrarAgregarSesion());
        btnVerSesiones.setOnAction(e -> AppJavaFX.mostrarVerSesiones());
        btnSalir.setOnAction(e -> AppJavaFX.salir());

        VBox raiz = new VBox(20, titulo, btnAnyadirSesion, btnVerSesiones, btnSalir);
        raiz.setAlignment(Pos.CENTER);
        raiz.setPadding(new Insets(60));
        raiz.setId("pantalla-menu");

        return new Scene(raiz, 900, 600);
    }
}
