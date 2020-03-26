package gestorAplicacion.Master;
import java.io.*;
import java.text.DateFormat;
import java.util.*;
import Utilidades.clienteInexistente;

import gestorAplicacion.AtencionAlCliente.Cliente;
public class Admin{
	
//lista donde estan todos los vuelos,clientes,empleados
	public static Vector<Cliente>clientes= new Vector <>();
	public static Vector<Empleado>empleados= new Vector <>();
	public static Vector<String> premios = new Vector<>(); 
	public static Vector<Aeropuerto> destinos = new Vector<>();
//metodo que se utiliza para comprobar si las millas del cliente son suficientes para el premio que quiere canjear
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
		if(cliente.getCuentamillas().getMillas() >= precio) {
			Admin.empleados.get(0).ModMillas(cliente, -precio);
			aviso = "Premio canjeado correctamente";
		}
		return aviso;
	}
	//metodo que se encarga de buscar un cliente utilizando su identificacion
	public static int BuscarCliente(int id) throws clienteInexistente {
		int posicion = 0;
		Cliente busqueda;
		Iterator i = clientes.iterator();
		while(i.hasNext()) {
			busqueda = (Cliente) i.next();
			if(busqueda.getIdentificacion() == id) {
				break;
			}
			posicion++;
		}
		if(posicion==clientes.size()) {
			throw new clienteInexistente();
		}
		return posicion;
	}

	//metodo que se encarga de imprimir los premios que puede canjear el usuario
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
	//Metodo que se utiliza para reiniciar la base de datos 
	public static void Reiniciar() {		
		Admin.empleados.add(new Empleado(001,212,"Porky","Casa de nariño","porky@colombia.com","Servicios Varios"));
		new Aeropuerto("Jose Maria Córdova","Rionegro","Colombia");
		new Aeropuerto("El Dorado","Bogota","Colombia");
		new Aeropuerto("John F.Kennedy","New York","EEUU");
		new Aeropuerto("Barajas Adolfo Suarez","Madrid","España");
		new Aeropuerto("Pudong","Shanghai","China");
		Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(0), Admin.destinos.get(1));
		Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(0), Admin.destinos.get(2));
		Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(0), Admin.destinos.get(3));
		Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(0), Admin.destinos.get(4));
		Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(1), Admin.destinos.get(0));
		Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(1), Admin.destinos.get(2));
		Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(1), Admin.destinos.get(3));
		Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(1), Admin.destinos.get(4));
		Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(2), Admin.destinos.get(0));
		Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(2), Admin.destinos.get(1));
		Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(2), Admin.destinos.get(3));
		Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(2), Admin.destinos.get(4));
		Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(3), Admin.destinos.get(0));
		Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(3), Admin.destinos.get(1));
		Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(3), Admin.destinos.get(2));
		Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(3), Admin.destinos.get(4));
		Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(4), Admin.destinos.get(0));
		Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(4), Admin.destinos.get(1));
		Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(4), Admin.destinos.get(2));
		Admin.empleados.get(0).NuevoVuelo(Admin.destinos.get(4), Admin.destinos.get(3));
		Admin.clientes.add(new Cliente(1,12,"fedrico guerrero", "as5d4","",234));
			
		}
}