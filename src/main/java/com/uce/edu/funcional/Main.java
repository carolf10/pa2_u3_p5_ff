package com.uce.edu.funcional;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Tipo de IF: 1. Supplier
		System.out.println("Supplier -----------------");
		//Tipo de implementacion: Clase
		System.out.println("-> Clases");
		IPersonaSupplier<String> supplierClase=new PersonaSupplierImpl();
		System.out.println(supplierClase.getId());
		
		//Tipo de implementacion: Lambda
		System.out.println("-> Lambda");
		IPersonaSupplier<String> supplierLambda1 = () -> {
			String cedula ="465465465";
			cedula=cedula+"canton"; 
			return cedula;
		};
		System.out.println(supplierLambda1.getId());
		
		IPersonaSupplier<String> supplierLambda2 = () -> "465465465"+"pais";
		System.out.println(supplierLambda2.getId());
		
		IPersonaSupplier<Integer> supplierLambda3 = () -> {
			Integer valor1= Integer.valueOf(100);
			valor1= valor1*Integer.valueOf(50)/Integer.valueOf(5);
			return valor1;
			
		};
		System.out.println(supplierLambda3.getId());
		
		//Tipo de implementacion: Metodos Referenciados
		
		//Tipo de IF: 2. Consumer
		System.out.println("Consumer -----------------");
		//Tipo de implementacion: Clases
		System.out.println("-> Clases");
		IPersonaConsumer<String> consumerClase=new PersonaConsumerImpl();
		consumerClase.accept("Profesor");
		
		System.out.println("-> Lambda");
		IPersonaConsumer<String> consumerLambas1= cadena -> {
			System.out.println("Se inserta");
			System.out.println(cadena);
		};
		consumerLambas1.accept("Profesor");
		
		System.out.println("Predicate -----------------");
		System.out.println("-> Lambda");
		IPersonaPredicate<Integer> predicateLambda1 = numero -> numero.compareTo(7) == 0;
		System.out.println(predicateLambda1.evaluar(Integer.valueOf(6)));
		
		IPersonaPredicate<String> predicateLambda2= letra -> "Edison".contains(letra);
		System.out.println(predicateLambda2.evaluar("a"));
		
	}

}
