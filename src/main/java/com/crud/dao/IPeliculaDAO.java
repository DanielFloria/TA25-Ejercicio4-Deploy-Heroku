package com.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.dto.Pelicula;

public interface IPeliculaDAO extends JpaRepository<Pelicula, Long>{

}
