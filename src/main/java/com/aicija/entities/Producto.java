package com.aicija.entities;


import jakarta.persistence.*;

@Entity // indeica que esta clase es una tabla
@Table(name = "productos") // personaliza el nombre de la tabla
public class Producto {

    @Id // indica que este atributo es la clave primaria
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Double precio;
    private Integer stock;
    private Boolean disponible;



    
}
