package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.dto.Pelicula;
import com.crud.service.PeliculaServiceImpl;

@RestController
@RequestMapping("/api")
public class PeliculaController {
	
	@Autowired
	PeliculaServiceImpl peliculaServiceImpl;
	
	@PostMapping("/peliculas")
	public Pelicula guardarPelicula(@RequestBody Pelicula pelicula) {
		return peliculaServiceImpl.guardarPelicula(pelicula);
	}
	
	@GetMapping("/peliculas")
	public List<Pelicula> listarPeliculas() {
		return peliculaServiceImpl.listarPeliculas();
	}
	
	@GetMapping("/peliculas/{codigo}")
	public Pelicula peliculaPorId(@PathVariable(name="codigo") Long id) {
		Pelicula peliculaPorId = new Pelicula();
		peliculaPorId = peliculaServiceImpl.peliculaPorId(id);
		
		System.out.println("Pelicula por id: " + peliculaPorId);
		
		return peliculaPorId;
	}	
	
	@PutMapping("/peliculas/{codigo}")
	public Pelicula actualizarPelicula(@PathVariable(name="codigo") Long id, @RequestBody Pelicula pelicula) {
		Pelicula peliculaSeleccionado = new Pelicula();
		Pelicula peliculaActualizado = new Pelicula();
		
		peliculaSeleccionado = peliculaServiceImpl.peliculaPorId(id);
		
		peliculaSeleccionado.setNombre(pelicula.getNombre());
		peliculaSeleccionado.setCalificacionEdad(pelicula.getCalificacionEdad());
		
		peliculaActualizado = peliculaServiceImpl.actualizarPelicula(peliculaSeleccionado);
		
		return peliculaActualizado;
	}
	
	@DeleteMapping("/peliculas/{codigo}")
	public void borrarPelicula(@PathVariable(name="codigo") Long id) {
		peliculaServiceImpl.borrarPelicula(id);
	}
}

