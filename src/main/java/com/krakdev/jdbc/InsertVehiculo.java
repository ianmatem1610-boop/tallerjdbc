package com.krakdev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InsertVehiculo {
    private static final Logger logger = LoggerFactory.getLogger(InsertVehiculo.class);

    public static void insertar(String placa, String marca, String modelo, int anio, double precio, String color, boolean disponible, int kilometraje) {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO vehiculos (placa, marca, modelo, anio, precio, color, disponible, kilometraje) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            con = Conexion.conectar();
            if (con != null) {
                ps = con.prepareStatement(sql);
                ps.setString(1, placa);
                ps.setString(2, marca);
                ps.setString(3, modelo);
                ps.setInt(4, anio);
                ps.setDouble(5, precio);
                ps.setString(6, color);
                ps.setBoolean(7, disponible);
                ps.setInt(8, kilometraje);
                
                ps.executeUpdate();
                logger.info("Vehículo insertado correctamente: " + placa);
            }
        } catch (SQLException e) {
            logger.error("Error al insertar el vehículo: " + e.getMessage());
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                logger.error("Error al cerrar recursos: " + e.getMessage());
            }
        }
    }
}