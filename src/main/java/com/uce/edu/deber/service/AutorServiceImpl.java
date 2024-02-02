package com.uce.edu.deber.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.deber.repository.IAutorRepository;
import com.uce.edu.deber.repository.modelo.Autor;
@Service
public class AutorServiceImpl implements IAutorService {
	@Autowired
	private IAutorRepository autorRepository;

	@Override
	public void guardar(Autor autor) {
		// TODO Auto-generated method stub
		this.autorRepository.insertar(autor);
	}

	@Override
	public List<Autor> buscarPorTitulo(String titulo) {
		// TODO Auto-generated method stub
		return this.autorRepository.seleccionarPorTitulo(titulo);
	}

	@Override
	public List<Autor> buscarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		return this.autorRepository.seleccionarPorCodigo(codigo);
	}

}
