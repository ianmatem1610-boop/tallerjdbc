package com.krakdev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeleteVehiculo {
    private static final Logger logger = LoggerFactory.getLogger(DeleteVehiculo.class);

    public static void eliminar(String placa) {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "DELETE FROM vehiculos WHERE placa = ?";
        
        try {
            con = Conexion.conectar();
            if (con != null) {
                ps = con.prepareStatement(sql);
                ps.setString(1, placa);

                int filasAfectadas = ps.executeUpdate();
                System.out.println("Filas eliminadas: " + filasAfectadas);
                logger.info("Vehículo eliminado correctamente: " + placa);
            }
        } catch (SQLException e) {
            logger.error("Error al eliminar el vehículo: " + e.getMessage());
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