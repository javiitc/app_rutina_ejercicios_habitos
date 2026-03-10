package org.bgtapp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionDB {

    private static final String URL = "jdbc:sqlite:bgt.db";

    public static Connection getConexion() {
        try {
            return DriverManager.getConnection(URL);
        } catch (SQLException e) {
            throw new RuntimeException("Error al conectar con la base de datos: " + e);
        }
    }

    public static void iniciarTablas() {
        try {
            Connection con = getConexion();
            Statement statement = con.createStatement();

            String sql = """
                    CREATE TABLE IF NOT EXISTS sesiones (
                    id_sesion INTEGER PRIMARY KEY AUTOINCREMENT,
                    fecha TEXT(20) NOT NULL,
                    duracion_min INTEGER NOT NULL,
                    notas TEXT(200)
                    )
            """;
            statement.execute(sql);

            String sql2 = """
                    CREATE TABLE IF NOT EXISTS series (
                    id_serie INTEGER PRIMARY KEY AUTOINCREMENT,
                    nombre TEXT(50) NOT NULL,
                    tipo TEXT(20) NOT NULL,
                    grupo_muscular TEXT(40) NOT NULL,
                    repeticiones INTEGER NOT NULL,
                    peso REAL NOT NULL,
                    id_sesion INTEGER NOT NULL,
                    FOREIGN KEY (id_sesion) REFERENCES sesiones(id_sesion)
                    )
            """;
            statement.execute(sql2);
        } catch (SQLException e) {
            throw new RuntimeException("Error al iniciar base de datos: " + e);
        }
    }
}
