package com.uce.edu.ventas.service;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.ventas.repository.modelo.Cliente;
import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.repository.modelo.FacturaDTO;

public interface IFacturaService {
	public Factura buscarPorNumero (String numero);
	public void guardar (Factura factura, Cliente cliente);
	public void actualizar (Factura factura);
	public int actulizarFechas(LocalDateTime fechaNueva, LocalDateTime fechaActual);
	public void borrar (Integer id);
	public int borrarPorNumero(String numero);
	public List<Factura> buscarInnerJoin();
	public List<Factura> buscarFacturasRightJoin();
	public List<Factura> buscarFacturasLeftJoin();
	public List<Factura> buscarFacturasFullJoin();
	public List<Factura> buscarFacturasWhereJoin();
	public List<Factura> buscarFacturasFetchJoin();
	public List<FacturaDTO> buscarFacturasDTO();
	
}
