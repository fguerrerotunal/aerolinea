package uiMain.menuconsola.opcionesdeMenu;

import Utilidades.modificarVuelo;
import uiMain.menuconsola.MenuDeConsola;
import uiMain.menuconsola.OpcionDeMenu;

public class CancelarReserva extends OpcionDeMenu{
	
	public String Nombre() {
		return "Cancelar Reserva." ;
	}
	
	public void Ejecutar() {
		try{
			if(!MenuDeConsola.usuarioactual.cartera.isEmpty()) {
				System.out.println("¿Que vuelo deseas cancelar?");
				int vuelo = sc.nextInt();
				System.out.println(MenuDeConsola.usuarioactual.cancelarReserva(MenuDeConsola.usuarioactual.cartera.get(vuelo)));
			}else {
				System.out.println("No cuentas con reservas activas por el momento.");
			}
		}catch(modificarVuelo e) {
			System.out.println(e);;
		}
		
	}
}
