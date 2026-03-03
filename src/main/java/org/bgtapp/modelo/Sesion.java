package org.bgtapp.modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Sesion {

    private LocalDate fecha;
    private int duracion;
    private String notas;
    private ArrayList <Serie> series;

    public Sesion(int duracion, String notas) {
        this.fecha = LocalDate.now();
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

    public LocalDate getFecha() {
        return fecha;
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
