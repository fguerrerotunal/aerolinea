package gestorAplicacion;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
public class Vuelo {
	static int cantidadVuelos;
	Vector<Reserva> puestos = new Vector<Reserva>();
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
		precioTiquete = capacidad*12500;
		estado = "Venta";
		this.numeroVuelo = numeroVuelo;
		this.fecha = fecha;
		this.salida = salida;
		this.destino= destino;
		this.puertaAbordaje = puertaAbordaje;
		Empleado.vuelos.add(this);
	}
	
	String toString(String tipo) {
		String info = "";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss"); 
		switch (tipo) {
		case "consulta":
			String recorrido = this.salida.getCiudad() + this.destino.getCiudad();
			info = info + (String) numeroVuelo +"    "+ Integer.toString(precioTiquete) +"    "+ dateFormat.format(fecha) +"    "+ recorrido;
			break;
		}
		return info;
	}
	
}
