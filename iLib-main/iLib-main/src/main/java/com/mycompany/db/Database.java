package com.mycompany.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    protected Connection conexion;
    private final String JDBC_DRIVER = "org.postgresql.Driver"; // Driver de PostgreSQL
    private final String DB_URL = "jdbc:postgresql://localhost:5432/db_libreria"; // URL de PostgreSQL
    private final String USER = "postgres"; // Usuario de PostgreSQL
    private final String PASS = "Cano2004"; // Contraseña de PostgreSQL

    public void Conectar() throws ClassNotFoundException, SQLException {
        try {
            Class.forName(JDBC_DRIVER); // Cargar el driver de PostgreSQL
            conexion = DriverManager.getConnection(DB_URL, USER, PASS); // Establecer conexión
        } catch (SQLException ex) {
            throw ex; // Lanza la excepción para que pueda manejarse en el lugar donde se llama al método
        }
    }

    public void Cerrar() throws SQLException {
        if (conexion != null && !conexion.isClosed()) {
            conexion.close();
        }
    }

    // Método para obtener la conexión
    public Connection getConexion() {
        return conexion;
    }
}
