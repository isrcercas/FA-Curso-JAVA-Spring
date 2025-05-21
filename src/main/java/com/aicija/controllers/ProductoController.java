package com.aicija.controllers;

import com.aicija.entities.Producto;
import com.aicija.repositories.ProductoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductoController {

    private ProductoRepository productoRepository;

    public ProductoController(ProductoRepository productoRepository){
        this.productoRepository = productoRepository;
    }

    // anotacion que mapea las peticiones GET a la URL "productos"
    @GetMapping("productos")
    public String findAll(Model model) {

        // esta correcto, pero no se aplica el principio de responsabilidad unica
        // model.addAttribute("productos", productoRepository.findAll());
        List<Producto> productos = productoRepository.findAll();
        model.addAttribute("productos", productos);
        return "productos";
    }
    // esta url sera dinamica, para que traiga el id del producto.
    // El PathVariable extrae el id.
    @GetMapping("productos/{id}")
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

}
