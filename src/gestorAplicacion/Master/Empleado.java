package gestorAplicacion.Master;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import gestorAplicacion.AtencionAlCliente.Cliente;
import gestorAplicacion.AtencionAlCliente.Persona;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
public class Empleado extends Persona{
	private String ocupacion;
	static int puertaAbordaje = 0;
	public static Vector<Vuelo> vuelos = new Vector<>();
	
	
	public Empleado(int identificacion, int cuentabancaria, String nombre, String direccion, String correo, String ocupacion){
		super(identificacion, cuentabancaria, nombre, direccion, correo);
		this.ocupacion = ocupacion;
	}
	
	public String getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public String Historial(){
		Iterator i = historial.iterator();
		String historial = "Historial de acciones del sistema";
		while(i.hasNext()) {
			historial = historial + "\n" + i.next();
		}
		this.AñadirHistorial("Consulta historial de acciones");
		return historial;
	}
	
	public void AñadirHistorial(String accion) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-M-dd hh:mm");
		this.historial.add(dateFormat.format(Calendar.getInstance()) + " "+ accion);
	}
	//vuelos en venta
	public String VuelosDisponibles() {
		String vuelosDisponibles = "\t # Vuelo \tPrecio \t Fecha/Hora \t \tSalida-Destino";
		Iterator i = vuelos.iterator();
		int posicion = 0;
		while(i.hasNext()) {
			Vuelo vuelo = (Vuelo)i.next();
			if(vuelo.getEstado().equals("Venta")) {
				vuelosDisponibles = vuelosDisponibles + "\n" + posicion +"\t"+vuelo.toString("consulta");
				posicion++;
			}
		}
		return vuelosDisponibles;
	}
	
	public String EstadoVuelos() {
		String estadoVuelos = "# Vuelo \t Estado \t Puerta de abordaje \t Salida-Destino";
		Iterator i = vuelos.iterator();
		while(i.hasNext()) {
			Vuelo vuelo = (Vuelo)i.next();
			if(!vuelo.getEstado().equals("Venta")) {
				estadoVuelos = estadoVuelos + "\n" + vuelo.toString("estado");
			}
		}
		return estadoVuelos;
	}

	public void NuevoVuelo(Aeropuerto salida, Aeropuerto destino) {
		puertaAbordaje += 1;
		if(puertaAbordaje > 18) {
			puertaAbordaje = 1;
		}
		Calendar fecha = Calendar.getInstance();
		fecha.add(Calendar.MINUTE,2);
		Empleado.vuelos.add(new Vuelo(fecha, destino, salida, puertaAbordaje));
	}

	public void ModMillas(Cliente cliente, int precio) {
		cliente.getCuentamillas().setMillas(cliente.getCuentamillas().getMillas() + precio);
	}
	
	String CosultarVuelo(Vuelo vuelo) {
		return "Vuelo:"+vuelo.getNumeroVuelo()+"\n Salida: "+vuelo.getSalida()+"\n Destino: "+vuelo.getDestino()+"\n pasajeros:\n"+Consultarpasajeros(vuelo);
		}
	
	String Consultarpasajeros(Vuelo vuelo) {
		String pasajeros="(Nombre,Identificacion)\n";
		for(int i = 0;i<20;i++) {
			Persona pasajero = vuelo.getPuestos()[i].getPasajero();
			pasajeros=pasajeros+pasajero.getNombre()+" "+pasajero.getIdentificacion()+"\n";
		}
		return pasajeros;
		
	}
	
	public void ActualizarVuelos() {
		Iterator<Vuelo> i = vuelos.iterator();
		while(i.hasNext()) {
			Vuelo x = i.next();
			switch (x.getEstado()) {
			case "Venta":
				x.setEstado("Abordaje");
				break;
			case "Abordaje":
				int azar = (int)(Math.random() * 10);
				if(azar >= 5) {
					x.setEstado("Despego");
				}else {
					x.setEstado("Retrasado");
				}
				break;
			case "Retrasado":
				int azarremaster = (int)(Math.random() * 10);
				if(azarremaster >= 2) {
					x.setEstado("Despego");
				}
				break;
			case "Despego":
				x.setEstado("Volando");
				break;
			case "Volando":
				x.setEstado("Aterrizo");
				break;
			case "Aterrizo":
				x.finalizer();
				x.setEstado("Venta");
			
			}
		}	
	}
		
}
	
	
	
	
	
