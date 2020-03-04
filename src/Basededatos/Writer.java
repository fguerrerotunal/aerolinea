package Basededatos;
import java.io.*;
import java.util.*;

import gestorAplicacion.Admin;
public class Writer{
	ObjectOutputStream entradas;
	public void Escribir() {
		try {
			entradas=new ObjectOutputStream(new FileOutputStream("\\Temp\\GitHub\\aerolinea\\src\\Basededatos\\Aeropuerto.txt"));
			for (int i=0;i<Admin.destinos.size();i++) {
				entradas.writeObject(Admin.destinos.get(i));
			}
		} catch (IOException e) {
			System.out.println("ERROR");
		}
		
	}
}
