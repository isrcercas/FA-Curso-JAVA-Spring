package com.aicija.entities;

import jakarta.persistence.*;
import com.aicija.entities.Categoria;

@Entity // indeica que esta clase es una tabla
@Table(name = "productos") // personaliza el nombre de la tabla es una anotacion
public class Producto {
    // Clase Entity Basica asi se crean siempre
    // UN tipo primitivo nunca tendrá valor null, por eso, se usan datos NO primitivos o llamados clases envolventes o wrapper classes
    // ojo cuando creamos las claves primarias siempre se crean asi
    /*
        Poner el atributo que sera Primary Key debajo de @GeneratedValue FOREVER
        // Creación de Primary Key y será autoincrementable
        @Id // indica que este atributo es la clave primaria
        @GeneratedValue(strategy =  GenerationType.IDENTITY)
        private Long nombreAtributo;

       Desde esta clase se puede crear directamente un productoRepository con boton right show sprindatarepository

     */

    // Creación de Primary Key y será autoincrementable
    @Id // indica que este atributo es la clave primaria
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id_producto;


    // declaracion de wrapper classes o clases envoltorios o envolventes,
    // por eso el primera letra del tipo de dato va en mayusculas. Y pueden ser null
    @Column(nullable = false) // este campo o atributo sera obligatorio nunca estará vacio
    private String nombre;
    private Double precio;
    private Integer stock;
    private Boolean disponible;

    // Ahora en Producto lo hemos relacionado como many to one con Categoria
    // Relacion muchos producto a una sola categoria
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }


    // Siempre spring necesita un constructor vacio
    public Producto() {} // es obligatorio

    // Creamos un creamos un constructor con parametros.
    public Producto(String nombre, Double precio, Integer stock, Boolean disponible, Categoria categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.disponible = disponible;
        this.categoria = categoria;
    }

    // Getter y Setter



    public Long getId() {
        return id_producto;
    }
    public void setId(Long id) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Boolean getDisponible() {
        return disponible;
    }
    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    // Metodo ToString


    @Override
    public String toString() {
        return "Producto{" +
                "id_producto=" + id_producto +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                ", disponible=" + disponible +
                ", categoria=" + categoria +
                '}';
    }
}
