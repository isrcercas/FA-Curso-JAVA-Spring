package com.aicija.entities;

// Empezamos con las relaciones
// many to one muchos a uno
import jakarta.persistence.*;

@Entity
@Table( name = "categorias")
public class Categoria {

    // Creamos el PrimaryKey
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // declaracion de wrapper classes o clases envoltorios o envolventes
    @Column(nullable = false)
    private String nombre;
    @Column(length = 400)
    private String descripcion;



    public Categoria() {
    }

    public Categoria(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id_categoria=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }



}
