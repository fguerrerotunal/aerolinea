package gestorAplicacion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
public class Persona {
	protected int identificacion;
	public  CuentaBancaria cuentabancaria;
	protected String nombre;
	protected String direccion;
	protected String correo;
	public Vector<String> historial = new Vector<>();
	DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm");
	//que es este date format? 
	public Persona(int identificacion, int cuentabancaria, String nombre, String direccion, String correo){
		this.identificacion = identificacion;
		this.cuentabancaria = new CuentaBancaria(cuentabancaria,this);
		this.nombre = nombre;
		this.direccion = direccion;
		this.correo = correo;
		
		this.AņadirHistorial("Registro en el sistema");
	}
	
	public String Historial(){
		Iterator i = historial.iterator();
		String historial = "Historial de acciones de: " + nombre;
		while(i.hasNext()) {
			historial = historial + "\n" + i.next();
		}
		this.AņadirHistorial("Consulta historial de acciones");
		return historial;
	}
	
	public void AņadirHistorial(String accion) {
		this.historial.add(dateFormat.format(new Date()) + " "+ accion);
	}
	//lista de get 
	//
	//
	public int getIdentificacion(Persona persona) {
		return this.identificacion;
	}
	public String getNombre(Persona persona) {
		return this.nombre;
	}
	public String getDireccion(Persona persona) {
		return this.direccion;
	}
	public String getCorreo(Persona persona) {
		return this.correo;
	}
}
