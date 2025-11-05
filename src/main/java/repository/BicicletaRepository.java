package repository;

import db.Conexion;
import model.Bicicleta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BicicletaRepository {

    public void agregar(Bicicleta bici) throws SQLException {
        String sql = "INSERT INTO bicicletas (id, marca, modelo, precio, stock) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, bici.getId());
            stmt.setString(2, bici.getMarca());
            stmt.setString(3, bici.getModelo());
            stmt.setDouble(4, bici.getPrecio());
            stmt.setInt(5, bici.getStock());
            stmt.executeUpdate();
        }
    }

    public void listar() throws SQLException {
    String sql = "SELECT * FROM bicicletas";

    try (Connection conn = Conexion.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {

        System.out.println("Bicicletas registradas:");
        while (rs.next()) {
            int id = rs.getInt("id");
            String marca = rs.getString("marca");
            String modelo = rs.getString("modelo");
            double precio = rs.getDouble("precio");
            int stock = rs.getInt("stock");

            System.out.println("ID: " + id +" | Marca: " + marca +" | Modelo: " + modelo + " | Precio: $" + precio +" | Stock: " + stock);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    public void actualizarStock(int id, int nuevoStock) throws SQLException {
        String sql = "UPDATE bicicletas SET stock = ? WHERE id = ?";
        try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, nuevoStock);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }
    }
}
