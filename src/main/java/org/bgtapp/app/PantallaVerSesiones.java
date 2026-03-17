package org.bgtapp.app;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import org.bgtapp.modelo.GestorSesiones;
import org.bgtapp.modelo.Sesion;
import org.bgtapp.modelo.Serie;

import java.util.ArrayList;

public class PantallaVerSesiones {

    public static Scene crear(GestorSesiones gestor) {

        // --- Cabecera ---
        Label titulo = new Label("Sesiones Realizadas");
        titulo.setId("titulo-principal");

        Button btnVolver = new Button("← Volver");
        btnVolver.getStyleClass().add("btn-secundario");
        btnVolver.setOnAction(e -> AppJavaFX.mostrarMenu());

        HBox cabecera = new HBox(16, titulo, btnVolver);
        HBox.setHgrow(titulo, Priority.ALWAYS);
        cabecera.setAlignment(Pos.CENTER_LEFT);
        cabecera.setId("cabecera");
        cabecera.setPadding(new Insets(20, 30, 10, 30));

        // --- Lista de sesiones ---
        ArrayList<Sesion> sesiones = gestor.getSesiones();

        VBox listaSesiones = new VBox(12);
        listaSesiones.setPadding(new Insets(15, 30, 20, 30));

        if (sesiones.isEmpty()) {
            Label lblVacio = new Label("No hay sesiones registradas aún.");
            lblVacio.setId("label-vacio");
            listaSesiones.getChildren().add(lblVacio);
        } else {
            for (Sesion sesion : sesiones) {
                listaSesiones.getChildren().add(crearCardSesion(sesion));
            }
        }

        ScrollPane scroll = new ScrollPane(listaSesiones);
        scroll.setFitToWidth(true);
        scroll.setId("scroll-principal");

        BorderPane raiz = new BorderPane();
        raiz.setTop(cabecera);
        raiz.setCenter(scroll);
        raiz.setId("pantalla-ver");

        return new Scene(raiz, 900, 600);
    }

    private static TitledPane crearCardSesion(Sesion sesion) {
        String tituloSesion = sesion.getFecha()
                + "   |   " + sesion.getDuracion() + " min"
                + (sesion.getNotas().equals("-") ? "" : "   |   " + sesion.getNotas());

        VBox contenidoSesion = new VBox(6);
        contenidoSesion.setPadding(new Insets(10));
        contenidoSesion.getStyleClass().add("sesion-contenido");

        if (sesion.getSeries().isEmpty()) {
            Label lblSinSeries = new Label("Sin series registradas.");
            lblSinSeries.getStyleClass().add("label-secundario");
            contenidoSesion.getChildren().add(lblSinSeries);
        } else {
            for (Serie serie : sesion.getSeries()) {
                Label lblSerie = new Label("  -  " + serie.toString());
                lblSerie.getStyleClass().add("serie-info");
                contenidoSesion.getChildren().add(lblSerie);
            }
        }

        TitledPane card = new TitledPane(tituloSesion, contenidoSesion);
        card.setExpanded(false);
        card.getStyleClass().add("sesion-card");
        return card;
    }
}
