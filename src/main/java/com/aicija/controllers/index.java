package com.aicija.controllers;

import com.aicija.repositories.CategoriaRepository;
import com.aicija.repositories.ProductoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class index {

    /*
    private ProductoRepository productoRepository;
    private CategoriaRepository categoriaRepository;

    public index(ProductoRepository productoRepository){
        this.productoRepository = productoRepository;
    }
    public index(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }
    */

    // devuelve el nombre de la vista
    @GetMapping("/")
    public String informacion(Model model) {

        return "index";
    }

}

