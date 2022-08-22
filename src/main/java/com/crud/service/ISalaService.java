package com.crud.service;

import java.util.List;

import com.crud.dto.Sala;

public interface ISalaService {
	public Sala guardarSala(Sala sala);
	
	public List<Sala> listarSalas();
	
	public Sala salaPorId(Long codigo);
	
	public Sala actualizarSala(Sala sala);
	
	public void borrarSala(Long codigo);
}
