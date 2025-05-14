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
    private Long id_categoria;
    // declaracion de wrapper classes o clases envoltorios o envolventes
    @Column(nullable = false)
    private String nombre;
    @Column(length = 400)
    private String descripcion;

    public Categoria() {
    }

    public Categoria(String nombre, String descricion) {
        this.nombre = nombre;
        this.descripcion = descricion;
    }

    public Long getId() {
        return id_categoria;
    }

    public void setId(Long id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescricion() {
        return descripcion;
    }

    public void setDescricion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id_categoria=" + id_categoria +
                ", nombre='" + nombre + '\'' +
                ", descricion='" + descripcion + '\'' +
                '}';
    }



}
