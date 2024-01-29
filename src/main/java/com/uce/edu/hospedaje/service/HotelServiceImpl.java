package com.uce.edu.hospedaje.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.hospedaje.repository.IHotelRepository;
import com.uce.edu.hospedaje.repository.modelo.Hotel;
@Service
public class HotelServiceImpl implements IHotelService {
	@Autowired
	private IHotelRepository hotelRepository;

	@Override
	public void guardar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.hotelRepository.insertar(hotel);
	}

	@Override
	public List<Hotel> buscarPorClase(String clase) {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarPorClase(clase);
	}

	@Override
	public List<Hotel> buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarPorNumero(numero);
	}

	

}
