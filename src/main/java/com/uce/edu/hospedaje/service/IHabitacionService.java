package com.uce.edu.hospedaje.service;

import java.util.List;

import com.uce.edu.hospedaje.repository.modelo.Habitacion;

public interface IHabitacionService {
	public List<Habitacion> buscarPorNombre(String nombre);
	public List<Habitacion> buscarPorDireccion(String direccion);
	public void guardar (Habitacion habitacion);

}
