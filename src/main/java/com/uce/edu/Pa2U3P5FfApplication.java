package com.uce.edu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import com.uce.edu.ventas.repository.modelo.Cliente;
import com.uce.edu.ventas.service.IClienteService;

@SpringBootApplication
@EnableAsync
public class Pa2U3P5FfApplication implements CommandLineRunner{
	@Autowired
	private IClienteService clienteService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5FfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
//		System.out.println("Nombre Hilo: " + Thread.currentThread().getName());
//		//Significa que vamos revisar los hilos de ejecucion  
//		
//		long timepoInicial = System.currentTimeMillis();
//		for(int i=1; i<=10;i++) {
//			Cliente cliente= new Cliente();
//			cliente.setNombre("CN"+i);
//			cliente.setApellido("CA"+i);
//			this.clienteService.guardar(cliente);
//		}
//		long timepoFinal = System.currentTimeMillis();
//		long tiempoTranscurrido = (timepoFinal - timepoInicial)/1000;
//		System.out.println("Tiempo transcorrido en seg: " + tiempoTranscurrido);
//		//101	
		
//		System.out.println("Nombre Hilo: " + Thread.currentThread().getName());
//		long timepoInicial = System.currentTimeMillis();
//		List<Cliente> listaCliente = new ArrayList<>();
//		for(int i=1; i<= 100;i++) {
//			Cliente cliente= new Cliente();
//			cliente.setNombre("CN"+i);
//			cliente.setApellido("CA"+i);
//			listaCliente.add(cliente);
//		}
//		
//		listaCliente.stream().forEach(cliente -> this.clienteService.guardar(cliente));
//		long timepoFinal = System.currentTimeMillis();
//		long tiempoTranscurrido = (timepoFinal - timepoInicial)/1000;
//		System.out.println("Tiempo transcorrido en seg: " + tiempoTranscurrido);
//		//101	
		
//		System.out.println("Nombre Hilo: " + Thread.currentThread().getName());
//		long timepoInicial = System.currentTimeMillis();
//		List<Cliente> listaCliente = new ArrayList<>();
//		for(int i=1; i<= 100;i++) {
//			Cliente cliente= new Cliente();
//			cliente.setNombre("CN"+i);
//			cliente.setApellido("CA"+i);
//			listaCliente.add(cliente);
//		}
//		
//		listaCliente.parallelStream().forEach(cliente -> this.clienteService.guardar(cliente));
//		long timepoFinal = System.currentTimeMillis();
//		long tiempoTranscurrido = (timepoFinal - timepoInicial)/1000;
//		System.out.println("Tiempo transcorrido en seg: " + tiempoTranscurrido);
//		//14
//		
		
		System.out.println("Nombre Hilo: " + Thread.currentThread().getName());
		long timepoInicial = System.currentTimeMillis();
		for(int i=1; i<= 10;i++) {
			Cliente cliente= new Cliente();
			cliente.setNombre("CN"+i);
			cliente.setApellido("CA"+i);
			this.clienteService.guardar(cliente);
		}
		
		long timepoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (timepoFinal - timepoInicial)/1000;
		System.out.println("Tiempo transcorrido en seg: " + tiempoTranscurrido);
		System.out.println("Se ha mandado a procesar sus datos, puede continuar");
		
		
		
		
		
	}

}
