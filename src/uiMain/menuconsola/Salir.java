package uiMain.menuconsola;
import Basededatos.Writer;
public class Salir extends OpcionDeMenu{
	public String Nombre() {
		return "Salir.";
	}
	
	public void Ejecutar() {
		System.out.print("GRACIAS POR ESCOGERNOS");
		//Writer.Escribir();
		System.exit(0);
	}
}
