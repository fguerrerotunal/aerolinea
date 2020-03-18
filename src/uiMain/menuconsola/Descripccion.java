package uiMain.menuconsola;

public class Descripccion extends OpcionDeMenu{

	@Override
	public String Nombre() {
		String nombre = "Descripccion.";
		return nombre;
	}

	@Override
	public void Ejecutar() {
		System.out.println("bla bla bla");
	}
}
