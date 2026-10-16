package com.krakdev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UpdateVehiculo {
    private static final Logger logger = LoggerFactory.getLogger(UpdateVehiculo.class);

    public static void actualizar(String placa, double precio, boolean disponible, int kilometraje) {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "UPDATE vehiculos SET precio = ?, disponible = ?, kilometraje = ? WHERE placa = ?";
        
        try {
            con = Conexion.conectar();
            if (con != null) {
                ps = con.prepareStatement(sql);
                ps.setDouble(1, precio);
                ps.setBoolean(2, disponible);
                ps.setInt(3, kilometraje);
                ps.setString(4, placa);

                int filasAfectadas = ps.executeUpdate();
                System.out.println("Filas afectadas: " + filasAfectadas);
                logger.info("Vehículo actualizado correctamente: " + placa);
            }
        } catch (SQLException e) {
            logger.error("Error al actualizar el vehículo: " + e.getMessage());
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