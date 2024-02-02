package com.uce.edu.deber.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.deber.repository.modelo.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class LibroRepositoryImpl implements ILibroRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Libro libro) {
		// TODO Auto-generated method stub
		this.entityManager.persist(libro);
	}

	@Override
	public List<Libro> seleccionarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		TypedQuery<Libro> query = this.entityManager.createQuery("SELECT l FROM Libro l JOIN l.autores a WHERE a.nombre = :nombre",
				Libro.class);
		query.setParameter("nombre", nombre);
		List<Libro> lista = query.getResultList();
		for(Libro libro: lista) {
			libro.getAutores().size();
		}
		return lista;
	}

	@Override
	public List<Libro> seleccionarPorNacionalidad(String nacionalidad) {
		// TODO Auto-generated method stub
		TypedQuery<Libro> query = this.entityManager.createQuery("SELECT l FROM Libro l LEFT JOIN l.autores a WHERE a.nacionalidad = :nacionalidad",
				Libro.class);
		query.setParameter("nacionalidad", nacionalidad);
		List<Libro> lista = query.getResultList();
		for(Libro libro: lista) {
			libro.getAutores().size();
		}
		return lista;
	}

}
