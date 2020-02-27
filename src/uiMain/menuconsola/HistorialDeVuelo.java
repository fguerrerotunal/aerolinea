package uiMain.menuconsola;

public class HistorialDeVuelo  extends OpcionDeMenu{

	public String Nombre() {
		return "Historial de vuelo";
	}
	
	public void Ejecutar() {
		System.out.println(MenuDeConsola.usuarioactual.Historial());
	}

}
