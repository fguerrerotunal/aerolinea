package uiMain.menuconsola;

import java.util.Iterator;

import gestorAplicacion.Admin;

public class CanjearMillas  extends OpcionDeMenu{

	public String Nombre() {
		return "Canjear millas.";
	}
	
	public void Ejecutar() {
		Iterator i = Admin.premios.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		
	}

}
