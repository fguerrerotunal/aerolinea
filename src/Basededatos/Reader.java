package Basededatos;
import java.io.*;
import gestorAplicacion.*;
public class Reader {
	public static void Leer() throws Exception{
		try {
			FileInputStream Aeropuertos=new FileInputStream("C:\\Users\\crist\\Desktop\\aerolinea\\src\\Basededatos\\Aeropuertos.txt");
			ObjectInputStream entradas=new ObjectInputStream(Aeropuertos);
		}catch(Exception e) {
			System.out.println("a");
		}
	}
}
