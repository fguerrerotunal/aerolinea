package uiMain.menuconsola.opcionesdeMenu;

import uiMain.menuconsola.OpcionDeMenu;

public class Descripccion extends OpcionDeMenu{

	@Override
	public String Nombre() {
		String nombre = "Descripccion.";
		return nombre;
	}

	@Override
	public void Ejecutar() {
		System.out.println("________________Aerolinea LUNA`S________________\n"
						+ "	Bienvenido, esta aplicacion le permitira hacer\n"
						+ " una gestion completa de los servicios que presta\n"
						+ " la aerolinea a travez de las diferentes opciones\n"
						+ " que se manifiestan durante su uso.");
	}
}
