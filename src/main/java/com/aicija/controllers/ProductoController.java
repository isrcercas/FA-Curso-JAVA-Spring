package com.aicija.controllers;

import com.aicija.entities.Producto;
import com.aicija.repositories.CategoriaRepository;
import com.aicija.repositories.ProductoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductoController {

    private ProductoRepository productoRepository;
    private CategoriaRepository categoriaRepository;

    public ProductoController(ProductoRepository productoRepository,
                              CategoriaRepository categoriaRepository){
        this.productoRepository = productoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    // anotacion que mapea las peticiones GET a la URL "productos"
    // lo que pone en la barra de direccion
    @GetMapping("/productos")
    public String findAll(Model model) {

        // esta correcto, pero no se aplica el principio de responsabilidad unica
        // model.addAttribute("productos", productoRepository.findAll());
        List<Producto> productos = productoRepository.findAll();
        model.addAttribute("productos", productos);

        // nos lleva al html
        return "producto-list";
    }
    // esta url sera dinamica, para que traiga el id del producto.
    // El PathVariable extrae el id.
    @GetMapping("/productos/{id}")
    public String findById(Model model, @PathVariable Long id){
        // es objeto envoltorio igual que List
        Optional<Producto> productoOpt = productoRepository.findById(id);

        if(productoOpt.isPresent()){
            model.addAttribute("producto", productoOpt.get());
        }else{
            model.addAttribute("error", "404 Producto no encontrado");
        }

        return "product-detail";
    }
    // Metodo para crear producto muestra
    @GetMapping("/productos/nuevo")
    public String createProducto(Model model){

        model.addAttribute("producto", new Producto());
        model.addAttribute("categorias", categoriaRepository.findAll());
        return "producto-form";
    }

    @PostMapping("/productos")
    public String saveForm(@ModelAttribute Producto producto){
        productoRepository.save(producto);
        return "redirect:/productos";
    }

    @GetMapping("/productos/{id}/editar")
    public String updateProducto(Model model, @PathVariable Long id){

        // es objeto envoltorio igual que List
        Optional<Producto> productoOpt = productoRepository.findById(id);

        if(productoOpt.isPresent()){
            model.addAttribute("producto", productoOpt.get());
            model.addAttribute("categorias", categoriaRepository.findAll());
        }else{
            model.addAttribute("error", "Producto no encontrado");
        }

        return "producto-form";
    }


}
