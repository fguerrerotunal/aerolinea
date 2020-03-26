package uiMain.menuconsola.opcionesdeMenu;

import uiMain.menuconsola.OpcionDeMenu;
/*
 * Esta opcion imprime la informacion de los autores del programa.
 */
public class Autores extends OpcionDeMenu{

	private static String mensaje = "DESARROLLADORES: "
			+ "\n "
			+ "Jhoan Leandro Ramirez Martinez: 1000397798 "
			+ "\n "
			+ "Federico Guerrero Trejos: 1002899765"
			+ "\n"
			+ "Cristian Jaramillo Ramirez: 1000901462";
	@Override
	public String Nombre() {
		String nombre = "Autores.";
		return nombre;
	}

	@Override
	public void Ejecutar() {
		System.out.println(mensaje);
	}

	public static String getMensaje() {
		return mensaje;
	}
	
}
