package org.bgtapp.modelo;

import org.bgtapp.dao.SerieDAO;
import org.bgtapp.dao.SesionDAO;

import java.util.ArrayList;

public class GestorSesiones {

    private ArrayList<Sesion> sesiones;
    private SesionDAO sesionDAO;
    private SerieDAO serieDAO;

    public GestorSesiones(){

        this.sesiones = new ArrayList<>();
        this.sesionDAO = new SesionDAO();
        this.serieDAO = new SerieDAO();
        ArrayList <Sesion> listarSesiones = sesionDAO.obtenerTodasSesiones();

        if (listarSesiones != null) {
            this.sesiones = listarSesiones;

            for (Sesion sesion : this.sesiones) {
                ArrayList<Serie> series = serieDAO.obtenerPorSesion(sesion.getId());
                for (Serie serie : series) {
                    sesion.agregarSerie(serie);
                }
            }
        }
    }

    public void agregarSesion(Sesion s){

        this.sesiones.add(s);

        int idSesion = sesionDAO.guardar(s);
        for (Serie serie: s.getSeries()){
            serieDAO.guardar(serie, idSesion);
        }
    }

    public void listarSesiones () {
        for (Sesion s: sesiones){
            System.out.println(s);
            for (Serie s2: s.getSeries()){
                System.out.println(s2);
            }
        }

    }
    public ArrayList<Sesion> getSesiones() {
        return sesiones;
    }
}
