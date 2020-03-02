package uiMain.menuconsola;

import gestorAplicacion.Reserva;

public class ModificarEquipaje  extends OpcionDeMenu{

	public String Nombre() {
		return "Modificar equipaje";
	}
	
	public void Ejecutar() {
		System.out.println("Vuelo a cambiar equipaje: ");
		int posicion = sc.nextInt();
		int Npeso = sc.nextInt();
		MenuDeConsola.usuarioactual.cartera.get(posicion).setEquipaje(Npeso);
		System.out.println("Cambio exitoso");
	}
}
