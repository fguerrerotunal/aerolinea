package Basededatos;
import java.io.*;

import javax.imageio.IIOException;

import gestorAplicacion.*;

public class Reader {
	FileReader Aeropuertos;
	FileReader Clientes;
	FileReader Empleados;
	FileReader Vuelos;
	FileReader Reservas;
	public void leer() throws FileNotFoundException{
		Aeropuertos=new FileReader("\\Temp\\GitHub\\aerolinea\\src\\Basededatos\\Aeropuerto.txt");
		Clientes=new FileReader("\\Temp\\GitHub\\aerolinea\\src\\Basededatos\\Clientes.txt");
		Empleados=new FileReader("\\Temp\\GitHub\\aerolinea\\src\\Basededatos\\Empleados.txt");
		Vuelos=new FileReader("\\Temp\\GitHub\\aerolinea\\src\\Basededatos\\Vuelos.txt");
		Reservas=new FileReader("\\Temp\\GitHub\\aerolinea\\src\\Basededatos\\Reservas.txt");
		for (int i=0;i<Admin.destinos.size();i++) {
			
			
		}
		
	}
	
}
