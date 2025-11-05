package model;

public class Venta {
    private int id;
    private int idBicicleta;
    private int cantidad;
    private String fecha;

    public Venta(int id, int idBicicleta, int cantidad, String fecha) {
        this.id = id;
        this.idBicicleta = idBicicleta;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public int getId() {
         return id; 
        }
        
    public int getIdBicicleta() {
         return idBicicleta; 
        }

    public int getCantidad() {
         return cantidad; 
        }

    public String getFecha() {
         return fecha; 
        }
}
