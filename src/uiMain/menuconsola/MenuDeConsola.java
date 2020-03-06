package uiMain.menuconsola;

import java.util.*;

import gestorAplicacion.Cliente;

public abstract class MenuDeConsola {
	Vector<OpcionDeMenu> opciones = new Vector<>();
	static Cliente usuarioactual = new Cliente(0,0,"f","f","f",0);
	Scanner sc = new Scanner(System.in);
	public abstract String Mensaje();

	public void LanzarMenu() {
		
		int posicion = 0;
		
		do{
			System.out.println("");
			System.out.println("===============================================================================================================================================");
			Iterator i = opciones.iterator();
			System.out.println(this.Mensaje());
			if(this instanceof MenuCliente) {
				System.out.print("\nSALDO CUENTA MILLAS: ");
				System.out.println(usuarioactual.cuentamillas.getMillas());
			}
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