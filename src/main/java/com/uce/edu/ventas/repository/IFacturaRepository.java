package com.uce.edu.ventas.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.repository.modelo.FacturaDTO;

public interface IFacturaRepository {
	public Factura seleccionarPorNumero (String numero);
	public Factura seleccionar(Integer id);
	public void insertar (Factura factura);
	public void actualizar (Factura factura);
	public int actulizarFechas(LocalDateTime fechaNueva, LocalDateTime fechaActual);
	public void eliminar (Integer id);
	public int eliminarPorNumero(String numero);
	public List<Factura> seleccionarInnerJoin();
	public List<Factura> seleccionarFacturasRightJoin();
	public List<Factura> seleccionarFacturasLeftJoin();
	public List<Factura> seleccionarFacturasFullJoin();
	public List<Factura> seleccionarFacturasWhereJoin();
	public List<Factura> seleccionarFacturasFetchJoin();
	public List<FacturaDTO> seleccionarFacturasDTO();
	public List<Factura> seleccionarTodos();

}
