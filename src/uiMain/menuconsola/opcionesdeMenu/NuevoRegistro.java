package uiMain.menuconsola.opcionesdeMenu;

import Utilidades.clienteInexistente;
import Utilidades.registroDuplicado;
import gestorAplicacion.AtencionAlCliente.Cliente;
import gestorAplicacion.Master.Admin;
import uiMain.menuconsola.OpcionDeMenu;

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
		try {
			Admin.BuscarCliente(id);
			throw new registroDuplicado();
		}catch(clienteInexistente e){
			Admin.clientes.add(new Cliente(id, cuenta, nombre, direccion, correo, pasaporte));
			System.out.println("Registrado Correctamente.");
		}catch(registroDuplicado e) {
			System.out.println(e.getMessage());
		}
	}
}
