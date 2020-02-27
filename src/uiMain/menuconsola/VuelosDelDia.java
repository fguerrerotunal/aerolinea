package uiMain.menuconsola;
public class VuelosDelDia  extends OpcionDeMenu{

	public String Nombre() {
		return "Vuelos del dia.";
	}
	
	public void Ejecutar() {
		System.out.println(MenuDeConsola.usuarioactual.ConsultarEstadoVuelos());
	}

}
