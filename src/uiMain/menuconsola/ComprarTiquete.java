package uiMain.menuconsola;

import java.util.Iterator;

import gestorAplicacion.Empleado;
import gestorAplicacion.Vuelo;

public class ComprarTiquete  extends OpcionDeMenu{

	public String Nombre() {
		return "Comprar tiquete.";
	}
	
	public void Ejecutar() {
		Boolean imp = false;
		Iterator i = Empleado.vuelos.iterator();
		while(i.hasNext()) {
			if(((Vuelo) i.next()).estado.equals("Venta")) {
				imp = true;
				break;
			}
		}
		if(imp==true) {
			System.out.println(MenuDeConsola.usuarioactual.ConsultarVuelos());
			System.out.println("Seleccione un vuelo: ");
			int vuelo = sc.nextInt();
			MenuDeConsola.usuarioactual.Reservar(Empleado.vuelos.get(vuelo));
			System.out.println("¿Que medio de pago desea usar?\nEfectivo = 0\tMillas = 1");
			int medio = sc.nextInt();
			System.out.println(MenuDeConsola.usuarioactual.Pago(medio));
		}else {
			System.out.println("NO HAY VUELOS DISPONIBLES");
		}
		
	}

}
