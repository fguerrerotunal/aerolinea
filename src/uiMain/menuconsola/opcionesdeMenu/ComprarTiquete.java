package uiMain.menuconsola.opcionesdeMenu;

import java.util.Iterator;

import gestorAplicacion.AtencionAlCliente.Reserva;
import gestorAplicacion.Master.Admin;
import gestorAplicacion.Master.Empleado;
import gestorAplicacion.Master.Vuelo;
import uiMain.menuconsola.MenuDeConsola;
import uiMain.menuconsola.OpcionDeMenu;

public class ComprarTiquete  extends OpcionDeMenu{

	public String Nombre() {
		return "Comprar tiquete.";
	}
	
	public void Ejecutar() {
		Boolean imp = false;
		Iterator i = Empleado.vuelos.iterator();
		while(i.hasNext()) {
			if(((Vuelo) i.next()).getEstado().equals("Venta")) {
				imp = true;
				break;
			}
		}
		if(imp==true) {
			System.out.println(MenuDeConsola.usuarioactual.ConsultarVuelos());
			
			System.out.println("Seleccione un vuelo: ");
			int vuelo = sc.nextInt();
			
			System.out.println("ESTA ACCION TIENE UN COSTO DE: "+Empleado.vuelos.get(vuelo).getPrecioTiquete()+"\n¿DESEA CONTINUAR?\nSI=0    NO=1");
			int continuar = sc.nextInt();
			String verificacion = (MenuDeConsola.usuarioactual.Reservar(Empleado.vuelos.get(vuelo)));
			System.out.println(verificacion);
			System.out.println("");
			Reserva reserva = MenuDeConsola.usuarioactual.cartera.get(MenuDeConsola.usuarioactual.cartera.size()-1);
			System.out.println(MenuDeConsola.usuarioactual.Pasabordo(reserva));
			System.out.println("");
			if(continuar==0 && verificacion.equals("VUELO RESERVADO SATISFACTORIAMENTE")) {	
				System.out.println("¿DESEA MODIFICAR SU ASIENTO? \n ESTA ACCION TIENE UN COSTO DE: 45000\nSI =0	NO =1");
				int camsilla = sc.nextInt();
				if(camsilla == 0){
					System.out.println(reserva.getVuelo().toString("sillas"));
					System.out.println("ESCOGE UN NUEVO PUESTO");
					int Npuesto=sc.nextInt();
					System.out.println(MenuDeConsola.usuarioactual.CambiarSilla(reserva, Npuesto));
				}
				System.out.println("¿DESEA RETIRAR EL LIMITE DE PESO EN SU EQUIPAJE? \n ESTA ACCION TIENE UN COSTO DE: 30000\nSI =0	NO =1");
				int camequipaje = sc.nextInt();
				if(camequipaje == 0){
					reserva.setEquipaje();
				}
				System.out.println("¿Que medio de pago desea usar?\nEfectivo = 0\tMillas = 1");
				int medio = sc.nextInt();
				System.out.println(MenuDeConsola.usuarioactual.Pago(medio,reserva));
				
			}else {
				System.out.println("OPERACON CANCELADA");
			}
		}else {
			Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(0), Admin.destinos.get(Admin.destinos.size()-1));
			Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(1), Admin.destinos.get(Admin.destinos.size()-2));
			this.Ejecutar();
		}
		
	}

}
