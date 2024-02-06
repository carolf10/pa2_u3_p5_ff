package com.uce.edu.ventas.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.repository.modelo.FacturaDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

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
	@Transactional(value = TxType.MANDATORY)
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
//		for (Factura f : lista) {
//			f.getDetallesFacturas().size();
//		}
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

	@Override
	public List<Factura> seleccionarFacturasWhereJoin() {
		// TODO Auto-generated method stub
		//SQL: SELECT f.* FROM factura f, detalle_factura d WHERE f.fact_id = d.defa_id_factura
		//JPQL: SELECT f FROM Factura f, DetalleFactura d WHERE f = d.factura
		TypedQuery<Factura> query = this.entityManager.createQuery("SELECT f FROM Factura f, DetalleFactura d WHERE f = d.factura",
				Factura.class);
		List<Factura> lista = query.getResultList();
		for (Factura f : lista) {
			f.getDetallesFacturas().size();
		}
		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturasFetchJoin() {
		// TODO Auto-generated method stub
		//JPQL: SELECT f FROM Factura f JOIN FETCH f.detallesFacturas d
		TypedQuery<Factura> query = this.entityManager.createQuery("SELECT f FROM Factura f JOIN FETCH f.detallesFacturas d",
				Factura.class);
		return query.getResultList();
	}

	@Override
	public void actualizar(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.merge(factura);
	}

	@Override
	public int actulizarFechas(LocalDateTime fechaNueva, LocalDateTime fechaActual) {
		// TODO Auto-generated method stub
		//SQL: UPDATE factura set fact_fecha = :fechaNueva WHERE fact_fecha >= fechaActual
		//JPQL: UPDATE Facturaf SET f.fecha = :fechaNueva WHERE f.fecha >= :fechaActual
		Query query=this.entityManager.createQuery("UPDATE Factura f SET f.fecha = :fechaNueva WHERE f.fecha >= :fechaActual");
		query.setParameter("fechaNueva", fechaNueva);
		query.setParameter("fechaActual", fechaActual);
		return query.executeUpdate(); //Cantidad de registros afectados/actualizados
		
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Factura factura = this.seleccionar(id);
		this.entityManager.remove(factura);
	}

	@Override
	public int eliminarPorNumero(String numero) {
		// TODO Auto-generated method stub
		//SQL: DELETE FROM factura WHERE fact_numero = numero
		//JPQL: DELETE FROM Factura f WHERE f.numero = :numero
		Query myQuery = this.entityManager.createQuery("DELETE FROM Factura f WHERE f.numero = :numero");
		myQuery.setParameter("numero", numero);
		return myQuery.executeUpdate();
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Factura seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Factura.class, id);
	}

	@Override
	public List<FacturaDTO> seleccionarFacturasDTO() {
		// TODO Auto-generated method stub
		TypedQuery<FacturaDTO> myQuery = this.entityManager.createQuery("SELECT NEW com.uce.edu.ventas.repository.modelo.FacturaDTO (f.numero, f.fecha) FROM Factura f", FacturaDTO.class);
		return myQuery.getResultList();
	}

}
