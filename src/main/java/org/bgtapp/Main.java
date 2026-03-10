package org.bgtapp;

import org.bgtapp.app.Menu;
import org.bgtapp.db.ConexionDB;
import org.bgtapp.modelo.*;

import java.util.ArrayList;

public class Main {
    static void main(String[] args) {
        ConexionDB.iniciarTablas();
        Menu menu = new Menu();
        menu.iniciarMenu();
    }
}
