package com.aicija.entities;


import jakarta.persistence.*;

@Entity
@Table( name = "Categoria")
public class Categoria {

    // Creamos el PrimaryKey
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    // declaracion de wrapper classes o clases envoltorios o envolventes



}
