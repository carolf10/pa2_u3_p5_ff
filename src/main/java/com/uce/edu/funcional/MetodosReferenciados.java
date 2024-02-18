package com.uce.edu.funcional;

public class MetodosReferenciados {
	public String obtenerId() {
		// TODO Auto-generated method stub
		String cedula ="465465465 ";
		cedula=cedula+"provincia"; 
		return cedula;
	}
	
	public void procesar(String cadena) {
		System.out.println(cadena);
		System.out.println("Se proceso la cadena");
	}
	
	public boolean evaluar (String cadena) {
		return "Edison".contains(cadena);
	}
	
	public boolean procesar (Integer numero) {
		return 8==numero;
	}
	
	public Ciudadano cambiar(Empleado empleado) {
		Ciudadano ciudadano= new Ciudadano();
		String nombre = empleado.getNombreCompleto().split(" ")[0];
		String apellido = empleado.getNombreCompleto().split(" ")[1];
		ciudadano.setApellido(apellido);
		ciudadano.setNombre(nombre);
		ciudadano.setProvincia("chimborazo");
		return ciudadano;
	}
	
	public Empleado procesar(Empleado empleado) {
		empleado.setNombreCompleto(empleado.getNombreCompleto() + " "+ empleado.getPais());
		empleado.setPais(empleado.getPais()+" de nacimeinto");
		return empleado;
	}
}
