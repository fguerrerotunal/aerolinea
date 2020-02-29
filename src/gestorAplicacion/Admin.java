package gestorAplicacion;
import java.text.DateFormat;
import java.util.*;
public class Admin {

	public static Vector<Cliente>clientes= new Vector <>();
	public static Vector<String> premios = new Vector<>(); 
	public static Vector<Aeropuerto> destinos = new Vector<>();

	static String Premios(Cliente cliente, int posicionpremio) {
		String aviso = "Millas insuficientes";
		int precio = 0;
		switch (posicionpremio) {
		case 0:
			precio = 0;
			break;
		case 1:
			precio = 0;
			break;	
		case 2:
			precio = 0;
			break;
		case 3:
			precio = 0;
			break;
		case 4:
			precio = 0;
			break;
		case 5:
			precio = 0;
			break;
		case 6:
			precio = 0;
			break;
		case 7:
			precio = 0;
			break;
		}
		if(cliente.cuentamillas.getMillas() >= precio) {
			Empleado.ModMillas(cliente, -precio);
			aviso = "Premio canjeado correctamente";
			cliente.AñadirHistorial("Canjeo Premio "+ premios.get(posicionpremio));
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

	public static String ImprimirPremios() {
		String premios = "";
		int posicion=0;
		Iterator i = Admin.premios.iterator();
		while(i.hasNext()) {
			premios = premios +posicion+ ". " +i.next() + "\n";
			posicion++;
		}
		return premios;
	}
}
