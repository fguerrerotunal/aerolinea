package Basededatos;
import java.io.*;
import gestorAplicacion.*;
public class Reader {
	private static ObjectInputStream entradas;
	static File Aeropuertos = new File("");
	public static void Leer(){
		try {

			entradas = new ObjectInputStream(new FileInputStream(Aeropuertos.getAbsolutePath()+"\\src\\Basededatos\\Aeropuertos.txt"));

			Object Objeto=entradas.readObject();
			while (Objeto!=null) {
				Admin.destinos.add((Aeropuerto) Objeto);
				Objeto=entradas.readObject();
			}
			entradas.close();
			entradas = new ObjectInputStream(new FileInputStream("...Clientes.txt"));
			Objeto=entradas.readObject();
			while (Objeto!=null) {
				Admin.clientes.add((Cliente) Objeto);
				Objeto=entradas.readObject();
			}
			entradas.close();
			entradas = new ObjectInputStream(new FileInputStream("...Empleados.txt"));
			Objeto=entradas.readObject();
			while (Objeto!=null) {
				Admin.empleados.add((Empleado) Objeto);
				Objeto=entradas.readObject();
			}
			entradas.close();
			entradas = new ObjectInputStream(new FileInputStream("...Vuelos.txt"));
			Objeto=entradas.readObject();
			while (Objeto!=null) {
				Empleado.vuelos.add((Vuelo) Objeto);
				Objeto=entradas.readObject();
			}
			entradas.close();
			
			
		}catch(Exception e) {

			System.out.println(e.toString());

		}
	}
}
