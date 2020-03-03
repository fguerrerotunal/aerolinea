package Basededatos;
import java.io.*;

import javax.imageio.IIOException;

import gestorAplicacion.*;

public class Reader {
	FileReader Aeropuertos;
	FileReader Clientes;
	FileReader Empleados;
	FileReader Vuelos;
	public void leer() throws FileNotFoundException {
		Aeropuertos=new FileReader("https://github.com/fguerrerotunal/aerolinea/blob/master/src/Basededatos/Aeropuertos.txt");
		Clientes=new FileReader("https://github.com/fguerrerotunal/aerolinea/blob/master/src/Basededatos/Clientes.txt");
		Empleados=new FileReader("https://github.com/fguerrerotunal/aerolinea/blob/master/src/Basededatos/Empleados.txt");
		Vuelos=new FileReader("https://github.com/fguerrerotunal/aerolinea/blob/master/src/Basededatos/Vuelos.txt");
	}
	
}
