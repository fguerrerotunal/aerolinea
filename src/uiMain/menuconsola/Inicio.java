package uiMain.menuconsola;
import java.util.Timer;
import java.util.TimerTask;
import Basededatos.Reader;
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
		
		//Reader.Leer();
		
		Admin.empleados.add(new Empleado(001,212,"Porky","Casa de nariño","porky@colombia.com","Servicios Varios"));
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
		Admin.clientes.add(new Cliente(1,1,"Guzman","Universidad nacional","gmaz@unalmail.com",1));
		Timer timer = new Timer();
		TimerTask estadoVuelos =  new TimerTask() {
			public void run() {
				Admin.empleados.get(0).ActualizarVuelos();
			}
		};
		timer.schedule(estadoVuelos,0, 30000);//cada 3 min
		
		inicio.LanzarMenu();
		
	}
}
