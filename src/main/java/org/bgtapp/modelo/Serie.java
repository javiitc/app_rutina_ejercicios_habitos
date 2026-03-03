package org.bgtapp.modelo;

public class Serie {

    private int repeticiones;
    private double peso;
    private Ejercicio ejercicio;

    public Serie(int repeticiones, Ejercicio ejercicio, double peso) {
        this.repeticiones = repeticiones;
        this.ejercicio = ejercicio;
        this.peso = peso;
    }

    public int getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(int repeticiones) {
        this.repeticiones = repeticiones;
    }

    public Ejercicio getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(Ejercicio ejercicio) {
        this.ejercicio = ejercicio;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString(){
        return ejercicio.getNombre() + " || Repeticiones: " + repeticiones + " || Peso: " + peso;
    }
}
