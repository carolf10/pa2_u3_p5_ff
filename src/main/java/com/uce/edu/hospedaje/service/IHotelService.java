package com.uce.edu.hospedaje.service;

import java.util.List;

import com.uce.edu.hospedaje.repository.modelo.Hotel;

public interface IHotelService {
	public void guardar(Hotel hotel);
	public List<Hotel>  buscarPorClase(String clase);
	public List<Hotel>  buscarPorNumero(String direccion);
}
