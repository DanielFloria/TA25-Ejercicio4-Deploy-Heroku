package com.crud.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="peliculas")
public class Pelicula {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "calificacion_edad")
	private int calificacion_edad;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pelicula")
	private List<Sala> salas;
	
	// Constructores
	public Pelicula() {

	}

	public Pelicula(Long codigo, String nombre, int calificacion_edad) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.calificacion_edad = calificacion_edad;
	}

	// Getters & setters
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCalificacionEdad() {
		return calificacion_edad;
	}

	public void setCalificacionEdad(int calificacion_edad) {
		this.calificacion_edad = calificacion_edad;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Sala")
	public List<Sala> getSalas() {
		return salas;
	}

	public void setSalas(List<Sala> salas) {
		this.salas = salas;
	}

	@Override
	public String toString() {
		return "Pelicula [codigo=" + codigo + ", nombre=" + nombre + ", calificacion_edad=" + calificacion_edad + "]";
	}
}
