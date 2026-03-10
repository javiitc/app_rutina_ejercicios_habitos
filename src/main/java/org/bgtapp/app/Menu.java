package org.bgtapp.app;

import org.bgtapp.modelo.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

     private GestorSesiones gestorSesiones;
     private Scanner sc;
     private CatalogoEjercicios catalogoEjercicios;

    public Menu(){
        this.gestorSesiones = new  GestorSesiones();
        this.sc = new Scanner(System.in);
        this.catalogoEjercicios = new CatalogoEjercicios();
    }

    public GestorSesiones getGestorSesiones() {
        return gestorSesiones;
    }

    public void setGestorSesiones(GestorSesiones gestorSesiones) {
        this.gestorSesiones = gestorSesiones;
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }

    public void iniciarMenu(){

        boolean continuar = true;
        int eleccion;

        System.out.println("================================");
        System.out.println("            BGT APP");
        System.out.println("================================");

        while (continuar){
            System.out.println("1. Nueva sesión");
            System.out.println("2. Ver sesiones realizadas");
            System.out.println("3. Salir");

            eleccion = sc.nextInt();

            switch (eleccion){
                case 1:
                    nuevaSesion();
                    break;
                case 2:
                    verSesion();
                    break;
                case 3:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opcion no cálida, intentelo de nuevo");
                    break;
            }
        }

    }

    public void nuevaSesion() {

        System.out.println("Añade la duración de la sesión");
        int duracion = sc.nextInt();
        sc.nextLine(); //Esto es para solventar el conocido error de que nextInt deja un salto de línea pendiente, y este lo lee el siguiente nextLine
        System.out.println("Quieres añadir alguna nota?");
        String nota = sc.nextLine();

        if  (nota.isEmpty()){
            nota = "-";
        }

        Sesion sesion = new Sesion(duracion, nota);

        boolean introducirSerie = true;

        while (introducirSerie){
            System.out.println("Introducir serie? \n" +
                    "1. SI || 2. NO");

            int eleccion2 = sc.nextInt();
            sc.nextLine();

            if  (eleccion2 == 1){

                System.out.println("Elige el ejercicio a introducir:");

                ArrayList <Ejercicio> listaEjercicios = catalogoEjercicios.cargarEjercicios();
                for (int i = 0; i < listaEjercicios.size(); i++){
                    System.out.println((i+1) + ". " + listaEjercicios.get(i).getNombre());
                }

                int eleccionEjercicio = sc.nextInt();

                Ejercicio ejercicio = listaEjercicios.get(eleccionEjercicio - 1);

                System.out.println("Numero de repeticiones:");
                int repeticiones = sc.nextInt();
                System.out.println("Peso:");
                double peso = sc.nextDouble();

                Serie serie = new  Serie(repeticiones, ejercicio, peso);

                sesion.agregarSerie(serie);
            } else  if (eleccion2 == 2){
                introducirSerie = false;
            }
        }

        gestorSesiones.agregarSesion(sesion);
        System.out.println("Sesion guardada correctamente");
    }

    public void verSesion() {
        gestorSesiones.listarSesiones();
    }
}
