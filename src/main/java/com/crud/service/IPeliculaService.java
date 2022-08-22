package com.crud.service;

import java.util.List;

import com.crud.dto.Pelicula;

public interface IPeliculaService {
	public Pelicula guardarPelicula(Pelicula pelicula);
	
	public List<Pelicula> listarPeliculas();
	
	public Pelicula peliculaPorId(Long codigo);
	
	public Pelicula actualizarPelicula(Pelicula pelicula);
	
	public void borrarPelicula(Long codigo);
}
