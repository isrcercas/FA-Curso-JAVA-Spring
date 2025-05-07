package com.aicija.repositories;

import com.aicija.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

  // spring boot implementa metodos basicos
  // findAll(), findById(), save(), delete(), etc..



  }