package com.uce.edu.ventas.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.ventas.repository.modelo.Factura;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class FacturaRepositoryImpl implements IFacturaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Factura seleccionarPorNumero(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> query = this.entityManager.createQuery("SELECT f FROM Factura f WHERE f.numero = :numero",
				Factura.class);
		query.setParameter("numero", numero);
		Factura factura = query.getSingleResult();
		factura.getDetallesFacturas().size(); // Le digo que cargue el detalle bajo demanda
		return factura;
	}

	@Override
	public void insertar(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.persist(factura);
	}

	@Override
	public List<Factura> seleccionarInnerJoin() {
		// TODO Auto-generated method stub
		// SQL: SELECT * FROM factura f INNER JOIN detalle_factura d ON f.fact_id =
		// d.defa_id_factura
		// JPQL: SELECT f FROM Factura f INNER JOIN f.detallesFacturas d
		TypedQuery<Factura> query = this.entityManager.createQuery("SELECT f FROM Factura f JOIN f.detallesFacturas d",
				Factura.class);
		List<Factura> lista = query.getResultList();
		for (Factura f : lista) {
			f.getDetallesFacturas().size();
		}
		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturasRightJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> query = this.entityManager.createQuery("SELECT f FROM Factura f RIGHT JOIN f.detallesFacturas d",
				Factura.class);
		List<Factura> lista = query.getResultList();
		for (Factura f : lista) {
			f.getDetallesFacturas().size();
		}
		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturasLeftJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> query = this.entityManager.createQuery("SELECT f FROM Factura f LEFT JOIN f.detallesFacturas d",
				Factura.class);
		List<Factura> lista = query.getResultList();
		for (Factura f : lista) {
			f.getDetallesFacturas().size();
		}
		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturasFullJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> query = this.entityManager.createQuery("SELECT f FROM Factura f FULL JOIN f.detallesFacturas d",
				Factura.class);
		List<Factura> lista = query.getResultList();
		for (Factura f : lista) {
			f.getDetallesFacturas().size();
		}
		return lista;
	}

}
