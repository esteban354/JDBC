package repository;

import db.Conexion;
import model.Venta;

import java.sql.*;

public class VentaRepository {

    public void registrar(Venta venta) throws SQLException {
        String sql = "INSERT INTO ventas (id, id_bicicleta, cantidad, fecha) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, venta.getId());
            stmt.setInt(2, venta.getIdBicicleta());
            stmt.setInt(3, venta.getCantidad());
            stmt.setString(4, venta.getFecha().toString());
            stmt.executeUpdate();
        }
    }

    public void listar() {
        String sql = "SELECT * FROM ventas";

        try {
            Connection conn = Conexion.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("Ventas registradas:");
            while (rs.next()) {
                int id = rs.getInt("id");
                int idBicicleta = rs.getInt("id_bicicleta");
                int cantidad = rs.getInt("cantidad");
                String fecha = rs.getString("fecha");

                System.out.println("ID: " + id + " Bicicleta ID: " + idBicicleta + " Cantidad: " + cantidad + " Fecha: " + fecha);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Error al listar ventas: " + e.getMessage());
        }
    }
}
