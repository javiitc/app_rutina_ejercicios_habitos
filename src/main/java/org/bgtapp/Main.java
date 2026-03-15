package org.bgtapp;

import org.bgtapp.app.AppJavaFX;
import org.bgtapp.app.Menu;
import org.bgtapp.db.ConexionDB;
import org.bgtapp.modelo.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ConexionDB.iniciarTablas();
        AppJavaFX.launch(AppJavaFX.class, args);
        Menu menu = new Menu();
        menu.iniciarMenu();
    }
}
