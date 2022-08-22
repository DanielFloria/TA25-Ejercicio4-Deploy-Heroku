package com.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.dao.IPeliculaDAO;
import com.crud.dto.Pelicula;

@Service
public class PeliculaServiceImpl implements IPeliculaService {

	@Autowired
	IPeliculaDAO iPeliculaDAO;
	
	@Override
	public Pelicula guardarPelicula(Pelicula pelicula) {
		return iPeliculaDAO.save(pelicula);
	}

	@Override
	public List<Pelicula> listarPeliculas() {
		return iPeliculaDAO.findAll();
	}

	@Override
	public Pelicula peliculaPorId(Long codigo) {
		return iPeliculaDAO.findById(codigo).get();
	}

	@Override
	public Pelicula actualizarPelicula(Pelicula pelicula) {
		return iPeliculaDAO.save(pelicula);
	}

	@Override
	public void borrarPelicula(Long codigo) {
		iPeliculaDAO.deleteById(codigo);
	}

}
