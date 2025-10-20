import java.util.Scanner;

import model.Usuarios;
import repository.UsuariosRepository;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Que deseas hacer \n1. Ingresar usuario \n2. Listar usuario \n3. Eliminar un usuario \n4. Actualizar un usuario\n");
        int opcion = scanner.nextInt();
        UsuariosRepository usuariosRepository = new UsuariosRepository();

        switch (opcion) {
            case 1:
                System.out.print("Ingrese el nombre: ");
                String nombre = scanner.next();

                System.out.print("Ingrese la edad: ");
                Long edad = scanner.nextLong();

                Usuarios usuario = new Usuarios(nombre, edad);
                usuariosRepository.insertarUsuario(usuario);
            break;
        
            case 2:
                System.out.println("Lista de los usuarios:");
                usuariosRepository.listarUsuarios();
            break;

            case 3:
                System.out.print("Ingrese el id del usuario que desea eliminar: ");
                Long id = scanner.nextLong();

                Usuarios usuarioEliminado = new Usuarios(id);
                usuariosRepository.borrarUsuario(usuarioEliminado);
                usuariosRepository.listarUsuarios();
            break;

            case 4:
                System.out.print("Ingrese el id del usuario: ");
                Long idActualizar = scanner.nextLong();

                System.out.print("Ingrese el nombre: ");
                String nuevoNombre = scanner.next();

                System.out.print("Ingrese la edad: ");
                Long nuevaEdad = scanner.nextLong();

                Usuarios usuarioActualizado = new Usuarios(idActualizar, nuevoNombre, nuevaEdad);
                usuariosRepository.actualizarUsuario(usuarioActualizado);
                usuariosRepository.listarUsuarios();
            break;
            
            default:
                System.out.println("Opcion incorrecta ");
            break;
        }
    scanner.close();
    }
}
