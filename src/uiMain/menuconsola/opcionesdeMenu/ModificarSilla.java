package uiMain.menuconsola.opcionesdeMenu;

import gestorAplicacion.AtencionAlCliente.Reserva;
import uiMain.menuconsola.MenuDeConsola;
import uiMain.menuconsola.OpcionDeMenu;

public class ModificarSilla  extends OpcionDeMenu{

	public String Nombre() {
		return "Modificar silla.";
	}
	
	public void Ejecutar() {
		System.out.println("Vuelo a cambiar silla: ");
		int posicion = sc.nextInt();
		if(MenuDeConsola.usuarioactual.cartera.get(posicion).getVuelo().getEstado().equals("Venta")){
			Reserva x=MenuDeConsola.usuarioactual.cartera.get(posicion);
			System.out.println(x.getVuelo().toString("sillas"));
			System.out.println("Escoge un nuevo puesto");
			int Npuesto=sc.nextInt();
			
			Reserva reserva = MenuDeConsola.usuarioactual.cartera.get(posicion);
			System.out.println("ESTA ACCION TIENE UN COSTO DE: "+reserva.getCosto()+"\n¿DESEA CONTINUAR?\nSI=0    NO=1");
			int continuar = sc.nextInt();
			if(continuar==0) {
				MenuDeConsola.usuarioactual.CambiarSilla(x, Npuesto);
				System.out.println("¿Que medio de pago desea usar?\nEfectivo = 0\tMillas = 1");
				int medio = sc.nextInt();
				System.out.println(MenuDeConsola.usuarioactual.Pago(medio, reserva));
			}else {
				System.out.println("OPERACON CANCELADA");
			}
		}
		else {
			System.out.println("Solo puedes modificarlo en estado de venta");
		}
	}
}
