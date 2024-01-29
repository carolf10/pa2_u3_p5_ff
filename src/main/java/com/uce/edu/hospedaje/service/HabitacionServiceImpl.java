package com.uce.edu.hospedaje.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.hospedaje.repository.IHabitacionRepository;
import com.uce.edu.hospedaje.repository.modelo.Habitacion;
@Service
public class HabitacionServiceImpl implements IHabitacionService {
	@Autowired
	private IHabitacionRepository habitacionRepository;

	@Override
	public void guardar(Habitacion habitacion) {
		// TODO Auto-generated method stub
		this.habitacionRepository.insertar(habitacion);
	}

	@Override
	public List<Habitacion> buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return this.habitacionRepository.seleccionarPorNombre(nombre);
	}

	@Override
	public List<Habitacion> buscarPorDireccion(String direccion) {
		// TODO Auto-generated method stub
		return this.habitacionRepository.seleccionarPorDireccion(direccion);
	}
	

}
