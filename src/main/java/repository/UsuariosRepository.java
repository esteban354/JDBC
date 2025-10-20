package repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.Conexion;
import model.Usuarios;

public class UsuariosRepository {
    public void insertarUsuario(Usuarios usuario) {
        String sql = "INSERT INTO USUARIOS (NOMBRE, EDAD) VALUES (?, ?)";

        try(Connection connection = Conexion.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

                preparedStatement.setString(1, usuario.getNombre());
                preparedStatement.setLong(2, usuario.getEdad());

                preparedStatement.executeUpdate();

                System.out.print("Usuario insertado correctamente: " + usuario.getNombre());
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public void listarUsuarios() {
        String sql = "SELECT * FROM usuarios";

        try (Connection connection = Conexion.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                Long id = rs.getLong("id_usuarios");
                String nombre = rs.getString("nombre");
                Long edad = rs.getLong("edad");

                System.out.println("id: " + id + " Nombre: " + nombre + " Edad: " + edad);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void borrarUsuario(Usuarios usuarios){
        String sql = "DELETE FROM usuarios WHERE id_usuarios = ?";
         try (Connection connection = Conexion.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, usuarios.getId());
            preparedStatement.executeUpdate();

            System.out.println("Usuario eliminado");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actualizarUsuario(Usuarios usuarios){
         String sql = "UPDATE usuarios SET nombre = ?, edad = ? WHERE id_usuarios = ?";
         try (Connection connection = Conexion.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, usuarios.getNombre());
            preparedStatement.setLong(2, usuarios.getEdad());
            preparedStatement.setLong(3, usuarios.getId());    

            preparedStatement.executeUpdate();
            System.out.println("Usuario actualizado");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}