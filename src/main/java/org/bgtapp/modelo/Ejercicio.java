package org.bgtapp.modelo;

public class Ejercicio {

    private String nombre;
    private String tipo;
    private String grupoMuscular;

    public Ejercicio(String nombre, String tipo, String grupoMuscular) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.grupoMuscular = grupoMuscular;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGrupoMuscular() {
        return grupoMuscular;
    }

    public void setGrupoMuscular(String grupoMuscular) {
        this.grupoMuscular = grupoMuscular;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return nombre + " || " + grupoMuscular +  " || " + tipo;
    }
}
