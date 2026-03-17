package org.bgtapp.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.bgtapp.modelo.GestorSesiones;

public class AppJavaFX extends Application {

    private static Stage stage;
    private static GestorSesiones gestorSesiones;

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        gestorSesiones = new GestorSesiones();

        stage.setTitle("BGT App");
        stage.setWidth(900);
        stage.setHeight(600);
        stage.setResizable(false);

        mostrarMenu();
        stage.show();
    }

    public static void mostrarMenu() {
        cambiarEscena(PantallaMenu.crear());
    }

    public static void mostrarAgregarSesion() {
        cambiarEscena(PantallaAgregarSesion.crear(gestorSesiones));
    }

    public static void mostrarVerSesiones() {
        cambiarEscena(PantallaVerSesiones.crear(gestorSesiones));
    }

    public static void salir() {
        stage.close();
    }

    private static void cambiarEscena(Scene scene) {
        var css = AppJavaFX.class.getResource("/styles.css");
        if (css != null) scene.getStylesheets().add(css.toExternalForm());
        stage.setScene(scene);
    }
}
