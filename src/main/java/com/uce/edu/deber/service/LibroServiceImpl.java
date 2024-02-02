package com.uce.edu.deber.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.deber.repository.ILibroRepository;
import com.uce.edu.deber.repository.modelo.Libro;
@Service
public class LibroServiceImpl implements ILibroService {
	@Autowired
	private ILibroRepository libroRepository;

	@Override
	public void guardar(Libro libro) {
		// TODO Auto-generated method stub
		this.libroRepository.insertar(libro);
	}

	@Override
	public List<Libro> buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return this.libroRepository.seleccionarPorNombre(nombre);
	}

	@Override
	public List<Libro> buscarPorNacionalidad(String nacionalidad) {
		// TODO Auto-generated method stub
		return this.libroRepository.seleccionarPorNacionalidad(nacionalidad);
	}

}
