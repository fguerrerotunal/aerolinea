package uiMain.menuconsola.opcionesdeMenu;

import Utilidades.tipoDato;
import gestorAplicacion.Master.Admin;
import uiMain.menuconsola.MenuDeConsola;
import uiMain.menuconsola.OpcionDeMenu;
/*
 * Esta opcion es para cuando el usuario desea utilizar las millas conseguidas 
 * para canjearlas por premios
 */
public class CanjearMillas  extends OpcionDeMenu{

	public String Nombre() {
		return "Canjear millas.";
	}
	
	public void Ejecutar() {
		System.out.println(Admin.ImprimirPremios());
		System.out.println("¿Que premio deseas canjear?");
		int premio = sc.nextInt();
		try {
			System.out.println(MenuDeConsola.usuarioactual.CanjearMillas(premio));
		}catch(tipoDato e) {
			System.out.println(e.getMessage());
		}
	}

}
