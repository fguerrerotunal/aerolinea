package Basededatos;
import java.io.*;
import gestorAplicacion.*;

public class Reader {
	FileReader Aeropuertos;
	FileReader Clientes;
	FileReader Empleados;
	FileReader Vuelos;
	public void leer() {
		Aeropuertos=new FileReader();
		Clientes=new FileReader();
		Empleados=new FileReader();
		Vuelos=new FileReader();
	}
	
}
