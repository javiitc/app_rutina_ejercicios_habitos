package org.bgtapp.app;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import org.bgtapp.modelo.*;

import java.util.ArrayList;

public class PantallaAgregarSesion {

    public static Scene crear(GestorSesiones gestor) {

        //  Cabecera
        Label titulo = new Label("Nueva Sesión");
        titulo.setId("titulo-principal");

        Button btnVolver = new Button("← Volver");
        btnVolver.getStyleClass().add("btn-secundario");
        btnVolver.setOnAction(e -> AppJavaFX.mostrarMenu());

        Region espaciador = new Region();
        HBox.setHgrow(espaciador, Priority.ALWAYS);
        HBox cabecera = new HBox(16, titulo, espaciador, btnVolver);
        cabecera.setAlignment(Pos.CENTER_LEFT);
        cabecera.setId("cabecera");
        cabecera.setPadding(new Insets(20, 30, 10, 30));

        //Formulario duración y notas
        Label lblDuracion = new Label("Duración (min):");
        lblDuracion.getStyleClass().add("label-form");

        TextField txtDuracion = new TextField();
        txtDuracion.setPromptText("Ej: 60");
        txtDuracion.getStyleClass().add("campo-form");
        txtDuracion.setPrefWidth(200);

        Label lblNotas = new Label("Notas:");
        lblNotas.getStyleClass().add("label-form");

        TextField txtNotas = new TextField();
        txtNotas.setPromptText("Opcional");
        txtNotas.getStyleClass().add("campo-form");
        txtNotas.setPrefWidth(400);

        GridPane formGrid = new GridPane();
        formGrid.setHgap(15);
        formGrid.setVgap(12);
        formGrid.setPadding(new Insets(10, 30, 10, 30));
        formGrid.add(lblDuracion, 0, 0);
        formGrid.add(txtDuracion, 1, 0);
        formGrid.add(lblNotas, 0, 1);
        formGrid.add(txtNotas, 1, 1);

        // Sección series
        Label lblSeries = new Label("Series");
        lblSeries.getStyleClass().add("subtitulo");
        lblSeries.setPadding(new Insets(10, 30, 5, 30));

        CatalogoEjercicios catalogo = new CatalogoEjercicios();
        ArrayList<Ejercicio> listaEjercicios = catalogo.cargarEjercicios();

        ComboBox<Ejercicio> cbEjercicio = new ComboBox<>(FXCollections.observableArrayList(listaEjercicios));
        cbEjercicio.setPromptText("Selecciona ejercicio");
        cbEjercicio.getStyleClass().add("campo-form");
        cbEjercicio.setPrefWidth(220);
        cbEjercicio.setCellFactory(lv -> new ListCell<>() {
            @Override
            protected void updateItem(Ejercicio item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : item.getNombre());
            }
        });
        cbEjercicio.setButtonCell(new ListCell<>() {
            @Override
            protected void updateItem(Ejercicio item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : item.getNombre());
            }
        });

        TextField txtReps = new TextField();
        txtReps.setPromptText("Reps");
        txtReps.getStyleClass().add("campo-form");
        txtReps.setPrefWidth(80);

        TextField txtPeso = new TextField();
        txtPeso.setPromptText("Peso (kg)");
        txtPeso.getStyleClass().add("campo-form");
        txtPeso.setPrefWidth(100);

        Button btnAgregarSerie = new Button("+ Agregar");
        btnAgregarSerie.getStyleClass().add("btn-secundario");

        HBox filaNuevaSerie = new HBox(12, cbEjercicio, txtReps, txtPeso, btnAgregarSerie);
        filaNuevaSerie.setAlignment(Pos.CENTER_LEFT);
        filaNuevaSerie.setPadding(new Insets(0, 30, 10, 30));

        // Lista visual de series agregadas
        VBox listaSeriesBox = new VBox(6);
        listaSeriesBox.setPadding(new Insets(0, 30, 10, 30));
        listaSeriesBox.setId("lista-series");

        ArrayList<Serie> seriesTemporales = new ArrayList<>();

        btnAgregarSerie.setOnAction(e -> {
            Ejercicio ejercicioSeleccionado = cbEjercicio.getValue();
            String repsStr = txtReps.getText().trim();
            String pesoStr = txtPeso.getText().trim();

            if (ejercicioSeleccionado == null || repsStr.isEmpty() || pesoStr.isEmpty()) {
                mostrarError("Completa todos los campos de la serie.");
                return;
            }

            int reps;
            double peso;
            try {
                reps = Integer.parseInt(repsStr);
                peso = Double.parseDouble(pesoStr.replace(",", "."));
            } catch (NumberFormatException ex) {
                mostrarError("Las repeticiones y el peso deben ser números válidos.");
                return;
            }

            if (reps <= 0 || peso < 0) {
                mostrarError("Las repeticiones deben ser > 0 y el peso >= 0.");
                return;
            }

            Serie serie = new Serie(reps, ejercicioSeleccionado, peso);
            seriesTemporales.add(serie);

            Label lblSerieInfo = new Label(serie.toString());
            lblSerieInfo.getStyleClass().add("serie-info");

            Button btnEliminar = new Button("X");
            btnEliminar.getStyleClass().add("btn-peligro");

            HBox filaVistaSerie = new HBox(10, lblSerieInfo, btnEliminar);
            filaVistaSerie.setAlignment(Pos.CENTER_LEFT);
            filaVistaSerie.getStyleClass().add("serie-row");

            btnEliminar.setOnAction(ev -> {
                seriesTemporales.remove(serie);
                listaSeriesBox.getChildren().remove(filaVistaSerie);
            });

            listaSeriesBox.getChildren().add(filaVistaSerie);

            cbEjercicio.setValue(null);
            txtReps.clear();
            txtPeso.clear();
        });

        // Botón guardar
        Button btnGuardar = new Button("Guardar Sesión");
        btnGuardar.getStyleClass().add("btn-primario");
        btnGuardar.setOnAction(e -> {
            String durStr = txtDuracion.getText().trim();
            if (durStr.isEmpty()) {
                mostrarError("La duración es obligatoria.");
                return;
            }
            int duracion;
            try {
                duracion = Integer.parseInt(durStr);
            } catch (NumberFormatException ex) {
                mostrarError("La duración debe ser un número entero.");
                return;
            }
            if (duracion <= 0) {
                mostrarError("La duración debe ser mayor que 0.");
                return;
            }

            String notas = txtNotas.getText().trim();
            if (notas.isEmpty()) notas = "-";

            Sesion sesion = new Sesion(duracion, notas);
            for (Serie s : seriesTemporales) {
                sesion.agregarSerie(s);
            }

            gestor.agregarSesion(sesion);
            mostrarInfo("Sesión guardada correctamente.");
            AppJavaFX.mostrarMenu();
        });

        HBox piePantalla = new HBox(btnGuardar);
        piePantalla.setAlignment(Pos.CENTER_RIGHT);
        piePantalla.setPadding(new Insets(15, 30, 20, 30));

        // Layout raíz
        VBox contenido = new VBox(
                cabecera,
                formGrid,
                new Separator(),
                lblSeries,
                filaNuevaSerie,
                listaSeriesBox,
                piePantalla
        );
        VBox.setVgrow(listaSeriesBox, Priority.ALWAYS);

        ScrollPane scroll = new ScrollPane(contenido);
        scroll.setFitToWidth(true);
        scroll.setId("scroll-principal");

        BorderPane raiz = new BorderPane(scroll);
        raiz.setId("pantalla-agregar");

        return new Scene(raiz, 900, 600);
    }

    private static void mostrarError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private static void mostrarInfo(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Exito");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
