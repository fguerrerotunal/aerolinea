package uiMain.menuconsola;

import gestorAplicacion.Admin;
import gestorAplicacion.Cliente;

public class NuevoRegistro extends OpcionDeMenu{
	
	public String Nombre() {
		return "Nuevo registro.";
	}
	
	public void Ejecutar() {
		System.out.println("Por favor ingresar los datos a medida que se solicitan.");
		System.out.println("Identificacion:");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Nombre completo:");
		String nombre =	sc.nextLine();
		System.out.println("Numero de cuenta bancaria:");
		int cuenta = sc.nextInt();
		sc.nextLine();
		System.out.println("Direccion:");
		String direccion = sc.nextLine();
		System.out.println("Correo electronico");
		String correo = sc.next();
		System.out.println("Numero de Pasaporte");
		int pasaporte = sc.nextInt();
		Admin.clientes.add(new Cliente(id, cuenta, nombre, direccion, correo, pasaporte));
		System.out.println("Registrado Correctamente.");
		
	}
}
