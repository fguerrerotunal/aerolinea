package uiMain.menuconsola;
import java.util.Timer;
import java.util.TimerTask;

import gestorAplicacion.Admin;
import gestorAplicacion.Aeropuerto;
import gestorAplicacion.Cliente;
import gestorAplicacion.Empleado;

public class Inicio extends MenuDeConsola{
	public String Mensaje() {
		return "AEROLINEA LUNA`S";
	}
	public static void main(String[] args) {
		
		Inicio inicio = new Inicio();
		MenuCliente menucliente = new MenuCliente();
		MenuCartera menucartera = new MenuCartera();
		
		UsuarioRegistrado usuarioregistrado = new UsuarioRegistrado(menucliente); // listo
		NuevoRegistro nuevoregistro = new NuevoRegistro(); //listo
		VuelosDelDia vuelos = new VuelosDelDia();  //listo
		Salir salir = new Salir();  //listo
		ComprarTiquete comprartiquete = new ComprarTiquete();  //listo
		CanjearMillas canjearmillas = new CanjearMillas();   //listo
		HistorialDeVuelo historialdevuelo = new HistorialDeVuelo(); //listo
		Cartera cartera = new Cartera(menucartera);  //listo
		Pagar pagar = new Pagar(); // listo
		Cartera cartera1 = new Cartera();  // listo
		ModificarSilla modificarsilla = new ModificarSilla(); //listo
		ModificarEquipaje modificarequipaje = new ModificarEquipaje(); //listo
		ImprimirPasabordo imprimirpasabordo = new ImprimirPasabordo();  //listo
		CancelarReserva cancelarreserva = new CancelarReserva(); // listo
		Atras atras = new Atras(menucliente);  //listo
		
		inicio.opciones.add(usuarioregistrado);
		inicio.opciones.add(nuevoregistro);
		inicio.opciones.add(vuelos);
		inicio.opciones.add(salir);
		menucliente.opciones.add(comprartiquete);
		menucliente.opciones.add(canjearmillas);
		menucliente.opciones.add(historialdevuelo);
		menucliente.opciones.add(cartera);
		menucliente.opciones.add(vuelos);
		menucliente.opciones.add(pagar);
		menucliente.opciones.add(salir);
		menucartera.opciones.add(cartera1);
		menucartera.opciones.add(modificarsilla);
		menucartera.opciones.add(modificarequipaje);
		menucartera.opciones.add(imprimirpasabordo);
		menucartera.opciones.add(cancelarreserva);
		menucartera.opciones.add(atras);
		Admin.empleados.add(new Empleado(1,1,"f","f","f","f"));
		new Aeropuerto("a","a","a");
		new Aeropuerto("b","b","b");
		Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(0), Admin.destinos.get(1));
		Admin.clientes.add(new Cliente(1,1,"porky","p","p",1));
		Timer timer = new Timer();
		TimerTask estadoVuelos =  new TimerTask() {
			public void run() {
				Admin.empleados.get(0).ActualizarVuelos();
			}
		};
		timer.schedule(estadoVuelos,30000, 30000);//cada 3 min
		
		inicio.LanzarMenu();
		
	}
}
