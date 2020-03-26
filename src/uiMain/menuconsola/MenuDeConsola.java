package uiMain.menuconsola;

import java.util.*;

import gestorAplicacion.AtencionAlCliente.Cliente;
/*
 * Esta clase es el menu generico de consola el cual se ejecuta al iniciar el programa y le muestra al usuario diferentes opciones
 */
public abstract class MenuDeConsola {
	
	Vector<OpcionDeMenu> opciones = new Vector<>();
	public static Cliente usuarioactual;
	Scanner sc = new Scanner(System.in);
	
	public abstract String Mensaje();

	public void LanzarMenu() {
		
		int posicion = 0;
		
		do{
			System.out.println("");
			System.out.println("===============================================================================================================================================");
			System.out.println(this.Mensaje());
			System.out.println("");
			Iterator i = opciones.iterator();
		
			while(i.hasNext()) {
				OpcionDeMenu opcion = (OpcionDeMenu) i.next();
				System.out.println(posicion+". "+opcion.Nombre());
				posicion++;
			}
			System.out.println("");
			System.out.println("Digite la opcion deseada: ");
			posicion = sc.nextInt();
			this.opciones.get(posicion).Ejecutar();
			posicion =0;
		}while(true);
	}
}
