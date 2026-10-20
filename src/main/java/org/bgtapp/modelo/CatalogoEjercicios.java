package org.bgtapp.modelo;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class CatalogoEjercicios {

    public ArrayList<Ejercicio> cargarEjercicios() {
        Gson gson = new Gson();
        FileReader leerJson = null;
        try {
            leerJson = new FileReader("src/main/resources/ejercicios.json");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        JsonObject jsonEjercicios = gson.fromJson(leerJson, JsonObject.class);

        JsonArray ejercicios = jsonEjercicios.getAsJsonArray("ejercicios");

        ArrayList<Ejercicio> listaEjercicios = new ArrayList<>();
        for (JsonElement ejercicio : ejercicios) {
            Ejercicio ej = gson.fromJson(ejercicio, Ejercicio.class);
            listaEjercicios.add(ej);
        }

        return listaEjercicios;
    }
}
