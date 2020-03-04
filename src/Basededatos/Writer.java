package Basededatos;
import java.io.*;
import java.util.*;

import gestorAplicacion.Admin;
public class Writer{
	static ObjectOutputStream entradas;
	public static void Escribir() {
		try {
			entradas=new ObjectOutputStream(new FileOutputStream("\\Temp\\GitHub\\aerolinea\\src\\Basededatos\\Aeropuerto.txt"));
			for (int i=0;i<Admin.destinos.size();i++) {
				entradas.writeObject(Admin.destinos.get(i));
			}
			entradas=new ObjectOutputStream(new FileOutputStream("\\Temp\\GitHub\\aerolinea\\src\\Basededatos\\Clientes.txt"));
			for (int i=0;i<Admin.clientes.size();i++) {
				entradas.writeObject(Admin.clientes.get(i));
			}
		} catch (IOException e) {
			System.out.println("ERROR"+ e.getMessage());
		}
		
	}
}
