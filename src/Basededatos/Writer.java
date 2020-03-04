package Basededatos;
import java.io.*;
import gestorAplicacion.*;
public class Writer{
	static File fichero = new File("");
	static ObjectOutputStream entradas;
	public static void Escribir() {
		try {
			entradas=new ObjectOutputStream(new FileOutputStream(fichero.getAbsolutePath()+"\\src\\Basededatos\\Aeropuertos.txt"));
			for (int i=0;i<Admin.destinos.size();i++) {
				entradas.writeObject(Admin.destinos.get(i));
			}
			entradas.close(); 
			entradas=new ObjectOutputStream(new FileOutputStream(fichero.getAbsolutePath()+"\\src\\Basededatos\\Aeropuertos.txt"));
			for (int i=0;i<Admin.clientes.size();i++) {
				entradas.writeObject(Admin.clientes.get(i));
			}
			entradas.close(); 
			entradas=new ObjectOutputStream(new FileOutputStream(fichero.getAbsolutePath()+"\\src\\Basededatos\\Aeropuertos.txt"));
			for (int i=0;i<Admin.empleados.size();i++) {
				entradas.writeObject(Admin.empleados.get(i));
			}
			entradas.close(); 
			entradas=new ObjectOutputStream(new FileOutputStream(fichero.getAbsolutePath()+"\\src\\Basededatos\\Aeropuertos.txt"));
			for (int i=0;i<Empleado.vuelos.size();i++) {
				entradas.writeObject(Empleado.vuelos.get(i));
			}
			entradas.close(); 
			
		} catch (IOException e) {
			System.out.println("ERROR"+ e.getMessage()+"  "+e.toString());
		}
		
	}
}
