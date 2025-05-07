package com.aicija.Retos;

import jakarta.persistence.*;


@Entity
@Table(name = "asignaturas")
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Resto de atributos o wrapper
    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;
    @Column(length = 450)
    private String descripcion;
    private String docente;
    @Column(length = 3, nullable = false)
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

/*

Características y uso de @Column:

    -name:
    Define el nombre de la columna en la base de datos. Si no se especifica, se utiliza el nombre del atributo de la clase.
    -length:
    Especifica la longitud máxima de la columna (solo para Strings). Se ignora para otros tipos de datos.
    -nullable:
    Indica si la columna permite valores nulos. Por defecto, es true (permite nulos).
    -unique:
    Indica si la columna debe ser única. Por defecto, es false.
    -insertable:
    Indica si el valor de la columna se insertará en la base de datos durante la inserción. Por defecto, es true.
    -updatable:
    Indica si el valor de la columna se actualizará en la base de datos durante la actualización. Por defecto, es true.
    -columnDefinition:
    Permite definir el tipo de columna y otras características específicas de la base de datos, utilizando el lenguaje SQL de la base de datos.

Ejemplo:
Java

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 50, nullable = false, unique = true)
    private String nombre;

    @Column(name = "email", length = 100)
    private String email;

    // ... getters y setters
}

En este ejemplo, la anotación @Column se utiliza para:

    nombre: Define la columna como nombre en la base de datos, con una longitud máxima de 50 caracteres, no puede ser nulo y debe ser única.
    email: Define la columna como email con una longitud máxima de 100 caracteres.

La anotación @Column es fundamental para mapear las propiedades de una entidad Java a columnas en la base de datos cuando se trabaja con JPA y Spring Data JPA.

 */
