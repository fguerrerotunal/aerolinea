package uiMain.menuconsola.opcionesdeMenu;

import uiMain.menuconsola.OpcionDeMenu;
/*
 * Opcion que imprime una pequeña descripcion del programa
 */
public class Descripccion extends OpcionDeMenu{

	public static String mensaje = "			Aerolinea LUNA`S			\n"
		    + "Bienvenido, esta aplicacion le permitira hacer\n"
		    + "una gestion completa de los servicios que presta\n"
		    + "la aerolinea a travez de las diferentes opciones\n"
		    + "que se manifiestan durante su uso.";
	@Override
	public String Nombre() {
		String nombre = "Descripcion.";
		return nombre;
	}

	@Override
	public void Ejecutar() {
		System.out.println(mensaje);
	}
}
