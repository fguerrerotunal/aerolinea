package uiMain.menuconsola;
import Basededatos.Writer;
public class Salir extends OpcionDeMenu{
	public String Nombre() {
		return "Salir.";
	}
	
	public void Ejecutar() {
		if(MenuDeConsola.usuarioactual.Deuda() != 0) {
			System.out.println("Se debe cancelar la deuda actual \n antes de salir de la aplicacion.");
		}else {
			System.out.print("GRACIAS POR ESCOGERNOS");
			//Writer.Escribir();
			System.exit(0);
		}
		
	}
}
