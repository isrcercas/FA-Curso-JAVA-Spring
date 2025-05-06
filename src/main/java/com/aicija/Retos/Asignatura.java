package com.aicija.Retos;

import jakarta.persistence.*;


@Entity
@Table(name = "asignaturas")
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Resto de atributos
    @Column(nullable = false)
    private String nombre;
    private String descripcion;
    private String docente;
    @Column(nullable = false)
    private Integer ects;
    private Boolean optativa;
    

    // Metodo constructor vacio
    public Asignatura() {}
    // Metodo con parametros

    public Asignatura(String nombre, String descripcion, String docente, Integer ects, Boolean optativa) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.docente = docente;
        this.ects = ects;
        this.optativa = optativa;
    }
    // Metodos Getter y Setter

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

    public String getDocente() {
        return docente;
    }
    public void setDocente(String docente) {
        this.docente = docente;
    }

    public Integer getEcts() {
        return ects;
    }
    public void setEcts(Integer ects) {
        this.ects = ects;
    }

    public Boolean getOptativa() {
        return optativa;
    }
    public void setOptativa(Boolean optativa) {
        this.optativa = optativa;
    }
    // Metodo to String

    @Override
    public String toString() {
        return "Asignatura{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", docente='" + docente + '\'' +
                ", ects=" + ects +
                ", optativa=" + optativa +
                '}';
    }
}
/*
Crear una entidad básica en Spring Boot con JPA

Crea una entidad llamada Asignatura. La entidad debe tener los siguientes atributos:

Un identificador único (id) de tipo Long que sea la clave primaria y se genere automáticamente
Un nombre (nombre) de tipo String
Una descripción (descripcion) de tipo String
El nombre del docente que impartirá la asignatura (nombreDocente) de tipo String
Los créditos ECTS (creditos) de tipo entero
Si la asignatura es optativa o no (optativa)

Asegúrate de:

Usar las anotaciones de JPA adecuadas para definir la entidad y sus propiedades
Incluir anotaciones de validación donde sea necesario
Implementar un constructor vacío y otro con todos los campos excepto el id
Incluir métodos getter y setter para todos los atributos
*/
