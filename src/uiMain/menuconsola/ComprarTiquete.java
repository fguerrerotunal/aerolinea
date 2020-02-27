package uiMain.menuconsola;

import gestorAplicacion.Empleado;

public class ComprarTiquete  extends OpcionDeMenu{

	public String Nombre() {
		return "Comprar tiquete.";
	}
	
	public void Ejecutar() {
		System.out.println(MenuDeConsola.usuarioactual.ConsultarVuelos());
		System.out.println("Seleccione un vuelo: ");
		int vuelo = sc.nextInt();
		MenuDeConsola.usuarioactual.Reservar(Empleado.vuelos.get(vuelo));
		System.out.println("VUELO RESERVADO SATISFACTORIAMENTE");
	}

}
