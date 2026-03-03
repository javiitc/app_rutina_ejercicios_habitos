package org.bgtapp.modelo;

import java.util.ArrayList;

public class GestorSesiones {

    private ArrayList<Sesion> sesiones;

    public GestorSesiones(){
        this.sesiones = new ArrayList<>();
    }

    public void agregarSesion(Sesion s){
        this.sesiones.add(s);
    }

    public void listarSesiones () {
        for (Sesion s: sesiones){
            System.out.println(s);
        }
    }
    public ArrayList<Sesion> getSesiones() {
        return sesiones;
    }
}
