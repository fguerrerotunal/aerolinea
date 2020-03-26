package gestorAplicacion.AtencionAlCliente;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/*
 * 
 */
public abstract class Persona{
//Atributos de los objetos de clase Persona
	

	private static int numero_de_clientes = 1;
	private int identificacion;
	private  CuentaBancaria cuentabancaria;
	private String nombre;
	private String direccion;
	private String correo;
	protected Vector<String> historial = new Vector<>();
//Constructor
	public Persona(int identificacion, int cuentabancaria, String nombre, String direccion, String correo){
		this.identificacion = identificacion;
		this.cuentabancaria = new CuentaBancaria(cuentabancaria,identificacion);
		this.nombre = nombre;
		this.direccion = direccion;
		this.correo = correo;
	}
	//Metodo abstactos arraigados a la clase persona y sus hijos empleado y Cliente
	public abstract String Historial();
	
	public abstract void AñadirHistorial(String accion);
	
	
	//Getters y Setters de la clase
	public static int getNumero_de_clientes() {
		return numero_de_clientes;
	}
	public int getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(int identificacion) {
		this.identificacion = identificacion;
	}

	public CuentaBancaria getCuentabancaria() {
		return cuentabancaria;
	}

	public void setCuentabancaria(CuentaBancaria cuentabancaria) {
		this.cuentabancaria = cuentabancaria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
}
