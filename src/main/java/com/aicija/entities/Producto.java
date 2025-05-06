package com.aicija.entities;


import jakarta.persistence.*;

@Entity // indeica que esta clase es una tabla
@Table(name = "productos") // personaliza el nombre de la tabla
public class Producto {

    // UN tipo primitivo nunca tendrá valor null, por eso, se usan datos NO primitivos o llamados clases envolventes o wrapper classes
    // ojo cuando creamos las claves primarias siempre se crean asi
    /*
        Poner el atributo que sera Primary Key debajo de @GeneratedValue FOREVER
        @Id // indica que este atributo es la clave primaria
        @GeneratedValue(strategy =  GenerationType.IDENTITY)
        private Long id;
     */

    // Creación de Primary Key
    @Id // indica que este atributo es la clave primaria
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    // declaracion de wrapper classes o clases envoltorios o envolventes
    private String nombre;
    private Double precio;
    private Integer stock;
    private Boolean disponible;
    // Siempre spring necesita un constructor vacio
    public Producto() {}

    // Creamos un creamos un constructor con parametros.
    public Producto(String nombre, Double precio, Integer stock, Boolean disponible) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.disponible = disponible;
    }

    // Getter y Setter

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
}
