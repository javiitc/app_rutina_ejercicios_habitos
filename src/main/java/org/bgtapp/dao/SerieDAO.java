package org.bgtapp.dao;

import org.bgtapp.db.ConexionDB;
import org.bgtapp.modelo.Ejercicio;
import org.bgtapp.modelo.Serie;
import org.bgtapp.modelo.Sesion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SerieDAO {

    public void guardar(Serie s, int idSesion) {

        try {
            String sql = "INSERT INTO series (nombre, tipo, grupo_muscular, repeticiones, peso, id_sesion) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = ConexionDB.getConexion().prepareStatement(sql);
            ps.setString(1, s.getEjercicio().getNombre());
            ps.setString(2, s.getEjercicio().getTipo());
            ps.setString(3, s.getEjercicio().getGrupoMuscular());
            ps.setInt(4, s.getRepeticiones());
            ps.setDouble(5, s.getPeso());
            ps.setInt(6, idSesion);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al conectarse a la base de datos" + e);
        }

    }

    public ArrayList<Serie> obtenerPorSesion (int idSesion) {

        ArrayList<Serie> series = new ArrayList<>();

        try {
            String sql = "SELECT * FROM series WHERE id_sesion = ?";
            PreparedStatement ps = ConexionDB.getConexion().prepareStatement(sql);
            ps.setInt(1, idSesion);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                //Extraer datos para reconvertirlos en un objeto de Java
                String nombre = rs.getString("nombre");
                String tipo = rs.getString("tipo");
                String grupoMuscular = rs.getString("grupo_muscular");
                int repeticiones = rs.getInt("repeticiones");
                double peso = rs.getDouble("peso");

                Ejercicio ejercicio = new Ejercicio(nombre, tipo, grupoMuscular);
                Serie serie = new Serie(repeticiones, ejercicio, peso);

                series.add(serie);
            }

        } catch (SQLException e) {
            System.out.println("Error al conectarse a la base de datos" + e);
        }

        return series;
    }
}
