package com.uce.edu;

import java.util.List;

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
		System.out.println("INNER JOIN ----------------------------");
		List<Factura> list = this.facturaService.buscarInnerJoin();
		for(Factura f : list) {
			System.out.println(f.getNumero());
//			for(DetalleFactura df : f.getDetallesFacturas()) {
//				System.out.println(df.getNombreProducto());
//			}
		}
		
		System.out.println("WHERE JOIN ----------------------------");
		List<Factura> l1= this.facturaService.buscarFacturasWhereJoin();
		for(Factura f : l1) {
			System.out.println(f.getNumero());
			for(DetalleFactura df : f.getDetallesFacturas()) {
				System.out.println(df.getNombreProducto());
			}
		}
		
		System.out.println("FETCH JOIN ----------------------------");
		List<Factura> l2= this.facturaService.buscarFacturasFetchJoin();
		for(Factura f : l2) {
			System.out.println(f.getNumero());
			for(DetalleFactura df : f.getDetallesFacturas()) {
				System.out.println(df.getNombreProducto());
			}
		}
		
	}

}
