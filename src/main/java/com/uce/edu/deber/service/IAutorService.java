package com.uce.edu.deber.service;

import java.util.List;

import com.uce.edu.deber.repository.modelo.Autor;

public interface IAutorService {
	public void guardar (Autor autor);
	public List<Autor> buscarPorTitulo(String titulo);
	public List<Autor> buscarPorCodigo(String codigo);

}
