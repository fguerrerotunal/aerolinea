package gestorAplicacion;

import java.util.Date;
import java.util.Iterator;
import java.util.Vector;

public class Empleado extends Persona{
	String ocupacion;
	int puertaAbordaje = 0;
	public static Vector<Vuelo> vuelos = new Vector<>();
	
	Empleado(int identificacion, int cuentabancaria, String nombre, String direccion, String correo, String ocupacion){
		super(identificacion, cuentabancaria, nombre, direccion, correo);
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
		this.historial.add(dateFormat.format(new Date()) + " "+ accion);
	}
	
	static String VuelosDisponibles() {
		String vuelosDisponibles = "(Numero de Vuelo, Precio, Fecha/Hora, Salida-Destino)";
		Iterator i = vuelos.iterator();
		while(i.hasNext()) {
			Vuelo vuelo = (Vuelo)i.next();
			if(vuelo.puestos.length < vuelo.capacidad && vuelo.estado.equals("Venta")) {
				vuelosDisponibles = vuelosDisponibles + "\n" + vuelo.toString("consulta");
			}
		}
		return vuelosDisponibles;
	}

	static String EstadoVuelos() {
		String estadoVuelos = "(Numero de Vuelo, Estado, Puerta de abordaje, Salida-Destino)";
		Iterator i = vuelos.iterator();
		while(i.hasNext()) {
			Vuelo vuelo = (Vuelo)i.next();
			if(!vuelo.estado.equals("Venta")) {
				estadoVuelos = estadoVuelos + "\n" + vuelo.toString("estado");
			}
		}
		return estadoVuelos;
	}

	void NuevoVuelo(String numeroVuelo, Aeropuerto salida, Aeropuerto destino) {
		puertaAbordaje += 1;
		if(puertaAbordaje > 18) {
			puertaAbordaje = 1;
		}
		Date fecha = new Date();
		Empleado.vuelos.add(new Vuelo(numeroVuelo, fecha, destino, salida, puertaAbordaje));
		this.AñadirHistorial("Creacion vuelo "+ numeroVuelo);
	}

	static void ModMillas(Cliente cliente, int precio) {
		cliente.cuentamillas.setMillas(cliente.cuentamillas.getMillas() + precio);
	}
	static String CosultarVuelo(Vuelo vuelo) {
		return "Vuelo:"+vuelo.numeroVuelo+"\n Salida: "+vuelo.salida+"\n Destino: "+vuelo.destino+"\n pasajeros:\n"+Consultarpasajeros(vuelo);
		}
	static String Consultarpasajeros(Vuelo vuelo) {
		String pasajeros="(Nombre,Identificacion)\n";
		Iterator i=vuelo.puestos.iterator();
		while(i.hasNext()) {
			Persona pasajero=(Persona)i.next();
			pasajeros=pasajeros+pasajero.nombre+" "+pasajero.identificacion+"\n";
		}
		return pasajeros;
		
	}
	
	
	}
	
	
