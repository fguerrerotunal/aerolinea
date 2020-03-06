package uiMain.menuconsola;

public class Pagar extends OpcionDeMenu{
	public String Nombre() {
		return "Pagar.";
	}
	
	public void Ejecutar() {
		if(MenuDeConsola.usuarioactual.Deuda()!=0) {
			System.out.println("¿Que medio de pago desea usar?\nEfectivo = 0\tMillas = 1");
			int medio = sc.nextInt();
			System.out.println(MenuDeConsola.usuarioactual.Pago(medio));
		}
		else {
			System.out.println("Usted no tiene deudas");
		}
	}
}
