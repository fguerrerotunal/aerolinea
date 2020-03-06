package uiMain.menuconsola;

import java.util.Iterator;

import gestorAplicacion.Master.Admin;

public class CanjearMillas  extends OpcionDeMenu{

	public String Nombre() {
		return "Canjear millas.";
	}
	
	public void Ejecutar() {
		System.out.println(Admin.ImprimirPremios());
		System.out.println("¿Que premio deseas canjear?");
		int premio = sc.nextInt();
		System.out.println(MenuDeConsola.usuarioactual.CanjearMillas(premio));
		
	}

}
