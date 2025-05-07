package com.aicija;

import com.aicija.entities.Producto;
import com.aicija.repositories.ProductoRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Main {

	public static void main(String[] args)
	{
		// Inicializando spring que es una fabrica de objetos
		ApplicationContext spring = SpringApplication.run(Main.class, args);

		// un objeto que crea spring es un objeto bean
		// sacamos el repositorio (lo crea spring)
		// creame un objeto de la clase productorepository
		ProductoRepository productoRepository = spring.getBean(ProductoRepository.class);

		// crear productos en el main NO bbdd
		Producto manzana = new Producto("manzana", 1.5, 100, true);
		Producto yogurt = new Producto("yogurt", 3.5, 10, true);
		Producto avena = new Producto("avena", 8.5, 5, true);
		Producto macarrones = new Producto("macarrones", 8.5, 5, true);
		// guardar productos
		productoRepository.save(manzana);
		productoRepository.save(yogurt);
		productoRepository.save(avena);
		productoRepository.save(macarrones);
	}

}
