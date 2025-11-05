import model.Bicicleta;
import model.Venta;
import repository.BicicletaRepository;
import repository.VentaRepository;

import java.sql.SQLException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        BicicletaRepository biciRepo = new BicicletaRepository();
        VentaRepository ventaRepo = new VentaRepository();
        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                System.out.println("\nMenú Inventario Bicicletas");
                System.out.println("1. Agregar bicicleta");
                System.out.println("2. Registrar venta");
                System.out.println("3. Ver inventario");
                System.out.println("4. Salir");
                System.out.print("Seleccione una opción: ");
                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.print("ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Marca: ");
                        String marca = scanner.nextLine();
                        System.out.print("Modelo: ");
                        String modelo = scanner.nextLine();
                        System.out.print("Precio: ");
                        double precio = scanner.nextDouble();
                        System.out.print("Stock: ");
                        int stock = scanner.nextInt();

                        Bicicleta bici = new Bicicleta(id, marca, modelo, precio, stock);
                        biciRepo.agregar(bici);
                        System.out.println("Bicicleta agregada.");
                        break;

                    case 2:
                        System.out.print("ID venta: ");
                        int idVenta = scanner.nextInt();
                        System.out.print("ID bicicleta: ");
                        int idBici = scanner.nextInt();
                        System.out.print("Cantidad vendida: ");
                        int cantidad = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Ingrese la fecha: ");
                        String fecha = scanner.nextLine();

                        Venta venta = new Venta(idVenta, idBici, cantidad, fecha);
                        ventaRepo.registrar(venta);
                        break;

                    case 3:
                        System.out.println("\nInventario:");
                        try {
                            biciRepo.listar(); 
                        } catch (SQLException e) {
                            System.out.println("Error al mostrar inventario: " + e.getMessage());
                        }
                        break;
                    
                    case 4:
                        System.out.println("Saliendo del sistema...");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Opción inválida.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
