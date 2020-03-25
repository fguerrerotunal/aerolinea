package gestorAplicacion.Master;
import java.util.*;

import gestorAplicacion.AtencionAlCliente.Reserva;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Vuelo{
//Atributos de los objetos de tipo Clase Vuelo
	static int cantidadVuelos = Empleado.vuelos.size();
	private transient Reserva[] puestos = new Reserva[20];
	private int numeroVuelo;
	private int precioTiquete;
	private String fecha;
	private Aeropuerto destino;
	private Aeropuerto salida;
	private String estado = "Venta";
	private int puertaAbordaje;	
	
//Constructor de vuelo
	Vuelo(Calendar fecha, Aeropuerto destino, Aeropuerto salida, int puertaAbordaje){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-M-dd hh:mm");
		cantidadVuelos++;
		this.numeroVuelo = cantidadVuelos;
		precioTiquete = ((int)(Math.random()*(500000-125000+1)+125000));
		this.fecha = String.valueOf(dateFormat.format(fecha.getTime()));
		this.estado="Venta";
		this.salida = salida;
		this.destino= destino;
		this.puertaAbordaje = puertaAbordaje;
	}	
	//Getters Y setters de la clase vuelo
	public Reserva[] getPuestos() {
		return puestos;
	}



	public void setPuestos(Reserva[] puestos) {
		this.puestos = puestos;
	}



	public int getNumeroVuelo() {
		return numeroVuelo;
	}



	public void setNumeroVuelo(int numeroVuelo) {
		this.numeroVuelo = numeroVuelo;
	}



	public int getPrecioTiquete() {
		return precioTiquete;
	}



	public void setPrecioTiquete(int precioTiquete) {
		this.precioTiquete = precioTiquete;
	}
	public Aeropuerto getDestino() {
		return destino;
	}



	public void setDestino(Aeropuerto destino) {
		this.destino = destino;
	}



	public Aeropuerto getSalida() {
		return salida;
	}



	public void setSalida(Aeropuerto salida) {
		this.salida = salida;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}



	public int getPuertaAbordaje() {
		return puertaAbordaje;
	}



	public void setPuertaAbordaje(int puertaAbordaje) {
		this.puertaAbordaje = puertaAbordaje;
	}

//Retorna la fecha del vuelo
	public Calendar getFecha() {
		String[] fechArray = fecha.split("-");
		int dia = Integer.valueOf(fechArray[0]);
		int mes = Integer.valueOf(fechArray[1]) - 1;
		int anio = Integer.valueOf(fechArray[2]);
		Calendar c1 = new GregorianCalendar(anio, mes, dia);
		return c1;
	}
	public String getFechaString() {
		return this.fecha;
	}


///asigna fecha al vuelo
	public void setFecha(Calendar fecha) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-M-dd hh:mm");
		this.fecha = String.valueOf(dateFormat.format(fecha.getTime()));
	}
//devuelve dependiendo el tipo de String que se le de un resultado del vuelo
	public String toString(String tipo) {
		
		String info = "";
		String recorrido = this.salida.getCiudad() +"-"+ this.destino.getCiudad();
		
		switch (tipo) {
		case "consulta":
			info = info + Integer.toString(numeroVuelo) +"\t \t"+ Integer.toString(precioTiquete) +"\t "+ fecha +"\t"+ recorrido;
			break;
		case "pasabordo":
			info = "VUELO: " + numeroVuelo +"\n"+
					"EN SALA: " + fecha + "\n"+
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
//finalizer se encarga de resetear los vuelos para poder utilizarlos 
	public void finalizer() {
		for(int i = 0;i<20;i++){ 
			if(this.puestos[i]!=null){
				this.puestos[i].getPasajero().AñadirHistorial(this.toString("consulta"));
				this.puestos[i].getPasajero().cartera.remove(this.puestos[i]);
				this.puestos[i]=null;
			}
		}
		DateFormat dateFormat = new SimpleDateFormat("yyyy-M-dd hh:mm");
		cantidadVuelos += 1;
		this.numeroVuelo =cantidadVuelos;
		this.precioTiquete = ((int)(Math.random()*(500000-125000+1)+125000));
		Calendar fecha = Calendar.getInstance();
		fecha.add(Calendar.MINUTE,(int)Math.random()*(4-2+1)+2);
		this.fecha = String.valueOf(dateFormat.format(fecha.getTime()));
		this.estado="Venta";
		
		
	}

}