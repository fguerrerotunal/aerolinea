package uiMain.menuconsola;

public class Salir extends OpcionDeMenu{
	public String Nombre() {
		return "Salir.";
	}
	
	public void Ejecutar() {
		System.out.print("GRACIAS POR ESCOGERNOS");
		System.exit(0);
	}
}
