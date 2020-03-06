package gestorAplicacion.Master;
import java.io.*;
import java.text.DateFormat;
import java.util.*;

import gestorAplicacion.AtencionAlCliente.Cliente;
public class Admin implements Serializable{
	private static final long serialVersionUID = 1L;
	public static Vector<Cliente>clientes= new Vector <>();
	public static Vector<Empleado>empleados= new Vector <>();
	public static Vector<String> premios = new Vector<>(); 
	public static Vector<Aeropuerto> destinos = new Vector<>();

	public static String Premios(Cliente cliente, int posicionpremio) {
		String aviso = "Millas insuficientes";
		int precio = 0;
		switch (posicionpremio) {
		case 0:
			precio = 50;
			break;
		case 1:
			precio = 100;
			break;	
		case 2:
			precio = 200;
			break;
		case 3:
			precio = 300;
			break;
		case 4:
			precio = 500;
			break;
		case 5:
			precio = 800;
			break;
		case 6:
			precio = 1000;
			break;
		case 7:
			precio = 1200;
			break;
		}
		if(cliente.cuentamillas.getMillas() >= precio) {
			Admin.empleados.get(0).ModMillas(cliente, -precio);
			aviso = "Premio canjeado correctamente";
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
		String premios = "PREMIOS DISPONIBLES: \n";
		int posicion=0;
		Iterator i = Admin.premios.iterator();
		while(i.hasNext()) {
			premios = premios +posicion+ ". " +i.next() + "\n";
			posicion++;
		}
		return premios;
	}
}
