package Basededatos;
import java.io.*;
import java.util.Vector;
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
			BufferedReader aeropuerto=new BufferedReader(Aeropuertos);
			BufferedReader Cliente=new BufferedReader(Clientes);
			BufferedReader Empleado=new BufferedReader(Empleados);
			BufferedReader Vuelo=new BufferedReader(Vuelos);
			BufferedReader Reserva=new BufferedReader(Reservas);
			while(aeropuerto.readLine()!=null) {
				String nombre=(String)aeropuerto.readLine();
				String ciudad=(String)aeropuerto.readLine();
				String pais=(String)aeropuerto.readLine();
				new Aeropuerto(nombre,ciudad,pais);
			}   
			Cliente nuevo;
			while(Cliente.readLine()!=null) {
				nuevo=null;
				int identificacion=Integer.valueOf((String)aeropuerto.readLine());
				int cuentabancaria=Integer.valueOf((String)aeropuerto.readLine());
				String nombre=(String)aeropuerto.readLine();
				String direccion=(String)aeropuerto.readLine();
				String correo=(String)aeropuerto.readLine();
				int pasaporte=Integer.valueOf((String)aeropuerto.readLine());
				nuevo=new Cliente(identificacion,cuentabancaria,nombre,direccion,correo,pasaporte);
				nuevo.cartera
			}
			
			
		} catch (IOException e) {
			System.out.println("Error en archivo");
			e.printStackTrace();
		}

		
	}
	
}
