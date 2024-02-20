package com.uce.edu.funcional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

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
		
		
		System.out.println("----- Implemantacion de interfaces funcionales mediante libreria JAVA -----");
		
		//1. Supplier
		System.out.println("1. Supplier **************");
		Stream<String> lista = Stream.generate(() -> "465465465"+"pais").limit(20);
		lista.forEach(cadena -> System.out.println(cadena));
		
		//2. Consumer
		System.out.println("2. Consumer **************");
		List<Integer> listaNumeros=Arrays.asList(1,2,3,4,5,67,8,5,4,85,74);
		listaNumeros.forEach(cadena -> {
			System.out.println("Se inserta");
			System.out.println(cadena);
		});
		
		//3. Predicate
		System.out.println("3. Predicate **************");
		Stream<Integer> listaFiltrada = listaNumeros.stream().filter(numero -> numero >= 10);
		listaFiltrada.forEach(numero -> System.out.println(numero));
		
		//4. Function
		System.out.println("4. Function ***************");
		Stream<String> listaCambiada = listaNumeros.stream().map(numero -> {
			numero = numero*100 /50;
			return "Num: "+numero.toString();
		});
		listaCambiada.forEach(cadena -> System.out.println(cadena));
		
		Ciudadano ciud01 = new Ciudadano();
		ciud01.setApellido("Cayambe");
		ciud01.setNombre("Edison");
		ciud01.setProvincia("pichincha");
		
		Ciudadano ciud02 = new Ciudadano();
		ciud02.setApellido("Jacome");
		ciud02.setNombre("Viviana");
		ciud02.setProvincia("pichincha");
		
		Ciudadano ciud03 = new Ciudadano();
		ciud03.setApellido("Teran");
		ciud03.setNombre("Daniel");
		ciud03.setProvincia("pichincha");
		
		List<Ciudadano> listaCiudadano= Arrays.asList(ciud01,ciud02, ciud03);
		Stream<Empleado> listaEmpleado= listaCiudadano.stream().map(ciudadano01 -> {
			Empleado empl01 = new Empleado();
			empl01.setNombreCompleto(ciudadano01.getNombre()+" "+ciudadano01.getApellido());
			if (ciudadano01.getProvincia().compareTo("pichincha")==0) {
				empl01.setPais("Ecuador");
			}
			return empl01;
		});
		listaEmpleado.forEach(empleado01 -> System.out.println(empleado01));
		
		//5. Unary Operator 
		System.out.println("5. Unaty Operator ****************");
		Stream<Integer> listaNumero2 = listaNumeros.stream().map(numero -> {
			numero = numero*100 /50;
			return numero;
		});
		listaNumero2.forEach(numero -> System.out.println(numero));
		
		
		
	}

}
