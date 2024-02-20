package com.uce.edu.ventas.service;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.ventas.repository.IClienteRepository;
import com.uce.edu.ventas.repository.modelo.Cliente;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;
@Service
public class ClienteServiceImpl implements IClienteService {
	@Autowired
	private IClienteRepository clienteRepository;
	
	@Override
	@Transactional(value = TxType.REQUIRES_NEW) //T2
	//begin
	public void guardar(Cliente cliente) {
		// TODO Auto-generated method stub
		try{
			this.clienteRepository.insertar(cliente);
			try {
				// Buscar en el registro civil
				// Validar no tenga deudas
				// Validar
				// ...
				System.out.println("Nombre Hilo: " + Thread.currentThread().getName());
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch (RuntimeException e) {
			// TODO: handle exception
			System.out.println(e.getClass());
		} 
		
	} //commit

	@Override
	@Transactional(value = TxType.SUPPORTS)
	public void pruebaSupports() {
		// TODO Auto-generated method stub
		System.out.println("Este es un metodo supports");
		System.out.println("Prueba supports: " + TransactionSynchronizationManager.isActualTransactionActive());
		
	}

	@Override
	@Transactional(value = TxType.NEVER)
	public void pruebaNEver() {
		// TODO Auto-generated method stub
		System.out.println("Este es un metodo never");
		System.out.println("Prueba never: " + TransactionSynchronizationManager.isActualTransactionActive());
		
	}

}
