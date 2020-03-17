package gestorAplicacion.AtencionAlCliente;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
public abstract class Persona implements Serializable{
	private static final long serialVersionUID = 1L;
	private int identificacion;
	private  CuentaBancaria cuentabancaria;
	private String nombre;
	private String direccion;
	private String correo;
	private Vector<String> historial = new Vector<>();
	DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm");

	public Persona(int identificacion, int cuentabancaria, String nombre, String direccion, String correo){
		this.identificacion = identificacion;
		this.cuentabancaria = new CuentaBancaria(cuentabancaria,this);
		this.nombre = nombre;
		this.direccion = direccion;
		this.correo = correo;
	}
	
	public abstract String Historial();
	
	public abstract void AñadirHistorial(String accion);
	
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
