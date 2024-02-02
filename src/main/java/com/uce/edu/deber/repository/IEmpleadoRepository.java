package com.uce.edu.deber.repository;

import java.util.List;

import com.uce.edu.deber.repository.modelo.Empleado;

public interface IEmpleadoRepository {
	public void insetar (Empleado empleado);
	public List<Empleado> seleccionarPorCedula(String cedula);
	public List<Empleado> seleccionarPorNombre(String nombre);
}
