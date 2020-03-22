package uiMain.menuconsola.opcionesdeMenu;

import uiMain.menuconsola.OpcionDeMenu;

public class Autores extends OpcionDeMenu{

	@Override
	public String Nombre() {
		String nombre = "Autores.";
		return nombre;
	}

	@Override
	public void Ejecutar() {
		System.out.println("CREADO POR: "
				+ "\n "
				+ "\n "
				+ "Jhoan Leandro Ramirez Martinez + 1000397798 "
				+ "\n "
				+ "\n"
				+ "Federico Guerrero Trejos: 1002899765"
				+ "\n"
				+ "\n"
				+ "Cristian Jaramillo Ramirez + 1000901462");
	}
}
