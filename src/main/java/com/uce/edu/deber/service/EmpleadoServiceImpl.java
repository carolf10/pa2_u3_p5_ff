package com.uce.edu.deber.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.deber.repository.IEmpleadoRepository;
import com.uce.edu.deber.repository.modelo.Empleado;
@Service
public class EmpleadoServiceImpl implements IEmpleadoService {
	@Autowired
	private IEmpleadoRepository empleadoRepository;

	@Override
	public void guardar(Empleado empleado) {
		// TODO Auto-generated method stub
		this.empleadoRepository.insetar(empleado);
	}

	@Override
	public List<Empleado> buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.empleadoRepository.seleccionarPorCedula(cedula);
	}

	@Override
	public List<Empleado> buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return this.empleadoRepository.seleccionarPorNombre(nombre);
	}


}
