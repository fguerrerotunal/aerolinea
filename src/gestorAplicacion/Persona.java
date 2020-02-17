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
		
		this.AñadirHistorial("Registro en el sistema");
	}
	
	public String Historial(){
		Iterator i = historial.iterator();
		String historial = "Historial de acciones de: " + nombre;
		while(i.hasNext()) {
			historial = historial + "\n" + i.next();
		}
		this.AñadirHistorial("Consulta historial de acciones");
		return historial;
	}
	
	public void AñadirHistorial(String accion) {
		this.historial.add(dateFormat.format(new Date()) + " "+ accion);
	}
	//lista de get 
	//
	//
	public getIdentificacion(Persona persona) {
		return this.identificacion;
	}
	public getNombre(Persona persona) {
		return this.nombre;
	}
	public getDireccion(Persona persona) {
		return this.direccion;
	}
	public getCorreo(Persona persona) {
		return this.correo;
	}
}
