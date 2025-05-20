package com.aicija.controllers;

import com.aicija.entities.Producto;
import com.aicija.repositories.ProductoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductoController {

    private ProductoRepository productoRepository;

    public ProductoController(ProductoRepository productoRepository){
        this.productoRepository = productoRepository;
    }

    // anotacion que mapea las peticiones GET a la URL "productos"
    @GetMapping("productos")
    public String findAll(Model model){

        // esta correcto, pero no se aplica el principio de responsabilidad unica
        // model.addAttribute("productos", productoRepository.findAll());
        List<Producto> productos = productoRepository.findAll();
        model.addAttribute("productos", productos);


        return "productos";

    }

}
