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
			System.out.println(f);
		}
		
		System.out.println("RIGHT JOIN ----------------------------");
		List<Factura> list1 = this.facturaService.buscarFacturasRightJoin();
		for(Factura f : list1) {
			System.out.println(f.getNumero());
		}
		
		System.out.println("LEFT JOIN ----------------------------");
		List<Factura> list2 = this.facturaService.buscarFacturasLeftJoin();
		for(Factura f : list2) {
			System.out.println(f);
		}
		
		System.out.println("FULL JOIN ----------------------------");
		List<Factura> list3 = this.facturaService.buscarFacturasFullJoin();
		for(Factura f : list3) {
			System.out.println(f);
			for (DetalleFactura df : f.getDetallesFacturas()) {
				System.out.println(df);
			}
		}
	}

}
