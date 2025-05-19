package com.aicija.repositories;

import com.aicija.entities.Categoria;
import com.aicija.entities.Producto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest    // esta anotacion indica que debe usar Spring e inicilizar los repositorios
class ProductoRepositoryTest {

    // inyeccion de dependencias
    // inyectamos el objeto categoriaRepository para poderlo usar.
    // Para usar un repositorio o una clase se utiliza @DataJpaTest y @Autowired
    @Autowired
    CategoriaRepository categoriaRepository;
    @Autowired
    ProductoRepository productoRepository;

    @Test   // si no ponemos test no lo podremos probar
    @DisplayName("Crear objeto categoria y producto, sin guardar")
        /*
         *   se puede medir la cobertura de ejecucion with coverage
         *   la cobertura seria las lineas has alcanzado con los test.
         *   la cobertura suele ser entre el 75% al 100%
         *
         * */
    void crearProductosTest() {

        Categoria ropa = new Categoria("ropa", "Articulos textiles");
        Producto p1 = new Producto("p1", 12.80, 2, true, ropa);

        System.out.println(ropa);
        System.out.println(p1);
        ;

        assertNotNull(ropa);
        assertNotNull(p1);
    }

    @Test
    void saveCategoriaTest() {

        Categoria ropa = new Categoria("ropa", "Articulos textiles");

        categoriaRepository.save(ropa);
        assertNotNull(ropa.getId());
        assertEquals(1L, ropa.getId());
    }

    @Test
    void saveProductoTest() {

        Categoria ropa = new Categoria("ropa", "Artículos textiles");
        categoriaRepository.save(ropa);
        Producto p1 = new Producto("p1", 19.99, 1, true, ropa);
        productoRepository.save(p1);
        // para verificar sentencias, en este caso seria para saber si no es nulo
        assertNotNull(p1);
        assertNotNull(p1.getId()); // verifica que se haya generado un id al guardar
        assertNotNull(ropa);
        assertNotNull(ropa.getId());

    }
    @Test
    void buscarProductoTest(){
        //  Save Product
        Producto p1 = new Producto("p1", 19.99, 1, true, null);
        productoRepository.save(p1);

        Long productId = p1.getId();
        // Optional es un envoltorio para envolver objeto
        // https://app.certidevs.com/tecnologias/89aebf6d-32f9-306d-678b-0f2e895b3ad1/leccion/898620d9-283a-63dc-81c2-d9e4937d1cf8
        // Search product
        Optional<Producto> productoOptional = productoRepository.findById(productId);

        assertTrue(productoOptional.isPresent());

        Producto productoSave =productoOptional.get();
        System.out.println(productoSave);
        assertEquals(p1.getId(), productoSave.getId());
    }
}