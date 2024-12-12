
import com.mycompany.db.Database;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author calib
 */
public class TestDatabase {
    public static void main(String[] args) {
        Database db = new Database(); // Usa la clase Database ya configurada
        try {
            db.Conectar(); // Llama al método para establecer la conexión
            System.out.println("Conexión exitosa a la base de datos PostgreSQL.");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al cargar el driver: " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error al conectar a la base de datos: " + ex.getMessage());
        } finally {
            try {
                db.Cerrar(); // Cierra la conexión
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}
/*package com.mycompany.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        if (conexion != null) {
            if (!conexion.isClosed()) {
                conexion.close();
            }
        }
    }
}
*/