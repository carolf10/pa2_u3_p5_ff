package com.uce.edu.deber.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.deber.repository.ICiudadanoRepository;
import com.uce.edu.deber.repository.modelo.Ciudadano;
@Service
public class CiudadanoServiceImpl implements ICiudadanoService {
	@Autowired
	private ICiudadanoRepository ciudadanoRepository;

	@Override
	public void guardar(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		this.ciudadanoRepository.insertar(ciudadano);
	}

	@Override
	public List<Ciudadano> buscarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.seleccionarPorCodigo(codigo);
	}

	@Override
	public List<Ciudadano> buscarPorDireccion(String direccion) {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.seleccionarPorDireccion(direccion);
	}

	

}
