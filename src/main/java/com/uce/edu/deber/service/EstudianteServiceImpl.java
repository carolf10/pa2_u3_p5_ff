package com.uce.edu.deber.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.deber.repository.IEstudianteRepository;
import com.uce.edu.deber.repository.modelo.Estudiante;
@Service
public class EstudianteServiceImpl implements IEstudianteService {
	@Autowired
	private IEstudianteRepository estudianteRepository;

	@Override
	public void guardar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepository.insertar(estudiante);
	}

	@Override
	public List<Estudiante> buscarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.seleccionarPorNombre(codigo);
	}

	@Override
	public List<Estudiante> buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.seleccionarPorNombre(nombre);
	}

}
