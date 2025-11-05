package repository;

import db.Conexion;
import model.Venta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public List<Venta> listar() throws SQLException {
        List<Venta> lista = new ArrayList<>();
        String sql = "SELECT * FROM ventas";
        try (Connection conn = Conexion.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Venta(
                    rs.getInt("id"),
                    rs.getInt("id_bicicleta"),
                    rs.getInt("cantidad"),
                    rs.getString("fecha")
                ));
            }
        }
        return lista;
    }
}
