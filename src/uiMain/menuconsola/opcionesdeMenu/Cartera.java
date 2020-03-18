package uiMain.menuconsola.opcionesdeMenu;

import uiMain.menuconsola.MenuDeConsola;
import uiMain.menuconsola.OpcionDeMenu;

public class Cartera  extends OpcionDeMenu{

	public String Nombre() {
		return "Cartera.";
	}
	
	public void Ejecutar() {
		System.out.println(MenuDeConsola.usuarioactual.Cartera());
	}
}
