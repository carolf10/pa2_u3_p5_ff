package com.uce.edu.deber.service;

import java.util.List;

import com.uce.edu.deber.repository.modelo.Libro;

public interface ILibroService {
	public void guardar(Libro libro);
	public List<Libro> buscarPorNombre(String nombre);
	public List<Libro> buscarPorNacionalidad(String nacionalidad);
}
