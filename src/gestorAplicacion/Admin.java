package gestorAplicacion;
import java.text.DateFormat;
import java.util.*;
public class Admin {

	public static Vector<Cliente>clientes= new Vector <>();
	public static Vector<String> premios = new Vector<>(); 
	public static Vector<Aeropuerto> destinos = new Vector<>();
	Aeropuerto A1 = new Aeropuerto("Jose Maria Cordoba","Rio Negro","Colombia"); 
	Aeropuerto A2 = new Aeropuerto("El Dorado","Bogota","Colombia");
	Aeropuerto A3 = new Aeropuerto("Rafael Nuñez","Cartagena de Indias","Colombia");
	Aeropuerto A4 = new Aeropuerto("","Cali","Colombia");
	Aeropuerto A5 = new Aeropuerto("Miami International Airport","Miami","Esados Unidos");
	Aeropuerto A6 = new Aeropuerto("UNAL","Bloque 11","Combativa");

	static String Premios(Cliente cliente, String premio) {
		String aviso = "Millas insuficientes";
		int precio = 0;
		switch (premio) {
			case "Carroo":
				precio = 15000;
				break;
			case "Sala-Comedor":
				precio = 400;
				break;
			case "iphone A20":
				precio = 950;
				break;
		}
		if(cliente.cuentamillas.getMillas() >= precio) {
			Empleado.ModMillas(cliente, -precio);
			aviso = "Premio canjeado correctamente";
			cliente.AñadirHistorial("Canjeo Premio "+ premio);
		}else {
			cliente.AñadirHistorial("Canjeo premio fallido, millas insuficientes");
		}
		return aviso;
	}
	
	public static int BuscarCliente(int id) {
		int posicion = 0;
		Cliente busqueda;
		Iterator i = clientes.iterator();
		while(i.hasNext()) {
			busqueda = (Cliente) i.next();
			if(busqueda.identificacion == id) {
				break;
			}
			posicion++;
		}
		if(posicion==clientes.size()) {
			posicion = -1;
		}
		return posicion;
	}

}
