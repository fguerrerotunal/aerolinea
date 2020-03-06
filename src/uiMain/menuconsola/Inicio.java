package uiMain.menuconsola;
import java.util.Timer;
import java.util.TimerTask;
import Basededatos.Reader;
import gestorAplicacion.AtencionAlCliente.Cliente;
import gestorAplicacion.Master.Admin;
import gestorAplicacion.Master.Aeropuerto;
import gestorAplicacion.Master.Empleado;

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
		menucliente.opciones.add(salir);
		menucartera.opciones.add(cartera1);
		menucartera.opciones.add(modificarsilla);
		menucartera.opciones.add(modificarequipaje);
		menucartera.opciones.add(imprimirpasabordo);
		menucartera.opciones.add(cancelarreserva);
		menucartera.opciones.add(atras);
		//psaa toda la informacion al a base
		Reader.Leer();
		
		//Admin.empleados.add(new Empleado(001,212,"Porky","Casa de nariño","porky@colombia.com","Servicios Varios"));
		//new Aeropuerto("Jose Maria Córdova","Rionegro","Colombia");
		//new Aeropuerto("El Dorado","Bogota","Colombia");
		//new Aeropuerto("John F.Kennedy","New York","EEUU");
		//new Aeropuerto("Barajas Adolfo Suarez","Madrid","España");
		//new Aeropuerto("Pudong","Shanghai","China");
		Admin.premios.add("Silla: ...50");
		Admin.premios.add("Mercado: ...100");
		Admin.premios.add("Olla de arroz:  ...200");
		Admin.premios.add("Computador: ...300");
		Admin.premios.add("Nevera: ...500");
		Admin.premios.add("Viaje gratis: ...800");
		Admin.premios.add("Viaje en pareja: ...1000");
		Admin.premios.add("Viaje Familiar(max 4): ...1200");

		//Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(0), Admin.destinos.get(1));
		//Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(0), Admin.destinos.get(2));
		//Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(0), Admin.destinos.get(3));
		//Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(0), Admin.destinos.get(4));
		//Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(1), Admin.destinos.get(0));
		//Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(1), Admin.destinos.get(2));
		//Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(1), Admin.destinos.get(3));
		//Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(1), Admin.destinos.get(4));
		//Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(2), Admin.destinos.get(0));
		//Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(2), Admin.destinos.get(1));
		//Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(2), Admin.destinos.get(3));
		//Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(2), Admin.destinos.get(4));
		//Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(3), Admin.destinos.get(0));
		//Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(3), Admin.destinos.get(1));
		//Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(3), Admin.destinos.get(2));
		//Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(3), Admin.destinos.get(4));
		//Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(4), Admin.destinos.get(0));
		//Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(4), Admin.destinos.get(1));
		//Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(4), Admin.destinos.get(2));
		//Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(4), Admin.destinos.get(3));
		Timer timer = new Timer();
		TimerTask estadoVuelos =  new TimerTask() {
			public void run() {
				Admin.empleados.get(0).ActualizarVuelos();
			}
		};
		timer.schedule(estadoVuelos, 60000,60000);//cada 1 min
		
		inicio.LanzarMenu();
		
	}
}
