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

import com.crud.dto.Sala;
import com.crud.service.SalaServiceImpl;

@RestController
@RequestMapping("/api")
public class SalaController {
	
	@Autowired
	SalaServiceImpl salaServiceImpl;
	
	@PostMapping("/salas")
	public Sala guardarSala(@RequestBody Sala sala) {
		return salaServiceImpl.guardarSala(sala);
	}
	
	@GetMapping("/salas")
	public List<Sala> listarSalas() {
		return salaServiceImpl.listarSalas();
	}
	
	@GetMapping("/salas/{id}")
	public Sala salaPorId(@PathVariable(name="codigo") Long id) {
		Sala salaPorId = new Sala();
		salaPorId = salaServiceImpl.salaPorId(id);
		
		return salaPorId;
	}	
	
	@PutMapping("/salas/{id}")
	public Sala actualizarSala(@PathVariable(name="codigo") Long id, @RequestBody Sala sala) {
		Sala salaSeleccionado = new Sala();
		Sala salaActualizado = new Sala();
		
		salaSeleccionado = salaServiceImpl.salaPorId(id);
		
		salaSeleccionado.setNombre(sala.getNombre());
		salaSeleccionado.setPelicula(sala.getPelicula());
		
		salaActualizado = salaServiceImpl.actualizarSala(salaSeleccionado);
		
		return salaActualizado;
	}
	
	@DeleteMapping("/salas/{id}")
	public void borrarSala(@PathVariable(name="codigo") Long id) {
		salaServiceImpl.borrarSala(id);
	}

}
