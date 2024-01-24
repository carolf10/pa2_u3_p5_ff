package com.uce.edu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.ventas.repository.modelo.DetalleFactura;
import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.service.IFacturaService;

@SpringBootApplication
public class Pa2U3P5FfApplication implements CommandLineRunner{
	@Autowired
	private IFacturaService facturaService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5FfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*Factura factura = new Factura();
		factura.setCedula("456456");
		factura.setFecha(LocalDateTime.now());
		factura.setNumero("0001-02569");
		
		DetalleFactura defa1 = new DetalleFactura();
		defa1.setCantidad(4);
		defa1.setCodigoBarras("54556875");
		defa1.setNombreProducto("Coca Cola");
		defa1.setFactura(factura);
		
		DetalleFactura defa2 = new DetalleFactura();
		defa2.setCantidad(2);
		defa2.setCodigoBarras("456456");
		defa2.setNombreProducto("Lecha Vita");
		defa2.setFactura(factura);
		
		List<DetalleFactura> df = new ArrayList<>();
		df.add(defa1);
		df.add(defa2);
		
		factura.setDetallesFacturas(df);
		this.facturaService.guardar(factura);*/
		
		Factura factura=this.facturaService.buscarPorNumero("0001-02569");
		for(DetalleFactura det : factura.getDetallesFacturas()) {
			System.out.println(det);
		}
		System.out.println(factura);
	}

}
