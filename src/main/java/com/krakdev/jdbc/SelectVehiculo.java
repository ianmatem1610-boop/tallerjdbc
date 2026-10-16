package com.krakdev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SelectVehiculo {
    private static final Logger logger = LoggerFactory.getLogger(SelectVehiculo.class);

    public static void listar() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT placa, marca, modelo, anio, precio, color, disponible, kilometraje FROM vehiculos";
        
        try {
            con = Conexion.conectar();
            if (con != null) {
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                
                System.out.println("=== LISTA DE VEHÍCULOS ===");
                while (rs.next()) {
                    System.out.println("Placa: " + rs.getString("placa") + 
                                       " | Marca: " + rs.getString("marca") + 
                                       " | Modelo: " + rs.getString("modelo") + 
                                       " | Año: " + rs.getInt("anio") + 
                                       " | Precio: $" + rs.getDouble("precio") + 
                                       " | Color: " + rs.getString("color") + 
                                       " | Disponible: " + rs.getBoolean("disponible") + 
                                       " | Km: " + rs.getInt("kilometraje"));
                }
                logger.info("Vehículos listados correctamente");
            }
        } catch (SQLException e) {
            logger.error("Error al listar vehículos: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                logger.error("Error al cerrar recursos: " + e.getMessage());
            }
        }
    }
}