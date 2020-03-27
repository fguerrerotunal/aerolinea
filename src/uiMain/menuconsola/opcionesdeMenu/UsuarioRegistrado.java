package uiMain.menuconsola.opcionesdeMenu;

import Utilidades.clienteInexistente;
import gestorAplicacion.Master.Admin;
import uiMain.menuconsola.MenuDeConsola;
import uiMain.menuconsola.OpcionDeMenu;
/*
 * Opcion que se ejecuta cuando un usuario quiere ingresar a su cuenta
 */
public class UsuarioRegistrado extends OpcionDeMenu{
	
	MenuDeConsola sigmenu;
	
	public UsuarioRegistrado(){
		
	}
	
	public UsuarioRegistrado(MenuDeConsola sigmenu){
		this.sigmenu=sigmenu;
	}
	public String Nombre() {
		return "Usuario registrado.";
	}
	
	public void Ejecutar() {
		try{
			System.out.print("Ingrese id: ");
			int identificacion = sc.nextInt();
			int posicion = Admin.BuscarCliente(identificacion);
			MenuDeConsola.usuarioactual = Admin.clientes.get(posicion);
			System.out.println("Ingreso exitoso.");
			sigmenu.LanzarMenu();
		}catch(clienteInexistente e) {
			System.out.println(e.getMessage());
		}
		
	}

}