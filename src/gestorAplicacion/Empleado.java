package gestorAplicacion;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class Empleado extends Persona{
	String ocupacion;
	static int puertaAbordaje = 0;
	public static Vector<Vuelo> vuelos = new Vector<>();
	
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
		this.AñadirHistorial("Consulta historial de acciones");
		return historial;
	}
	
	public void AñadirHistorial(String accion) {
		this.historial.add(dateFormat.format(Calendar.getInstance()) + " "+ accion);
	}
	
	String VuelosDisponibles() {
		String vuelosDisponibles = "(Numero de Vuelo, Precio, Fecha/Hora, Salida-Destino)";
		Iterator i = vuelos.iterator();
		while(i.hasNext()) {
			Vuelo vuelo = (Vuelo)i.next();
			if(vuelo.estado.equals("Venta")) {
				vuelosDisponibles = vuelosDisponibles + "\n" + vuelo.toString("consulta");
			}
		}
		return vuelosDisponibles;
	}

	String EstadoVuelos() {
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

	void NuevoVuelo(Aeropuerto salida, Aeropuerto destino) {
		puertaAbordaje += 1;
		if(puertaAbordaje > 18) {
			puertaAbordaje = 1;
		}
		Calendar fecha = Calendar.getInstance();
		int r = (int)(Math.random()*(10-5+1)+5);
		fecha.add(fecha.MINUTE,r);
		Empleado.vuelos.add(new Vuelo(fecha, destino, salida, puertaAbordaje));
		//Empleado.AñadirHistorial("Creacion vuelo "+ numeroVuelo);
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
		Iterator i = vuelos.iterator();
		while(i.hasNext()) {
			Vuelo x = (Vuelo) i.next();
			switch (x.estado) {
			case "Venta":
				x.estado = "Abordaje";
				break;
			case "Abordaje":
				int azar = (int)(Math.random() * 10);
				if(azar >= 5) {
					x.estado = "Despego";
				}else {
					x.estado = "Restrasado";
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
				break;
			case "Aterrizo":
				x.finalize();
				break;
			}
		}
	}
	
	
	}
	
	
