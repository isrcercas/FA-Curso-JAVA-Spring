package com.aicija;

import com.aicija.entities.Categoria;
import com.aicija.entities.Producto;
import com.aicija.repositories.CategoriaRepository;
import com.aicija.repositories.ProductoRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.util.List;

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
		CategoriaRepository categoriaRepository = spring.getBean(CategoriaRepository.class);

		// Creamos las categorias
		Categoria frutas = new Categoria("Frutas", "Productos que vienen del arbol");
		Categoria lacteos = new Categoria("Lacteos", "Productos que vienen del animal");
		Categoria cereales = new Categoria("Cereales", "Productos que vienen del cereal");

		categoriaRepository.saveAll(List.of(frutas,lacteos,cereales));

		// crear productos en el main NO bbdd

		Producto manzana = new Producto("manzana", 1.555, 100, true, frutas);
		Producto yogurt = new Producto("yogurt", 2.5458, 10, true, lacteos);
		Producto avena = new Producto("avena", 8.548, 5, true, null);
		Producto macarrones = new Producto("macarrones", 8.5, 1, false, cereales);
		// guardar productos
		productoRepository.save(manzana);
		productoRepository.save(yogurt);
		productoRepository.save(avena);
		productoRepository.save(macarrones);

		System.out.println("Producto guardados: " + productoRepository.findAll());
		System.out.println("Otro metodo stock: " + productoRepository.count());
		System.out.println("Otro metodo stock: " + productoRepository.countByStock(10));

		// Forma para usar findByNombreIgnoreCase
		String nombreBuscado = "macarrones";
		Producto productoEncontrado = productoRepository.findByNombreIgnoreCase(nombreBuscado);

		if(productoEncontrado !=null){
			System.out.println("Producto encontrado por nombre: '" + nombreBuscado + "'. ");
		}else{
			System.out.println("Producto " + nombreBuscado + " no encontrado.");
		}

		// Probar List<Producto>findByPrecioLessThan(Double precio)

		Double precioMaximo = 3.00;
		List<Producto> productosBaratos = productoRepository.findByPrecioLessThan(precioMaximo);
		System.out.println("Productos con el precio menor que " + precioMaximo + "€:");
		for (Producto producto : productosBaratos){
			System.out.println("\t " + producto.getNombre() + " : " + producto.getPrecio() + "€");
		}

		// probar boolean existsByNombreIgnoreCase(String nombre)
		String nombreExistente = "yogurt";
		boolean existeProducto = productoRepository.existsByNombreIgnoreCase(nombreExistente);
		System.out.println("¿Existe el producto llamado '" + nombreExistente + "' ? "
				// aplicando el operador ternario
				+ (existeProducto? "si" : "no"));
		String nombreNoExistente = "pera";
		boolean noExisteProducto = productoRepository.existsByNombreIgnoreCase(nombreNoExistente);
		System.out.println("¿Exite un producto llamado " + nombreNoExistente + "'? "
				// aplicando el operador ternario
		+ (noExisteProducto? "si" : "no"));

		// probar Stock
		String stockBuscar = "100";



		// probar consulta query
		// igual que los metodos derivados
		// List<Producto> findByPrecioBetween

		Double precioMin = 1.00;
		Double precioMax = 5.00;

		List<Producto> precioProducto = productoRepository.findByPrecioBetween(precioMin, precioMax);
		System.out.println("Productos con precio entre: " + precioMin + "€ y " + precioMax + "€.");

		if(precioProducto.isEmpty()){
			System.out.println("No se han encontrado en este rango de precios");
		}else{
			for (Producto producto:precioProducto ){
				System.out.println("- Producto:" + producto.getNombre() + " : " + producto.getPrecio() + "€");
			}
			System.out.println("Total de productos en el rango: " + precioProducto.size());
		}
		String cateBusc = "Cereales";
		List<Producto> producCategori = productoRepository.findByCategoria_NombreIgnoreCase(cateBusc);

		if(producCategori.isEmpty()){
			System.out.println("No se ha encontrado nada de nada");
		}else{

			for(Producto listado: producCategori){
				System.out.println(" - " + listado.getNombre() + " (" + listado.getCategoria().getNombre() + ") " + listado.getPrecio() + "€. ");
			}
		}

		System.out.println("==================");
		System.out.println("Ahora esta activo los controllers");
	}
}
