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


    @GetMapping("/categorias")
    public String findAll(Model model){

        List<Categoria> categorias = categoriaRepository.findAll();
        model.addAttribute("categorias", categorias);

        return "categoria-list";
    }

    @GetMapping("/categorias/nuevo")
    public String createCategoria(Model model){
        model.addAttribute("categorias", categoriaRepository);

        return "categoria-form";
    }
   // @GetMapping
    //public String createC

    /*
    * // Metodo para crear producto muestra
    @GetMapping("/productos/nuevo")
    public String createForm(Model model){

        model.addAttribute("producto", new Producto());
        model.addAttribute("categorias", categoriaRepository.findAll());
        return "producto-form";
    }

    @PostMapping("/productos")
    public String saveForm(@ModelAttribute Producto producto){
        productoRepository.save(producto);

        return "redirect:/productos";

    }
    * */

}
