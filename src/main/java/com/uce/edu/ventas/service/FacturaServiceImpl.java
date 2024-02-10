package com.uce.edu.ventas.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.ventas.repository.IFacturaRepository;
import com.uce.edu.ventas.repository.modelo.Cliente;
import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.repository.modelo.FacturaDTO;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;
@Service
public class FacturaServiceImpl implements IFacturaService {

	@Autowired
	private IFacturaRepository facturaRepository;
	
	@Autowired
	private IClienteService clienteService;
	
	@Override
	public Factura buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.facturaRepository.seleccionarPorNumero(numero);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void guardar(Factura factura, Cliente cliente) {
		// TODO Auto-generated method stub
		BigDecimal valor = new BigDecimal(100);
		valor = valor.multiply(new BigDecimal(0.12));
		factura.setValorIVA(valor);
		
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive()); 
		this.facturaRepository.insertar(factura);
		System.out.println("PAso el insert de factura");
		this.clienteService.guardar(cliente);
		System.out.println("PAso el insert de cliente");
	}

	@Override
	public List<Factura> buscarInnerJoin() {
		// TODO Auto-generated method stub
		return this.facturaRepository.seleccionarInnerJoin();
	}

	@Override
	public List<Factura> buscarFacturasRightJoin() {
		// TODO Auto-generated method stub
		return this.facturaRepository.seleccionarFacturasRightJoin();
	}

	@Override
	public List<Factura> buscarFacturasLeftJoin() {
		// TODO Auto-generated method stub
		return this.facturaRepository.seleccionarFacturasLeftJoin();
	}

	@Override
	public List<Factura> buscarFacturasFullJoin() {
		// TODO Auto-generated method stub
		return this.facturaRepository.seleccionarFacturasFullJoin();
	}

	@Override
	public List<Factura> buscarFacturasWhereJoin() {
		// TODO Auto-generated method stub
		return this.facturaRepository.seleccionarFacturasWhereJoin();
	}

	@Override
	public List<Factura> buscarFacturasFetchJoin() {
		// TODO Auto-generated method stub
		return this.facturaRepository.seleccionarFacturasFetchJoin();
	}

	@Override
	public void actualizar(Factura factura) {
		// TODO Auto-generated method stub
		this.facturaRepository.actualizar(factura);
	}

	@Override
	public int actulizarFechas(LocalDateTime fechaNueva, LocalDateTime fechaActual) {
		// TODO Auto-generated method stub
		return this.facturaRepository.actulizarFechas(fechaNueva, fechaActual);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.facturaRepository.eliminar(id);
	}

	@Override
	public int borrarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.facturaRepository.eliminarPorNumero(numero);
	}

	@Override
	public List<FacturaDTO> buscarFacturasDTO() {
		// TODO Auto-generated method stub
		return this.facturaRepository.seleccionarFacturasDTO();
	}

	@Override
	//@Transactional(value = TxType.MANDATORY)
	public void prueba() {
		// TODO Auto-generated method stub
		System.out.println("Este metodo es de prueba");
		System.out.println("Prueba: " + TransactionSynchronizationManager.isActualTransactionActive());
	}

	@Override
	public void pruebaSupports() {
		// TODO Auto-generated method stub
		System.out.println("Prueba factura: " + TransactionSynchronizationManager.isActualTransactionActive());
		this.clienteService.pruebaSupports();

	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void pruebaNever() {
		// TODO Auto-generated method stub
		System.out.println("Prueba Factura: " + TransactionSynchronizationManager.isActualTransactionActive());
		this.clienteService.pruebaNEver();
	}

}
