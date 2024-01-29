package com.uce.edu.hospedaje.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.hospedaje.repository.modelo.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class HotelRepositoryImpl implements IHotelRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.entityManager.persist(hotel);
	}

	@Override
	public List<Hotel> seleccionarPorClase(String clase) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> query = this.entityManager.createQuery("SELECT h FROM Hotel h JOIN h.habitaciones hs WHERE hs.clase = :clase",
				Hotel.class);
		query.setParameter("clase", clase);
		List<Hotel> lista = query.getResultList();
		for (Hotel h : lista) {
			h.getHabitaciones().size();
		}
		return lista;
	}

	@Override
	public List<Hotel> seleccionarPorNumero(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> query = this.entityManager.createQuery("SELECT h FROM Hotel h LEFT JOIN h.habitaciones hs WHERE hs.numero = :numero",
				Hotel.class);
		query.setParameter("numero", numero);
		List<Hotel> lista = query.getResultList();
		for (Hotel h : lista) {
			h.getHabitaciones().size();
		}
		return lista;
	}

	

}
