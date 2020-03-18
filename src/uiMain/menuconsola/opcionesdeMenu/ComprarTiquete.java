package uiMain.menuconsola.opcionesdeMenu;

import java.util.Iterator;

import gestorAplicacion.AtencionAlCliente.Reserva;
import gestorAplicacion.Master.Empleado;
import gestorAplicacion.Master.Vuelo;
import uiMain.menuconsola.MenuDeConsola;
import uiMain.menuconsola.OpcionDeMenu;

public class ComprarTiquete  extends OpcionDeMenu{

	public String Nombre() {
		return "Comprar tiquete.";
	}
	
	public void Ejecutar() {
		Boolean imp = false;
		Iterator i = Empleado.vuelos.iterator();
		while(i.hasNext()) {
			if(((Vuelo) i.next()).getEstado().equals("Venta")) {
				imp = true;
				break;
			}
		}
		if(imp==true) {
			System.out.println(MenuDeConsola.usuarioactual.ConsultarVuelos());
			System.out.println("Seleccione un vuelo: ");
			int vuelo = sc.nextInt();
			
			System.out.println("ESTA ACCION TIENE UN COSTO DE: "+Empleado.vuelos.get(vuelo).getPrecioTiquete()+"\n¿DESEA CONTINUAR?\nSI=0    NO=1");
			int continuar = sc.nextInt();
			if(continuar==0 && (MenuDeConsola.usuarioactual.Reservar(Empleado.vuelos.get(vuelo)))==true) {
				Reserva reserva = MenuDeConsola.usuarioactual.cartera.get(MenuDeConsola.usuarioactual.cartera.size()-1);
				System.out.println("¿Que medio de pago desea usar?\nEfectivo = 0\tMillas = 1");
				int medio = sc.nextInt();
				System.out.println(MenuDeConsola.usuarioactual.Pago(medio,reserva));
			}else {
				System.out.println("OPERACON CANCELADA");
			}
		}else {
			System.out.println("NO HAY VUELOS DISPONIBLES");
		}
		
	}

}
