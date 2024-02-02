package com.uce.edu.deber.service;

import java.util.List;

import com.uce.edu.deber.repository.modelo.Empleado;

public interface IEmpleadoService {

	public void guardar (Empleado empleado);
	public List<Empleado> buscarPorCedula(String cedula);
	public List<Empleado> buscarPorNombre(String nombre);
}
