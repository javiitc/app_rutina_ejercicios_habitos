package org.bgtapp.modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Sesion {

    private String fecha;
    private int duracion;
    private String notas;
    private int id;
    private ArrayList <Serie> series;

    public Sesion(int duracion, String notas) {
        this.fecha = LocalDate.now().toString();
        this.duracion = duracion;
        this.notas = notas;
        this.series = new ArrayList<>();
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public ArrayList<Serie> getSeries() {
        return series;
    }

    public void setSeries(ArrayList<Serie> series) {
        this.series = series;
    }

    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getFecha() {
        return fecha;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Duracion: " + duracion + " min " + " Notas: " + notas + "\n" +
                "Sesion realizada el " + fecha;
    }

    public void agregarSerie(Serie serie) {
        this.series.add(serie);
    }

}
