package org.bgtapp.dao;

import org.bgtapp.db.ConexionDB;
import org.bgtapp.modelo.Sesion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SesionDAO {

    public int guardar(Sesion s){

        try  {
            String sql = "INSERT INTO sesiones (fecha, duracion_min, notas) VALUES (?, ?, ?)";
            PreparedStatement ps = ConexionDB.getConexion().prepareStatement(sql);

            ps.setString(1, s.getFecha());
            ps.setInt(2, s.getDuracion());
            ps.setString(3, s.getNotas());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Error al conectarse a la base de datos" + e);
        }

        return -1;
    }

    public ArrayList<Sesion> obtenerTodasSesiones() {

        ArrayList<Sesion> sesiones = new  ArrayList<>();

        try {
            String sql = "SELECT * FROM sesiones";
            PreparedStatement ps = ConexionDB.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String fecha = rs.getString("fecha");
                int duracion = rs.getInt("duracion_min");
                String notas = rs.getString("notas");

                Sesion sesion = new Sesion(duracion, notas);
                sesion.setId(rs.getInt("id_sesion"));
                sesion.setFecha(fecha);
                sesiones.add(sesion);
            }
        } catch (SQLException e) {
            System.out.println("Error al conectarse a la base de datos" + e);
        }

        return sesiones;
    }
}
