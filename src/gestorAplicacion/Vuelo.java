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
	int puertaAbordaje;

	Vuelo(String numeroVuelo, Date fecha, Aeropuerto destino, Aeropuerto salida, int puertaAbordaje){
		cantidadVuelos += 1;
		capacidad = (int)(Math.random() * (15-5)+5);
		precioTiquete = capacidad*12500;
		estado = "Venta";
		this.numeroVuelo = numeroVuelo;
		this.fecha = fecha;
		this.salida = salida;
		this.destino= destino;
		this.puertaAbordaje = puertaAbordaje;
	}
	
	String toString(String tipo) {
		String info = "";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm"); 
		switch (tipo) {
		case "consulta":
			String recorrido = this.salida.getCiudad() + this.destino.getCiudad();
			info = info + (String) numeroVuelo +"    "+ Integer.toString(precioTiquete) +"    "+ dateFormat.format(fecha) +"    "+ recorrido;
			break;
		case "pasabordo":
			info = "VUELO: " + numeroVuelo +"\n"+
					"EN SALA: " + dateFormat.format(fecha)+ "\n"+
					"PUERTA DE ABORAJE: " + puertaAbordaje + "\n" +
					"ORIGEN: " + salida + "\n"+
					"DESTINO: " + destino;
			break;
		}
		return info;
	}
	
}
