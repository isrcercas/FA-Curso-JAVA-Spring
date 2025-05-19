package com.aicija.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// clase controlador MVC, maneja peticions HTTP
@Controller
public class HelloController {

    @GetMapping("hola")
    public String saludar(){
        return "hello"; // nombre archivo html (hello.html)
    }

    // devuelve el nombre de la vista
    @GetMapping("info")
    public String informacion(Model model){
        // podemos añadir datos al modelo
        model.addAttribute("desarrollador", "IsrCerCas");
        model.addAttribute("fecha", "19-05-2025");
        model.addAttribute("version", "1.0");

        return "info";
    }


}
