package com.krakdev.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Conexion {
    private static final Logger logger = LoggerFactory.getLogger(Conexion.class);
    
    private static final String URL = "jdbc:postgresql://localhost:5432/tallerjdbc";
    private static final String USER = "postgres";
    private static final String PASS = "16103014";

    public static Connection conectar() {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(URL, USER, PASS);
            logger.info("Conexión realizada con éxito a PostgreSQL");
        } catch (SQLException e) {
            logger.error("Error de conexión a la base de datos: " + e.getMessage());
        }
        return conexion;
    }
}