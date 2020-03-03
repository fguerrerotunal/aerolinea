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
	public void leer(){
		try {
			Aeropuertos=new FileReader("\\Temp\\GitHub\\aerolinea\\src\\Basededatos\\Aeropuerto.txt");
			Clientes=new FileReader("\\Temp\\GitHub\\aerolinea\\src\\Basededatos\\Clientes.txt");
			Empleados=new FileReader("\\Temp\\GitHub\\aerolinea\\src\\Basededatos\\Empleados.txt");
			Vuelos=new FileReader("\\Temp\\GitHub\\aerolinea\\src\\Basededatos\\Vuelos.txt");
			Reservas=new FileReader("\\Temp\\GitHub\\aerolinea\\src\\Basededatos\\Reservas.txt");
		} catch (FileNotFoundException e) {
			System.out.println("Error en archivo");
			e.printStackTrace();
		}
		BufferedReader Aeropuerto=new BufferedReader(Aeropuertos);
		BufferedReader Cliente=new BufferedReader(Clientes);
		BufferedReader Empleado=new BufferedReader(Empleados);
		BufferedReader Vuelo=new BufferedReader(Vuelos);
		BufferedReader Reserva=new BufferedReader(Reservas);
		
		
	}
	
}
