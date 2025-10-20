package model;

public class Usuarios {
    private Long id;
    private String nombre;
    private Long edad;

    public Usuarios(String nombre, Long edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public Usuarios(Long id, String nombre, Long edad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
    }

    public Usuarios(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Long getEdad() {
        return edad;
    }
}
