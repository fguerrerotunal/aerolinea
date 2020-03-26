package uiMain.menuconsola;
import java.util.*;
/* 
 * esta es la clase padre de las opciones de menu.
 */
public abstract class OpcionDeMenu {
	
	protected Scanner sc = new Scanner(System.in);
	
	public abstract String Nombre();
	
	public abstract void Ejecutar();
	
}
