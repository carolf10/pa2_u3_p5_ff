package com.uce.edu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.hospedaje.repository.modelo.Habitacion;
import com.uce.edu.hospedaje.repository.modelo.Hotel;
import com.uce.edu.hospedaje.service.IHabitacionService;
import com.uce.edu.hospedaje.service.IHotelService;

@SpringBootApplication
public class Pa2U3P5FfApplication implements CommandLineRunner{
	@Autowired
	private IHabitacionService habitacionService;
	@Autowired
	private IHotelService hotelService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5FfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("INNER JOIN ----------------------------");
		List<Hotel> l1= this.hotelService.buscarPorClase("Presidencial");
		for(Hotel h : l1) {
			System.out.println(h);
		}
		
		System.out.println("RIGHT JOIN ----------------------------");
		List<Hotel> l2 = this.hotelService.buscarPorNumero("E01");
		for (Hotel h : l2) {
			System.out.println(h);
		}
		
		System.out.println("LEFT JOIN ----------------------------");
		List<Habitacion> l3 = this.habitacionService.buscarPorNombre("Hilton Colon");
		for(Habitacion habitacion : l3) {
			System.out.println(habitacion);
		}
		
		System.out.println("FULL JOIN ----------------------------");
		List<Habitacion> l4 = this.habitacionService.buscarPorDireccion("Patria");
		for(Habitacion h : l4) {
			System.out.println(h);
		}
		
		
		
		
	}

}
