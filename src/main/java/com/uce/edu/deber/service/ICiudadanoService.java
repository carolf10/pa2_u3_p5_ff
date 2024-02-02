package com.uce.edu.deber.service;

import java.util.List;

import com.uce.edu.deber.repository.modelo.Ciudadano;

public interface ICiudadanoService {
	public void guardar (Ciudadano ciudadano);
	public List<Ciudadano> buscarPorCodigo(String codigo);
	public List<Ciudadano> buscarPorDireccion(String direccion);

}
