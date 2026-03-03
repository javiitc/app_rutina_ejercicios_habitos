package org.bgtapp;

import org.bgtapp.app.Menu;
import org.bgtapp.modelo.Ejercicio;
import org.bgtapp.modelo.GestorSesiones;
import org.bgtapp.modelo.Serie;
import org.bgtapp.modelo.Sesion;

public class Main {
    static void main(String[] args) {

        Menu menu = new Menu();
        menu.iniciarMenu();

        Ejercicio ejercicio = new Ejercicio("Press Banca", "Fuerza", "Pecho");
        Ejercicio ejercicio2 = new Ejercicio("Dominadas", "Fuerza", "Espalda");

        Sesion sesion = new Sesion(120, "-");
        Sesion sesion2 = new Sesion(90, "PR en sentadilla");
        Sesion sesion3 = new Sesion(70, "RM en Press Banca");

        Serie serie = new Serie(10, ejercicio, 90);
        Serie serie2 = new Serie(7, ejercicio, 90);
        Serie serie3 = new Serie(8, ejercicio2, 10);

        GestorSesiones gestorSesiones = new GestorSesiones();

        // Añadimos las series al arrayList vacío (creado al momento de crear el objeto sesion) llamando al método

        sesion.agregarSerie(serie);
        sesion.agregarSerie(serie2);
        sesion.agregarSerie(serie3);

        gestorSesiones.agregarSesion(sesion);
        gestorSesiones.agregarSesion(sesion2);
        gestorSesiones.agregarSesion(sesion3);


        System.out.println(sesion); //Hacemos un print de la sesion, que es el toString en la clase Sesion, que es info básica
        for (Serie series: sesion.getSeries()) {
            System.out.println(series);
        } // Con el for each leemos el array y hacemos print de toda la información de las series, previamente creadas

        gestorSesiones.listarSesiones();
    }
}
