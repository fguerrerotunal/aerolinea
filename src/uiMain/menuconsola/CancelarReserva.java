package uiMain.menuconsola;

public class CancelarReserva extends OpcionDeMenu{
	
	public String Nombre() {
		return "Cancelar Reserva" ;
	}
	
	public void Ejecutar() {
		int vuelo = sc.nextInt();
		MenuDeConsola.usuarioactual.cancelarReserva(MenuDeConsola.usuarioactual.cartera.get(vuelo));
	}
}
