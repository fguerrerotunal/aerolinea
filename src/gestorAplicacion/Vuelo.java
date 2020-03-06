package gestorAplicacion;
import java.util.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
public class Vuelo  implements Serializable {
	private static final long serialVersionUID = 1L;
	static int cantidadVuelos = 0;
	Reserva[] puestos = new Reserva[20];
	int numeroVuelo;
	public int precioTiquete;
	Calendar fecha;
	Aeropuerto destino;
	Aeropuerto salida;
	public String estado = "Venta";
	final int capacidad = 20;
	int puertaAbordaje;
	DateFormat dateFormat = new SimpleDateFormat("yyyy-M-dd hh:mm");
	
	Vuelo(Calendar fecha, Aeropuerto destino, Aeropuerto salida, int puertaAbordaje){
		cantidadVuelos += 1;
		this.numeroVuelo = cantidadVuelos;
		precioTiquete = ((int)(Math.random()*(500000-125000+1)+125000));
		this.fecha = fecha;
		this.estado="Venta";
		this.salida = salida;
		this.destino= destino;
		this.puertaAbordaje = puertaAbordaje;
	}
	
	
	public String toString(String tipo) {
		String info = "";
		String recorrido = this.salida.getCiudad() +"-"+ this.destino.getCiudad();
		
		switch (tipo) {
		case "consulta":
			info = info + Integer.toString(numeroVuelo) +"\t \t"+ Integer.toString(precioTiquete) +"\t "+ dateFormat.format(fecha.getTime()) +"\t"+ recorrido;
			break;
		case "pasabordo":
			info = "VUELO: " + numeroVuelo +"\n"+
					"EN SALA: " + dateFormat.format(fecha.getTime()) + "\n"+
					"PUERTA DE ABORAJE: " + puertaAbordaje + "\n" +
					"ORIGEN: " + salida.getCiudad() + "\n"+
					"DESTINO: " + destino.getCiudad() + "\n";
			break;
									
		case "estado":
			info = info + Integer.toString(numeroVuelo) +"\t \t"+ estado +"    \t  \t"+ puertaAbordaje +"\t \t "+ recorrido;
			break;
		
		case "sillas":
			String a;
			for(int i = 0; i < 20; i++) {
				if(puestos[i] == null) {
					a = "[PUESTO: " + (Integer.valueOf(i)+Integer.valueOf(1)) + " LIBRE ]" ;
				}
				else {
					a = "[PUESTO: " + i+1 + " OCUPADO ]" ;
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

	public int finalizer() {
		for(int i = 0;i<20;i++) {
			if(this.puestos[i]!=null) {
			Cliente pasajero = this.puestos[i].pasajero;
			Reserva reserva = this.puestos[i];
			this.puestos[i].pasajero.AñadirHistorial(this.toString("consulta"));
			Admin.empleados.get(0).ModMillas(this.puestos[i].pasajero, this.precioTiquete/2);
			this.puestos[i].pasajero.cartera.remove(reserva);
			}
		}
		return Empleado.vuelos.indexOf(this);
	}
}
