package uiMain.menuconsola;

public class Pagar extends OpcionDeMenu{
	public String Nombre() {
		return "Pagar.";
	}
	
	public void Ejecutar() {
		System.out.println("¿Que medio de pago desea usar?\nEfectivo = 0\tMillas = 1");
		int medio = sc.nextInt();
		System.out.println(MenuDeConsola.usuarioactual.Pago(medio));
	}
}
