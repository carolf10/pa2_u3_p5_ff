package com.uce.edu.hospedaje.repository;

import java.util.List;

import com.uce.edu.hospedaje.repository.modelo.Hotel;

public interface IHotelRepository {
	public void insertar(Hotel hotel);
	public List<Hotel> seleccionarPorClase(String clase);
	public List<Hotel>  seleccionarPorNumero(String numero);
}
