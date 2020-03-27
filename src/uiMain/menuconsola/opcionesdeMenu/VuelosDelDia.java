package uiMain.menuconsola.opcionesdeMenu;

import uiMain.menuconsola.MenuDeConsola;
import uiMain.menuconsola.OpcionDeMenu;
/*
 * Opcion que imprime el estado de todos los vuelos que hay en el día 
 */
public class VuelosDelDia  extends OpcionDeMenu{

	public String Nombre() {
		return "Vuelos del dia.";
	}
	
	public void Ejecutar() {
		System.out.println(MenuDeConsola.usuarioactual.ConsultarEstadoVuelos());
	}

}
