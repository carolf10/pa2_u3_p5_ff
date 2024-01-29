package com.uce.edu.hospedaje.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.hospedaje.repository.modelo.Habitacion;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HabitacionRepositoryImpl implements IHabitacionRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Habitacion habitacion) {
		// TODO Auto-generated method stub
		this.entityManager.persist(habitacion);
	}

	@Override
	public List<Habitacion> seleccionarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		TypedQuery<Habitacion> query = this.entityManager.createQuery("SELECT hs FROM Habitacion hs RIGHT JOIN hs.hotel h WHERE h.nombre = :nombre",
				Habitacion.class);
		query.setParameter("nombre", nombre);
		return query.getResultList();
	}

	@Override
	public List<Habitacion> seleccionarPorDireccion(String direccion) {
		// TODO Auto-generated method stub
		TypedQuery<Habitacion> query = this.entityManager.createQuery("SELECT hs FROM Habitacion hs RIGHT JOIN hs.hotel h WHERE h.direccion = :direccion",
				Habitacion.class);
		query.setParameter("direccion", direccion);
		return query.getResultList();
	}

}
