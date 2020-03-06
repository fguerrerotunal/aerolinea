package uiMain.menuconsola;

public class Cartera  extends OpcionDeMenu{

	MenuDeConsola sigmenu;
	
	Cartera(){
	}
	
	Cartera(MenuDeConsola sigmenu){
		this.sigmenu=sigmenu;
	}
	
	public String Nombre() {
		return "Cartera.";
	}
	
	public void Ejecutar() {
		System.out.println(MenuDeConsola.usuarioactual.Cartera());
		if(!MenuDeConsola.usuarioactual.cartera.isEmpty()&&sigmenu!=null) {
			sigmenu.LanzarMenu();
		}
	}
}
