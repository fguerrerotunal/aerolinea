package gestorAplicacion;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
public class Vuelo {
	static int cantidadVuelos = 0;
	Reserva[] puestos = new Reserva[20];
	int numeroVuelo;
	int precioTiquete;
	Date fecha;
	Aeropuerto destino;
	Aeropuerto salida;
	String estado;
	int capacidad;
	int puertaAbordaje;
	DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm");
	
	Vuelo(Date fecha, Aeropuerto destino, Aeropuerto salida, int puertaAbordaje){
		cantidadVuelos += 1;
		this.numeroVuelo = cantidadVuelos;
		capacidad = 20;
		precioTiquete = capacidad*12500;
		estado = "Venta";
		this.fecha = fecha;
		this.salida = salida;
		this.destino= destino;
		this.puertaAbordaje = puertaAbordaje;
	}
	
	
	String toString(String tipo) {
		String info = "";
		String recorrido = this.salida.getCiudad() +"-"+ this.destino.getCiudad();
		
		switch (tipo) {
		case "consulta":
			info = info + Integer.toString(numeroVuelo) +"    "+ Integer.toString(precioTiquete) +"    "+ dateFormat.format(fecha) +"    "+ recorrido;
			break;
		case "pasabordo":
			info = "VUELO: " + numeroVuelo +"\n"+
					"EN SALA: " + dateFormat.format(fecha)+ "\n"+
					"PUERTA DE ABORAJE: " + puertaAbordaje + "\n" +
					"ORIGEN: " + salida + "\n"+
					"DESTINO: " + destino;
			break;
		
		case "estado":
			info = info + Integer.toString(numeroVuelo) +"    "+ estado +"    "+ puertaAbordaje +"    "+ recorrido;
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
		for(int i = 0;i<20;i++) {
			Cliente pasajero = this.puestos[i].pasajero;
			Reserva reserva = this.puestos[i];
			pasajero.AñadirHistorial(this.toString("consulta"));
			Admin.empleados.get(0).ModMillas(pasajero, this.precioTiquete/2);
			pasajero.cartera.remove(reserva);
			Empleado.vuelos.remove(this);
			Admin.empleados.get(0).NuevoVuelo(this.salida, this.destino);
		}
	}
}
