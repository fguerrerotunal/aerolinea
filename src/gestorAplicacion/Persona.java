package gestorAplicacion;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
public abstract class Persona implements Serializable{
	private static final long serialVersionUID = 1L;
	protected int identificacion;
	public  CuentaBancaria cuentabancaria;
	protected String nombre;
	protected String direccion;
	protected String correo;
	public Vector<String> historial = new Vector<>();
	DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm");

	public Persona(int identificacion, int cuentabancaria, String nombre, String direccion, String correo){
		this.identificacion = identificacion;
		this.cuentabancaria = new CuentaBancaria(cuentabancaria,this);
		this.nombre = nombre;
		this.direccion = direccion;
		this.correo = correo;
		
		//this.AñadirHistorial("Registro en el sistema");
	}
	
	public abstract String Historial();
	
	public abstract void AñadirHistorial(String accion);
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
