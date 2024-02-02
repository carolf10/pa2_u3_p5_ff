package com.uce.edu.deber.repository;

import java.util.List;

import com.uce.edu.deber.repository.modelo.Libro;

public interface ILibroRepository {
	public void insertar(Libro libro);
	public List<Libro> seleccionarPorNombre(String nombre);
	public List<Libro> seleccionarPorNacionalidad(String nacionalidad);
}
