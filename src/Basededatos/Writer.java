package Basededatos;
import java.io.*;
import java.util.Vector;

import com.google.gson.Gson;

import gestorAplicacion.*;
import gestorAplicacion.AtencionAlCliente.Cliente;
import gestorAplicacion.Master.Admin;
import gestorAplicacion.Master.Aeropuerto;
import gestorAplicacion.Master.Empleado;
public class Writer{
	static Gson gson = new Gson();
	static File fichero = new File("");
	static FileWriter ficheros = null;
	static PrintWriter pw;
	public static void Escribir() {
	        try {
	        	try {	
		        Vector<Aeropuerto> Aeropuertos= new Vector<>();
		        Aeropuertos=Admin.destinos;
		        String json = gson.toJson(Aeropuertos);
				ficheros = new FileWriter(fichero.getAbsolutePath()+"\\src\\Basededatos\\Aeropuertos.json",true);
				pw=new PrintWriter(ficheros);
	            pw.println(json);
	            ficheros.close();
	            ficheros = null;
	            //empleados
	            Vector<Vuelo> Vuelos= new Vector<>();
		        Vuelos=Admin.empleados.get(0).vuelos;
		        json = gson.toJson(Empleado);
				ficheros = new FileWriter(fichero.getAbsolutePath()+"\\src\\Basededatos\\Aeropuertos.json",true);
				pw=new PrintWriter(ficheros);
	            pw.println(json);
	            ficheros.close();
	            ficheros = null;
	          
	            }catch(IOException e1) {
	        		System.out.println("Error IO");
	        	}
	            			
	        
	        
	        
	        
	        
	        

	        
	        
	        } 
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        catch (Exception e1) {
				System.out.println("\n No funciono general: "+e1);
				e1.printStackTrace();
			}

}
	public void Escliente(Cliente a) {
		
	}
	
	
	}
