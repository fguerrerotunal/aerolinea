package uiMain.menuconsola.opcionesdeMenu;

import uiMain.menuconsola.MenuDeConsola;
import uiMain.menuconsola.OpcionDeMenu;
/*
 * Opcion que muestra una lista con los vuelos los cuales a adquirido el usuario
 */
public class HistorialDeVuelo  extends OpcionDeMenu{

	public String Nombre() {
		return "Historial de vuelo.";
	}
	
	public void Ejecutar() {
		System.out.println(MenuDeConsola.usuarioactual.Historial());
	}

}
