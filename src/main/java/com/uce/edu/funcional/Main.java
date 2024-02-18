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
		System.out.println("-> Metodos Referenciado");
		MetodosReferenciados met= new MetodosReferenciados();
		IPersonaSupplier<String> supplierMetoReferenciado=met::obtenerId;
		System.out.println(supplierMetoReferenciado.getId());
		
		//Tipo de IF: 2. Consumer
		System.out.println("Consumer -----------------");
		//Tipo de implementacion: Clases
		System.out.println("-> Clases");
		IPersonaConsumer<String> consumerClase=new PersonaConsumerImpl();
		consumerClase.accept("Profesor");
		
		//Tipo de implementacion: Lambda
		System.out.println("-> Lambda");
		IPersonaConsumer<String> consumerLambas1= cadena -> {
			System.out.println("Se inserta");
			System.out.println(cadena);
		};
		consumerLambas1.accept("Profesor");
		
		//Tipo de implementacion: Metodos Referenciados
		System.out.println("-> Metodos Referenciado");
		IPersonaConsumer<String> consumerMetReferenciados = met::procesar;
		consumerMetReferenciados.accept("Fatima Referenciado");
		
		//Tipo de IF: 3. Predicate
		System.out.println("Predicate -----------------");
		//Tipo de implementacion: Lambda
		System.out.println("-> Lambda");
		IPersonaPredicate<Integer> predicateLambda1 = numero -> numero.compareTo(7) == 0;
		System.out.println(predicateLambda1.evaluar(Integer.valueOf(6)));
		
		IPersonaPredicate<String> predicateLambda2= letra -> "Edison".contains(letra);
		System.out.println(predicateLambda2.evaluar("a"));
		
		//Tipo de implementacion: Metodos Referenciados
		System.out.println("-> Metodos Referenciado");
		IPersonaPredicate<String> predicateMetRefer = met::evaluar;
		System.out.println(predicateMetRefer.evaluar("W"));
		
		IPersonaPredicate<Integer> predicateMetRefer2 = met::procesar;
		System.out.println(predicateMetRefer2.evaluar(10));
		
		//Tipo de IF: 4. Function
		System.out.println("FUNCTION -----------------");
		//Tipo de implementacion: Lambda
		System.out.println("-> Lambda");
		IPersonaFunction<String, Integer> functionLambda1 = numero -> {
			numero = numero + Integer.valueOf(10);
			String numeroString = numero.toString().concat("-Valor");
			return numeroString;
		};
		System.out.println(functionLambda1.aplicar(7));
		
		IPersonaFunction<Empleado, Ciudadano> functionLambda2= ciudadano -> {
			Empleado empl = new Empleado();
			empl.setNombreCompleto(ciudadano.getNombre()+" "+ciudadano.getApellido());
			if (ciudadano.getProvincia().compareTo("pichincha")==0) {
				empl.setPais("Ecuador");
			}
			return empl;
		};
		Ciudadano ciud = new Ciudadano();
		ciud.setApellido("Fiallos");
		ciud.setNombre("Fatima");
		ciud.setProvincia("pichincha");
		
		Empleado empl = functionLambda2.aplicar(ciud);
		System.out.println(empl);
		
		//Tipo de implementacion: Metodos Referenciados
		System.out.println("-> Metodos Referenciado");
		IPersonaFunction<Ciudadano, Empleado>	functionMetRefer=met::cambiar;
		Empleado empleado = new Empleado();
		empleado.setNombreCompleto("Daniel Tobar");
		empleado.setPais("Ecuador");
		Ciudadano ciudadano = functionMetRefer.aplicar(empleado);
		System.out.println(ciudadano);
		
		//Tipo de IF: 5.1 Unary Operator
		System.out.println("Unary Operator -----------------");
		//Tipo de implementacion: Lambda
		System.out.println("-> Lambda");
		IPersonaUnaryOperator<Integer> unaryOperatorLambda1= numero -> numero + (numero*2);
		System.out.println(unaryOperatorLambda1.aplicar(14));
		
		
		//Tipo de IF: 5.2 Unary Operator Function que es por la herencia
		System.out.println("Unary Operator Function -----------------");
		//Tipo de implementacion: Lambda
		System.out.println("-> Lambda");
		
		IPersonaUnaryOperatorFunction<Integer> unaryOperatorLambda2= numero -> numero + (numero*2);
		System.out.println(unaryOperatorLambda2.aplicar(10));
		
		//Tipo de implementacion: Metodos Referenciados
		System.out.println("-> Metodos Referenciado");
		IPersonaUnaryOperatorFunction<Empleado> unaryOperMetRefer= met::procesar;
		Empleado emple = unaryOperMetRefer.aplicar(empleado);
		System.out.println(emple);
	}

}
