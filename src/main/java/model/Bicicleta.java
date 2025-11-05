package model;

public class Bicicleta {
    private int id;
    private String marca;
    private String modelo;
    private double precio;
    private int stock;

    public Bicicleta(int id, String marca, String modelo, double precio, int stock) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.stock = stock;
    }

    // Getters y setters
    public int getId() { return id; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public double getPrecio() { return precio; }
    public int getStock() { return stock; }

    public void setStock(int stock) { this.stock = stock; }
}
