package gestorAplicacion;

public class Aeropuerto {
	private String nombre;
	private String ciudad;
	private String pais;
	
	public Aeropuerto(String nombre, String ciudad, String pais){
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.pais = pais;
		Admin.destinos.add(this);
	}
	
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
