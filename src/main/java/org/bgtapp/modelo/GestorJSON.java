package org.bgtapp.modelo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.imageio.IIOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class GestorJSON {

    private static final String RUTA = "src/main/resources/sesiones.json";

    public void guardarSesiones (ArrayList<Sesion> sesiones){

        Gson gson = new Gson();

        try {
            FileWriter escribirJson = new FileWriter(RUTA);
            String json = gson.toJson(sesiones);
            escribirJson.write(json);
            escribirJson.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList<Sesion> cargarSesiones() {
        Type tipo = new  TypeToken<ArrayList<Sesion>>() {}.getType();
        Gson gson = new Gson();
        FileReader leerJson = null;
        ArrayList<Sesion> sesiones = null;

        try {
            leerJson = new FileReader("src/main/resources/sesiones.json");
            sesiones = gson.fromJson(leerJson, tipo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return sesiones;
    }
}
