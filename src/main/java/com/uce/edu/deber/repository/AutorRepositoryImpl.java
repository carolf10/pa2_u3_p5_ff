package com.uce.edu.deber.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.deber.repository.modelo.Autor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class AutorRepositoryImpl implements IAutorRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Autor autor) {
		// TODO Auto-generated method stub
		this.entityManager.persist(autor);
	}

	@Override
	public List<Autor> seleccionarPorTitulo(String titulo) {
		// TODO Auto-generated method stub
		TypedQuery<Autor> query = this.entityManager.createQuery("SELECT a FROM Autor a FULL JOIN a.libros l WHERE l.titulo = :titulo",
				Autor.class);
		query.setParameter("titulo", titulo);
		List<Autor> lista = query.getResultList();
		return lista;
	}

	@Override
	public List<Autor> seleccionarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		TypedQuery<Autor> query = this.entityManager.createQuery("SELECT a FROM Autor a JOIN FETCH a.libros l WHERE l.codigo = :codigo",
				Autor.class);
		query.setParameter("codigo", codigo);
		List<Autor> lista = query.getResultList();
		return lista;
	}

}
