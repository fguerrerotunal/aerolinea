import java.util.*;
public class Vuelo {
	static int cantidadVuelos;
	Reserva puestos;
	String numeroVuelo;
	int precioTiquete;
	Date fecha;
	Aeropuerto destino;
	Aeropuerto salida;
	String estado;
	int capacidad;
	int max = 15;
	int min = 5;
	int puertaAbordaje;
	
	Vuelo(String numeroVuelo, Date fecha, Aeropuerto destino, Aeropuerto salida, int puertaAbordaje){
		cantidadVuelos += 1;
		capacidad = (int)(Math.random() + (max - min + 1)+min);
		Vector<Reserva> Puestos = new Vector<Reserva>();
		precioTiquete = capacidad*12500;
		estado = "Venta";
		this.numeroVuelo = numeroVuelo;
		this.fecha = fecha;
		this.salida = salida;
		this.destino= destino;
		this.puertaAbordaje = puertaAbordaje;
	}
	
	
	
}
