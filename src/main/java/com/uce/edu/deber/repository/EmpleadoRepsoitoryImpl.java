package com.uce.edu.deber.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.deber.repository.modelo.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class EmpleadoRepsoitoryImpl implements IEmpleadoRepository{
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insetar(Empleado empleado) {
		// TODO Auto-generated method stub
		this.entityManager.persist(empleado);
	}

	@Override
	public List<Empleado> seleccionarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Empleado> query = this.entityManager.createQuery("SELECT e FROM Empleado e JOIN e.ciudadano c WHERE c.cedula = :cedula",
				Empleado.class);
		query.setParameter("cedula", cedula);
		List<Empleado> lista = query.getResultList();
		return lista;
	}

	@Override
	public List<Empleado> seleccionarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		TypedQuery<Empleado> query = this.entityManager.createQuery("SELECT e FROM Empleado e LEFT JOIN e.ciudadano c WHERE c.nombre = :nombre",
				Empleado.class);
		query.setParameter("nombre", nombre);
		List<Empleado> lista = query.getResultList();
		return lista;
	}

}
