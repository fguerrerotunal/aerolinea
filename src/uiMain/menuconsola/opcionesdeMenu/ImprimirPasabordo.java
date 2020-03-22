package uiMain.menuconsola.opcionesdeMenu;

import uiMain.menuconsola.MenuDeConsola;
import uiMain.menuconsola.OpcionDeMenu;

public class ImprimirPasabordo  extends OpcionDeMenu{

	public String Nombre() {
		return "Imprimir pasabordo.";
	}
	
	public void Ejecutar() {
		if(!MenuDeConsola.usuarioactual.cartera.isEmpty()) {
			System.out.println(MenuDeConsola.usuarioactual.Cartera());
			System.out.println("Vuelo a imprimir pasaobordo: ");
			int vuelo = sc.nextInt();
			System.out.println(MenuDeConsola.usuarioactual.Pasabordo(MenuDeConsola.usuarioactual.cartera.get(vuelo)));
		}
	}
}
