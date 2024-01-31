package com.uce.edu;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.ventas.repository.modelo.FacturaDTO;
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
		System.out.println("Update ----------------------------");
		int cantidad=this.facturaService.actulizarFechas(LocalDateTime.of(2020, 1, 9, 12, 50), LocalDateTime.of(2020, 1, 15, 12, 0));
		System.out.println("Cantidad de registros/filas actualizadas: " + cantidad);
		
		System.out.println("DELETE NUMERO ----------------------------");
		int cantidad2=this.facturaService.borrarPorNumero("0001-02569");
		System.out.println("Cantidad de registros/filas actualizadas: " + cantidad2);
		
		//System.out.println("DELETE ID ----------------------------");
		//this.facturaService.borrar(2);
		
		System.out.println("DOT ----------------------------");
		List<FacturaDTO> listaDTO=this.facturaService.buscarFacturasDTO();
		for(FacturaDTO dto: listaDTO) {
			System.out.println(dto);
		}
		
	}

}
