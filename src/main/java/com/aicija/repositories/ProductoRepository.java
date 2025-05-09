package com.aicija.repositories;

import com.aicija.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

  // spring boot implementa metodos basicos
  // findAll(), findById(), save(), delete(), etc..

/* Hechos a mano
  Producto findByName(String nombre);
  List<Producto> findByStockLessThan(Integer stock);
*/

  // Metodos derivados
  // Nos permiten crear metodos con el nombre de las consultas
  // para consultas simples
  // Creados automaticamente

  // Encontrar por nombre ignorando la capitalizacion o ignoreCase
  Producto findByNombreIgnoreCase(String nombre);

  // Encontrar por precio menos que
  List<Producto> findByPrecioLessThan(Double precio);

  // Encontrar por nombre si o no ignoreCase
  boolean existsByNombreIgnoreCase(String nombre);

  // Consultas JPQL
  // Similares a SQL orientadas a objetos
  // para consultas complejas

  // Encontrar por precio entre priceStart y priceEnd
  // automatico
  @Query("select p from Producto p where p.precio between :precioStart and :precioEnd")
  List<Producto> findByPrecioBetween(Double precioStart, Double precioEnd);
  // a mano
  @Query("select p from Producto p where p.precio between :priceMin and :priceMax")
  List<Producto> findByPriceBetween(@Param("priceMin") Double pMin, @Param("pricemax") Double pMax);



  }