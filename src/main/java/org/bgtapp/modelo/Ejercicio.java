package org.bgtapp.modelo;

public class Ejercicio {

    private String nombre;
    private String tipo;
    private String categoria;

    public Ejercicio(String nombre, String tipo, String categoria) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return nombre + " || " + categoria +  " || " + tipo;
    }
}
