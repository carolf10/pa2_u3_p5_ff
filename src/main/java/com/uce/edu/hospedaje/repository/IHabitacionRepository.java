package com.uce.edu.hospedaje.repository;

import java.util.List;

import com.uce.edu.hospedaje.repository.modelo.Habitacion;

public interface IHabitacionRepository {
	public List<Habitacion> seleccionarPorNombre(String nombre);
	public List<Habitacion> seleccionarPorDireccion(String direccion);
	public void insertar (Habitacion habitacion);

}
