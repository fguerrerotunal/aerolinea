package gestorAplicacion.Master;
import java.io.*;
public class Aeropuerto{
	//Atributos de los objetos tipo Clase Aeropuerto
	private String nombre;
	private String ciudad;
	private String pais;
	
	//Constructor
	public Aeropuerto(String nombre, String ciudad, String pais){
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.pais = pais;
		Admin.destinos.add(this);
	}
	//Getters y setters de la clase
	public String getNombre() {
		return nombre;
	}
	
	public String getCiudad() {
		return ciudad;
	}
	
	public String getPais() {
		return pais;
	}
}
