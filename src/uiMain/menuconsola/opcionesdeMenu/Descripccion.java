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
		System.out.println("bla bla bla");
	}
}
