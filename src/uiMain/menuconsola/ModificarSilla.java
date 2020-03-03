package uiMain.menuconsola;

import gestorAplicacion.Reserva;

public class ModificarSilla  extends OpcionDeMenu{

	public String Nombre() {
		return "Modificar silla.";
	}
	
	public void Ejecutar() {
		System.out.println("Vuelo a cambiar silla: ");
		int posicion = sc.nextInt();
		Reserva x=MenuDeConsola.usuarioactual.cartera.get(posicion);
		System.out.println(x.getVuelo().toString("sillas"));
		System.out.println("Escoge un nuevo puesto");
		int Npuesto=sc.nextInt();
		MenuDeConsola.usuarioactual.CambiarSilla(x, Npuesto);
		System.out.println("CAMBIO EXITOSO");

	}
}
