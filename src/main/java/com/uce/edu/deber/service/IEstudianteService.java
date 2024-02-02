package com.uce.edu.deber.service;

import java.util.List;

import com.uce.edu.deber.repository.modelo.Estudiante;

public interface IEstudianteService {
	public void guardar (Estudiante estudiante);
	public List<Estudiante> buscarPorCodigo(String codigo);
	public List<Estudiante> buscarPorNombre(String nombre);

}
