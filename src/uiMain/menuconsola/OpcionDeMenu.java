package uiMain.menuconsola;
import java.util.*;

public abstract class OpcionDeMenu {
	
	Scanner sc = new Scanner(System.in);
	
	public abstract String Nombre();
	
	public abstract void Ejecutar();
	
}
