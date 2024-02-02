package com.uce.edu.deber.repository;

import java.util.List;

import com.uce.edu.deber.repository.modelo.Estudiante;

public interface IEstudianteRepository {
	public void insertar (Estudiante estudiante);
	public List<Estudiante> seleccionarPorCodigo(String codigo);
	public List<Estudiante> seleccionarPorNombre(String nombre);

}
