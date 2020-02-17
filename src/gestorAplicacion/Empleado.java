package gestorAplicacion;

import java.util.Iterator;
import java.util.Vector;

public class Empleado extends Persona{
	String ocupacion;
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
}
