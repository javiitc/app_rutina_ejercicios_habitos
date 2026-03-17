package org.bgtapp;

import org.bgtapp.app.AppJavaFX;
import org.bgtapp.db.ConexionDB;

public class Main {
    public static void main(String[] args) {
        ConexionDB.iniciarTablas();
        AppJavaFX.launch(AppJavaFX.class, args);
    }
}
