package com.uce.edu.deber.repository;

import java.util.List;

import com.uce.edu.deber.repository.modelo.Autor;

public interface IAutorRepository {
	public void insertar (Autor autor);
	public List<Autor> seleccionarPorTitulo(String titulo);
	public List<Autor> seleccionarPorCodigo(String codigo);
}
