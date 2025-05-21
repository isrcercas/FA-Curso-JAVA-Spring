package com.aicija.controllers;

import com.aicija.entities.Categoria;
import com.aicija.repositories.CategoriaRepository;
import com.aicija.repositories.ProductoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CategoriaController {

    // Traemos el repository de Categoria
    private CategoriaRepository categoriaRepository;

    public CategoriaController(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }


    @GetMapping("categorias")
    public String findAll(Model model){

        List<Categoria> categorias = categoriaRepository.findAll();
        model.addAttribute("categorias", categorias);

        return "categorias";
    }

}
