package gestorAplicacion;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
public class Vuelo {
	static int cantidadVuelos;
	Reserva[] puestos = new Reserva[20];
	String numeroVuelo;
	int precioTiquete;
	Date fecha;
	Aeropuerto destino;
	Aeropuerto salida;
	String estado;
	int capacidad;
	int puertaAbordaje;
	DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm");
	
	Vuelo(String numeroVuelo, Date fecha, Aeropuerto destino, Aeropuerto salida, int puertaAbordaje){
		cantidadVuelos += 1;
		capacidad = 20;
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
		String recorrido = this.salida.getCiudad() + this.destino.getCiudad();
		
		switch (tipo) {
		case "consulta":
			info = info + (String) numeroVuelo +"    "+ Integer.toString(precioTiquete) +"    "+ dateFormat.format(fecha) +"    "+ recorrido;
			break;
		case "pasabordo":
			info = "VUELO: " + numeroVuelo +"\n"+
					"EN SALA: " + dateFormat.format(fecha)+ "\n"+
					"PUERTA DE ABORAJE: " + puertaAbordaje + "\n" +
					"ORIGEN: " + salida + "\n"+
					"DESTINO: " + destino;
			break;
		
		case "estado":
			info = info + (String) numeroVuelo +"    "+ estado +"    "+ puertaAbordaje +"    "+ recorrido;
			break;
		
		case "sillas":
			String a;
			for(int i = 0; i < 20; i++) {
				if(puestos[i] == null) {
					a = "[PUESTO: " + i + " LIBRE ]" ;
				}
				else {
					a = "[PUESTO: " + i + " OCUPADO ]" ;
				}
				info = info + a;
				if(i == 4 || i == 9 || i == 14 || i == 19) {
					info = info + "\n";
				}
				if(i == 9) {
					info = info + "=============================================" + "\n";
				}
			}
			break;
			
		}
	
		return info;
	}

	public void finalize() {
	
	}
}
