package gestorAplicacion;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
public class Empleado extends Persona implements Serializable{
	private static final long serialVersionUID = 1L;
	String ocupacion;
	static int puertaAbordaje = 0;
	public static Vector<Vuelo> vuelos = new Vector<>();
	DateFormat dateFormat = new SimpleDateFormat("yyyy-M-dd hh:mm");
	
	public Empleado(int identificacion, int cuentabancaria, String nombre, String direccion, String correo, String ocupacion){
		super(identificacion, cuentabancaria, nombre, direccion, correo);
		this.ocupacion = ocupacion;
	}
	
	public String Historial(){
		Iterator i = historial.iterator();
		String historial = "Historial de acciones del sistema";
		while(i.hasNext()) {
			historial = historial + "\n" + i.next();
		}
		this.AņadirHistorial("Consulta historial de acciones");
		return historial;
	}
	
	public void AņadirHistorial(String accion) {
		this.historial.add(dateFormat.format(Calendar.getInstance()) + " "+ accion);
	}
	//vuelos en venta
	String VuelosDisponibles() {
		String vuelosDisponibles = "\t # Vuelo \tPrecio \t Fecha/Hora \t \tSalida-Destino";
		Iterator i = vuelos.iterator();
		int posicion = 0;
		while(i.hasNext()) {
			Vuelo vuelo = (Vuelo)i.next();
			if(vuelo.estado.equals("Venta")) {
				vuelosDisponibles = vuelosDisponibles + "\n" + posicion +"\t"+vuelo.toString("consulta");
				posicion++;
			}
		}
		return vuelosDisponibles;
	}
	//estado de vuelos del dia 
	String EstadoVuelos() {
		String estadoVuelos = "# Vuelo \t Estado \t Puerta de abordaje \t Salida-Destino";
		Iterator i = vuelos.iterator();
		while(i.hasNext()) {
			Vuelo vuelo = (Vuelo)i.next();
			if(!vuelo.estado.equals("Venta")) {
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
		int r = (int)(Math.random()*(10-5+1)+5);
		fecha.add(Calendar.MINUTE,r);
		Empleado.vuelos.add(new Vuelo(fecha, destino, salida, puertaAbordaje));
		//Empleado.AņadirHistorial("Creacion vuelo "+ numeroVuelo);
	}
	
	public Vuelo NuevoVuelo(Aeropuerto salida, Aeropuerto destino, int a) {
		puertaAbordaje += 1;
		if(puertaAbordaje > 18) {
			puertaAbordaje = 1;
		}
		Calendar fecha = Calendar.getInstance();
		int r = (int)(Math.random()*(10-5+1)+5);
		fecha.add(Calendar.MINUTE,r);
		return new Vuelo(fecha, destino, salida, puertaAbordaje);
	}

	void ModMillas(Cliente cliente, int precio) {
		cliente.cuentamillas.setMillas(cliente.cuentamillas.getMillas() + precio);
	}
	
	String CosultarVuelo(Vuelo vuelo) {
		return "Vuelo:"+vuelo.numeroVuelo+"\n Salida: "+vuelo.salida+"\n Destino: "+vuelo.destino+"\n pasajeros:\n"+Consultarpasajeros(vuelo);
		}
	
	String Consultarpasajeros(Vuelo vuelo) {
		String pasajeros="(Nombre,Identificacion)\n";
		for(int i = 0;i<20;i++) {
			Persona pasajero = vuelo.puestos[i].pasajero;
			pasajeros=pasajeros+pasajero.nombre+" "+pasajero.identificacion+"\n";
		}
		return pasajeros;
		
	}
	
	public void ActualizarVuelos() {
		Vector<Integer> posiciones = new Vector<>();
		Iterator<Vuelo> i = vuelos.iterator();
		while(i.hasNext()) {
			Vuelo x = i.next();
			switch (x.estado) {
			case "Venta":
				x.estado = "Abordaje";
				break;
			case "Abordaje":
				int azar = (int)(Math.random() * 10);
				if(azar >= 5) {
					x.estado = "Despego";
				}else {
					x.estado = "Retrasado";
				}
				break;
			case "Retrasado":
				int azarremaster = (int)(Math.random() * 10);
				if(azarremaster >= 2) {
					x.estado = "Despego";
				}
				break;
			case "Despego":
				x.estado = "Volando";
				break;
			case "Volando":
				x.estado = "Aterrizo";
<<<<<<< HEAD
				break;
			case "Aterrizo":
				x.finalizer();
				x.estado="Venta";
				
=======
				posiciones.add(x.finalizer());
>>>>>>> 08658374e0e0b65a278b7d8dbb6878de0d8aa2b1
				break;
//			case "Aterrizo":
//				posiciones.add(x.finalizer());
//				break;
			}
<<<<<<< HEAD
		}	
=======
		}
		Iterator<Integer> a = posiciones.iterator();
		while(a.hasNext()) {
			int x = a.next();
			Vuelo aux = vuelos.get(x);
			Vuelo vuelo = Admin.empleados.get(0).NuevoVuelo(aux.salida, aux.destino , 0);
			vuelos.set(x, vuelo);
		}
		
>>>>>>> 08658374e0e0b65a278b7d8dbb6878de0d8aa2b1
	}
		
}
	
	
	
	
	
