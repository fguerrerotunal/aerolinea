package uiMain.menuconsola;

public class CancelarReserva extends OpcionDeMenu{
	
	public String Nombre() {
		return "Cancelar Reserva" ;
	}
	
	public void Ejecutar() {
		int vuelo = sc.nextInt();
		System.out.println(MenuDeConsola.usuarioactual.cancelarReserva(MenuDeConsola.usuarioactual.cartera.get(vuelo)));
	}
}
