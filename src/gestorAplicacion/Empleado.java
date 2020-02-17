package gestorAplicacion;

import java.util.Date;
import java.util.Iterator;
import java.util.Vector;

public class Empleado extends Persona{
	String ocupacion;
	int puertaAbordaje = 0;
	static Vector<Vuelo> vuelos = new Vector<>();
	
	Empleado(int identificacion, int cuentabancaria, String nombre, String direccion, String correo, String ocupacion){
		super(identificacion, cuentabancaria, nombre, direccion, correo);
		this.ocupacion = ocupacion;
	}
	
	static String VuelosDisponibles() {
		String vuelosDisponibles = "(Numero de Vuelo, Precio, Fecha/Hora, Salida-Destino)";
		Iterator i = vuelos.iterator();
		while(i.hasNext()) {
			Vuelo vuelo = (Vuelo)i.next();
			if(vuelo.puestos.size() < vuelo.capacidad) {
				vuelosDisponibles = vuelosDisponibles + "\n" + vuelo.toString("consulta");
			}
		}
		return vuelosDisponibles;
	}
	
	void NuevoVuelo(String numeroVuelo) {
		puertaAbordaje += 1;
		if(puertaAbordaje > 18) {
			puertaAbordaje = 1;
		}
		Date fecha = new Date();
		int index = 0;
		int index1 = 0;
		while(index == index1) {
			index = (int)(Math.random() * 5);
			index1 = (int)(Math.random() * 5);
		}
		Aeropuerto destino = Admin.destinos.get(index);
		Aeropuerto salida = Admin.destinos.get(index1);
		Empleado.vuelos.add(new Vuelo(numeroVuelo, fecha, destino, salida, puertaAbordaje));
	}
}
