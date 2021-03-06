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
/*
 * esta clase se utiliza para ejecutar el programa por consola.
 */
public class Inicio extends MenuDeConsola{
	public String Mensaje() {
		return "AEROLINEA LUNA`S";
	}
	//metodo principal para inicia el programa por consola
	public static void main(String[] args) {
		Inicio inicio = new Inicio();
		MenuCliente menucliente = new MenuCliente();
		//declaracion de elementos varios de inicio
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
		//Reader.Leer();
		
		Admin.premios.add("Silla: ...50");
		Admin.premios.add("Mercado: ...100");
		Admin.premios.add("Olla de arroz:  ...200");
		Admin.premios.add("Computador: ...300");
		Admin.premios.add("Nevera: ...500");
		Admin.premios.add("Viaje gratis: ...800");
		Admin.premios.add("Viaje en pareja: ...1000");
		Admin.premios.add("Viaje Familiar(max 4): ...1200");
		Admin.Reiniciar();
		Timer timer = new Timer();
		TimerTask estadoVuelos =  new TimerTask() {
			public void run() {
				Admin.empleados.get(0).ActualizarVuelos();
			}
		};
		timer.schedule(estadoVuelos, 2000,2000);//cada 1 min
		
		inicio.LanzarMenu();
		
	}
	
}
