package uiMain.menuconsola;
import java.util.Timer;
import java.util.TimerTask;
import Basededatos.Reader;
import gestorAplicacion.AtencionAlCliente.Cliente;
//import gestorAplicacion.Master.Admin;
import gestorAplicacion.Master.*;
import uiMain.menuconsola.opcionesdeMenu.Autores;
import uiMain.menuconsola.opcionesdeMenu.CancelarReserva;
import uiMain.menuconsola.opcionesdeMenu.Cartera;
import uiMain.menuconsola.opcionesdeMenu.ComprarTiquete;
import uiMain.menuconsola.opcionesdeMenu.Descripccion;
import uiMain.menuconsola.opcionesdeMenu.HistorialDeVuelo;
import uiMain.menuconsola.opcionesdeMenu.ImprimirPasabordo;
import uiMain.menuconsola.opcionesdeMenu.NuevoRegistro;
import uiMain.menuconsola.opcionesdeMenu.Salir;
import uiMain.menuconsola.opcionesdeMenu.UsuarioRegistrado;
import uiMain.menuconsola.opcionesdeMenu.VuelosDelDia;;

public class Inicio extends MenuDeConsola{
	public String Mensaje() {
		return "AEROLINEA LUNA`S";
	}
	
	public static void main(String[] args) {
		Inicio inicio = new Inicio();
		MenuCliente menucliente = new MenuCliente();

		UsuarioRegistrado usuarioregistrado = new UsuarioRegistrado(menucliente); // listo
		NuevoRegistro nuevoregistro = new NuevoRegistro(); //listo
		Autores autores = new Autores(); 
		Descripccion descripccion = new Descripccion();
		Salir salir = new Salir();  //listo
		ComprarTiquete comprartiquete = new ComprarTiquete();  
		
//		CanjearMillas canjearmillas = new CanjearMillas();   //listo
		HistorialDeVuelo historialdevuelo = new HistorialDeVuelo(); //listo
		Cartera cartera1 = new Cartera();  // listo
		VuelosDelDia vuelos = new VuelosDelDia();  //listo
		ImprimirPasabordo imprimirpasabordo = new ImprimirPasabordo();  //listo
		CancelarReserva cancelarreserva = new CancelarReserva(); // listo
		
		inicio.opciones.add(usuarioregistrado);
		inicio.opciones.add(nuevoregistro);
		inicio.opciones.add(autores);
		inicio.opciones.add(descripccion);
		inicio.opciones.add(salir);
		menucliente.opciones.add(comprartiquete);
		menucliente.opciones.add(historialdevuelo);
		menucliente.opciones.add(cartera1);
		menucliente.opciones.add(vuelos);
		menucliente.opciones.add(imprimirpasabordo);
		menucliente.opciones.add(cancelarreserva);
		menucliente.opciones.add(salir);
		
		//psaa toda la informacion al a base
		Reader.Leer();
		
		Admin.premios.add("Silla: ...50");
		Admin.premios.add("Mercado: ...100");
		Admin.premios.add("Olla de arroz:  ...200");
		Admin.premios.add("Computador: ...300");
		Admin.premios.add("Nevera: ...500");
		Admin.premios.add("Viaje gratis: ...800");
		Admin.premios.add("Viaje en pareja: ...1000");
		Admin.premios.add("Viaje Familiar(max 4): ...1200");
		

/*		Admin.empleados.add(new Empleado(001,212,"Porky","Casa de nariño","porky@colombia.com","Servicios Varios"));
		new Aeropuerto("Jose Maria Córdova","Rionegro","Colombia");
		new Aeropuerto("El Dorado","Bogota","Colombia");
		new Aeropuerto("John F.Kennedy","New York","EEUU");
		new Aeropuerto("Barajas Adolfo Suarez","Madrid","España");
		new Aeropuerto("Pudong","Shanghai","China");
		Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(0), Admin.destinos.get(1));
		Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(0), Admin.destinos.get(2));
		Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(0), Admin.destinos.get(3));
		Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(0), Admin.destinos.get(4));
		Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(1), Admin.destinos.get(0));
		Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(1), Admin.destinos.get(2));
		Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(1), Admin.destinos.get(3));
		Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(1), Admin.destinos.get(4));
		Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(2), Admin.destinos.get(0));
		Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(2), Admin.destinos.get(1));
		Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(2), Admin.destinos.get(3));
		Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(2), Admin.destinos.get(4));
		Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(3), Admin.destinos.get(0));
		Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(3), Admin.destinos.get(1));
		Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(3), Admin.destinos.get(2));
		Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(3), Admin.destinos.get(4));
		Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(4), Admin.destinos.get(0));
		Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(4), Admin.destinos.get(1));
		Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(4), Admin.destinos.get(2));
		Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(4), Admin.destinos.get(3));
		Admin.clientes.add(new Cliente(1,12,"fedrico guerrero", "as5d4","",234));
		*/
		Timer timer = new Timer();
		TimerTask estadoVuelos =  new TimerTask() {
			public void run() {
				Admin.empleados.get(0).ActualizarVuelos();
			}
		};
		timer.schedule(estadoVuelos, 10000,10000);//cada 1 min
		
		inicio.LanzarMenu();
		
	}
	
}
