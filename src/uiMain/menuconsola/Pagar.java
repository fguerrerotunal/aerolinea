package uiMain.menuconsola;

public class Pagar extends OpcionDeMenu{
	public String Nombre() {
		return "Pagar.";
	}
	
	public void Ejecutar() {
		System.out.println("¿Que medio de pago desea usar?");
		String medio = sc.next();
		System.out.println(MenuDeConsola.usuarioactual.Pago(medio));
	}
}
