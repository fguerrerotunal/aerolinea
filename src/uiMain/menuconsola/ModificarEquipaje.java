package uiMain.menuconsola;

import gestorAplicacion.Empleado;
import gestorAplicacion.Reserva;

public class ModificarEquipaje  extends OpcionDeMenu{

	public String Nombre() {
		return "Modificar equipaje";
	}
	
	public void Ejecutar() {
		System.out.println("Vuelo a cambiar equipaje: ");
		int posicion = sc.nextInt();
		System.out.println("Nuevo peso del equipaje: ");
		int Npeso = sc.nextInt();
		
		Reserva reserva = MenuDeConsola.usuarioactual.cartera.get(posicion);
		System.out.println("ESTA ACCION TIENE UN COSTO DE: "+ reserva.getCosto()+"\n¿DESEA CONTINUAR?\nSI=0    NO=1");
		int continuar = sc.nextInt();
		if(continuar==0) {
			MenuDeConsola.usuarioactual.cartera.get(posicion).setEquipaje(Npeso);
			System.out.println("¿Que medio de pago desea usar?\nEfectivo = 0\tMillas = 1");
			int medio = sc.nextInt();
			System.out.println(MenuDeConsola.usuarioactual.Pago(medio, reserva));
		}else {
			System.out.println("OPERACON CANCELADA");
		}
		
		
	}
}
