package gestorAplicacion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
public class Persona {
	int identificacion;
	CuentaBancaria cuentabancaria;
	String nombre;
	String direccion;
	String correo;
	Vector<String> historial = new Vector<>();
	DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm");
	
	Persona(int identificacion, int cuentabancaria, String nombre, String direccion, String correo){
		this.identificacion = identificacion;
		this.cuentabancaria = new CuentaBancaria(cuentabancaria,this);
		this.nombre = nombre;
		this.direccion = direccion;
		this.correo = correo;
		
		this.AñadirHistorial("Registro en el sistema");
	}
	
	String Historial(){
		Iterator i = historial.iterator();
		String historial = "Historial de acciones de: " + nombre;
		while(i.hasNext()) {
			historial = historial + "\n" + i.next();
		}
		this.AñadirHistorial("Consulta historial de acciones");
		return historial;
	}
	
	void AñadirHistorial(String accion) {
		this.historial.add(dateFormat.format(new Date()) + " "+ accion);
	}
	
}
