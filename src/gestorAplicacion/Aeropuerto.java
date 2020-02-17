package gestorAplicacion;

public class Aeropuerto {
	private String nombre;
	private String ciudad;
	private String pais;
	
	Aeropuerto(String nombre, String ciudad, String pais){
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.pais = pais;
	}
	
	String getNombre() {
		return nombre;
	}
	
	String getCiudad() {
		return ciudad;
	}
	
	String getPais() {
		return pais;
	}
}
