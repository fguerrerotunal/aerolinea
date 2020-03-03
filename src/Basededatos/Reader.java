package Basededatos;
import java.io.*;
import java.util.Vector;
import javax.imageio.IIOException;
import gestorAplicacion.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
public class Reader {
	DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm");
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
			while(Vuelo.readLine()!=null) {
				Calendar fecha=new Calendar((String)Vuelo.readLine());
			}
			
			
			Cliente nuevo;
			while(Cliente.read()!=-1) {
				nuevo=null;
				int identificacion=Integer.valueOf((String)aeropuerto.readLine());
				int cuentabancaria=Integer.valueOf((String)aeropuerto.readLine());
				String nombre=(String)aeropuerto.readLine();
				String direccion=(String)aeropuerto.readLine();
				String correo=(String)aeropuerto.readLine();
				int pasaporte=Integer.valueOf((String)aeropuerto.readLine());
				nuevo=new Cliente(identificacion,cuentabancaria,nombre,direccion,correo,pasaporte);
				while(Cliente.readLine()!="null") {
					
				}
			}
			
			
		} catch (IOException e) {
			System.out.println("Error en archivo");
			e.printStackTrace();
		}

		
	}
	
}
