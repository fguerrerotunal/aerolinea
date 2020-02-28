package uiMain.menuconsola;
import gestorAplicacion.Admin;
public class UsuarioRegistrado extends OpcionDeMenu{
	
	MenuDeConsola sigmenu;
	
	UsuarioRegistrado(){
		
	}
	
	UsuarioRegistrado(MenuDeConsola sigmenu){
		this.sigmenu=sigmenu;
	}
	public String Nombre() {
		return "Usuario registrado.";
	}
	
	public void Ejecutar() {
		System.out.print("Ingrese id: ");
		int identificacion = sc.nextInt();
		int posicion = Admin.BuscarCliente(identificacion);
		if(posicion<0 ) {
			System.out.println("USUARIO INEXISTENTE");
		}else {
			MenuDeConsola.usuarioactual = Admin.clientes.get(posicion);
			System.out.println("Ingreso exitoso.");
			sigmenu.LanzarMenu();
		}
		
	}

}