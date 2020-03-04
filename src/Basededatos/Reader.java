package Basededatos;
import java.io.*;
import gestorAplicacion.*;
public class Reader {
	private static ObjectInputStream entradas;

	public static void Leer(){
		try {
			entradas = new ObjectInputStream(new FileInputStream("C:\\Users\\crist\\Desktop\\aerolinea\\src\\Basededatos\\Aeropuertos.txt"));
			while (entradas!=null) {
				Admin.destinos.add((Aeropuerto) entradas.readObject());
				entradas=(ObjectInputStream) entradas.readObject();
			}
			entradas.close();
			
		}catch(Exception e) {
			System.out.println("a");
		}
	}
}
