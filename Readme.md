# Explicacion de Spring Boot

En el fichero Producto, se detalla la explicación de como crear una Entity

## En MVC

Creacion de las carpetas y buenas practicas(asi se tiene que hacer para una mejor practica):

*Entities
    *Producto (javaclass)


*Repositories
    *ProductoRepository (interface)


// Clase Entity Basica asi se crean siempre
// UN tipo primitivo nunca tendrá valor null, por eso, se usan datos NO primitivos o llamados clases envolventes o wrapper classes
// ojo cuando creamos las claves primarias siempre se crean asi
/*
Poner el atributo que sera Primary Key debajo de @GeneratedValue FOREVER
// Creación de Primary Key y será autoincrementable
@Id // indica que este atributo es la clave primaria
@GeneratedValue(strategy =  GenerationType.IDENTITY)
private Long nombreAtributo;
*/

    /*
       Desde esta clase se puede crear directamente un productoRepository con boton right show sprindatarepository

     */

// declaracion de wrapper classes o clases envoltorios o envolventes,
// por eso el primera letra del tipo de dato va en mayusculas. Y pueden ser null

PLUGINS (buscar en Marketplace):

- JPA Buddy
- Lombok
- Jakarta EE: JPA Model

