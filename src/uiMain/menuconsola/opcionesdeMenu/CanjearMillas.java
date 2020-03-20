package uiMain.menuconsola.opcionesdeMenu;

import gestorAplicacion.Master.Admin;
import uiMain.menuconsola.MenuDeConsola;
import uiMain.menuconsola.OpcionDeMenu;

public class CanjearMillas  extends OpcionDeMenu{

	public String Nombre() {
		return "Canjear millas.";
	}
	
	public void Ejecutar() {
		System.out.println(Admin.ImprimirPremios());
		System.out.println("�Que premio deseas canjear?");
		int premio = sc.nextInt();
		System.out.println(MenuDeConsola.usuarioactual.CanjearMillas(premio));
		
	}

}