package com.uce.edu.deber.repository;

import java.util.List;

import com.uce.edu.deber.repository.modelo.Ciudadano;

public interface ICiudadanoRepository {
	public void insertar (Ciudadano ciudadano);
	public List<Ciudadano> seleccionarPorCodigo(String codigo);
	public List<Ciudadano> seleccionarPorDireccion(String direccion);
}
