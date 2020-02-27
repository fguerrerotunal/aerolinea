package uiMain.menuconsola;

public class Atras  extends OpcionDeMenu{
	
	MenuDeConsola sigMenu;
	
	Atras(MenuDeConsola sigMenu){
		this.sigMenu = sigMenu;
	}
	
	public String Nombre() {
		return "Atras.";
	}
	
	public void Ejecutar() {
		this.sigMenu.LanzarMenu();
	}
}
