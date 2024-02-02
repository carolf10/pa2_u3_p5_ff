package com.uce.edu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.deber.repository.modelo.Autor;
import com.uce.edu.deber.repository.modelo.Ciudadano;
import com.uce.edu.deber.repository.modelo.Empleado;
import com.uce.edu.deber.repository.modelo.Estudiante;
import com.uce.edu.deber.repository.modelo.Libro;
import com.uce.edu.deber.service.IAutorService;
import com.uce.edu.deber.service.ICiudadanoService;
import com.uce.edu.deber.service.IEmpleadoService;
import com.uce.edu.deber.service.IEstudianteService;
import com.uce.edu.deber.service.ILibroService;

@SpringBootApplication
public class Pa2U3P5FfApplication implements CommandLineRunner{
	@Autowired
	private ICiudadanoService ciudadanoService;
	@Autowired
	private IEmpleadoService empleadoService;
	@Autowired
	private IEstudianteService estudianteService;
	@Autowired
	private IAutorService autorService;
	@Autowired
	private ILibroService iLibroService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5FfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("INNER JOIN ----------------------------");
		List<Libro> l1= this.iLibroService.buscarPorNombre("Jorge");
		for(Libro libro:l1) {
			System.out.println(libro);
		}
		List<Empleado> l2= this.empleadoService.buscarPorCedula("1753341333");
		System.out.println(l2);
		
		System.out.println("LEFT JOIN ----------------------------");
		List<Libro> l3= this.iLibroService.buscarPorNacionalidad("Ecuatoriano");
		for(Libro libro:l3) {
			System.out.println(libro);
		}
		List<Empleado> l4= this.empleadoService.buscarPorNombre("Fatima");
		System.out.println(l4);
		
		System.out.println("RIGHT JOIN ----------------------------");
		List<Estudiante> l6= this.estudianteService.buscarPorCodigo("M01");
		System.out.println(l6);
		
		List<Ciudadano> l7= this.ciudadanoService.buscarPorCodigo("E01");
		for(Ciudadano ciudadano : l7) {
			System.out.println(ciudadano);
		}
		
		System.out.println("FULL JOIN ----------------------------");
		List<Autor> l8= this.autorService.buscarPorTitulo("Meridia");
		for(Autor autor:l8) {
			System.out.println(autor);
		}
		List<Ciudadano> l9= this.ciudadanoService.buscarPorDireccion("Alma Lojana");
		System.out.println(l9);
		
		System.out.println("FETCH JOIN ----------------------------");
		List<Estudiante> l5= this.estudianteService.buscarPorNombre("Programacion");
		System.out.println(l5);
		
		List<Autor> l10= this.autorService.buscarPorCodigo("L01");
		for(Autor autor:l10) {
			System.out.println(autor);
		}
		
		
		
	}

}
