package com.uce.edu.deber.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.deber.repository.modelo.Ciudadano;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class CiudadanoRepositoryImpl implements ICiudadanoRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		this.entityManager.persist(ciudadano);
	}

	@Override
	public List<Ciudadano> seleccionarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		TypedQuery<Ciudadano> query = this.entityManager.createQuery("SELECT c FROM Ciudadano c RIGHT JOIN c.empleado e WHERE e.codigo = :codigo",
				Ciudadano.class);
		query.setParameter("codigo", codigo);
		List<Ciudadano> lista = query.getResultList();
		return lista;
	}

	@Override
	public List<Ciudadano> seleccionarPorDireccion(String direccion) {
		TypedQuery<Ciudadano> query = this.entityManager.createQuery("SELECT c FROM Ciudadano c FULL JOIN c.empleado e WHERE e.direccion = :direccion",
				Ciudadano.class);
		query.setParameter("direccion", direccion);
		List<Ciudadano> lista = query.getResultList();
		return lista;
	}


}
