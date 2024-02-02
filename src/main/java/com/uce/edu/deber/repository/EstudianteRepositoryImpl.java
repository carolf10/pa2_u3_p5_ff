package com.uce.edu.deber.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uce.edu.deber.repository.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class EstudianteRepositoryImpl implements IEstudianteRepository {
	@Autowired 
	private EntityManager entityManager;

	@Override
	public void insertar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.persist(estudiante);
	}

	@Override
	public List<Estudiante> seleccionarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> query = this.entityManager.createQuery("SELECT e FROM Estudiante e RIGHT JOIN e.materia m WHERE m.codigo = :codigo",
				Estudiante.class);
		query.setParameter("codigo", codigo);
		List<Estudiante> lista = query.getResultList();
		for(Estudiante estudiante: lista) {
			estudiante.getMateria().size();
		}
		return lista;
	}

	@Override
	public List<Estudiante> seleccionarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> query = this.entityManager.createQuery("SELECT e FROM Estudiante e JOIN FETCH e.materia m WHERE m.nombre = :nombre",
				Estudiante.class);
		query.setParameter("nombre", nombre);
		List<Estudiante> lista = query.getResultList();
		return lista;
	}

}
