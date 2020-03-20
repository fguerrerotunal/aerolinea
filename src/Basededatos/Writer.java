package Basededatos;
import java.io.*;
import java.util.Vector;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import gestorAplicacion.*;
import gestorAplicacion.AtencionAlCliente.Cliente;
import gestorAplicacion.Master.Admin;
import gestorAplicacion.Master.Aeropuerto;
import gestorAplicacion.Master.Empleado;
import gestorAplicacion.Master.Vuelo;
public class Writer{
	static Gson gson = new Gson();
	static File fichero = new File("");
	static PrintWriter pw;
	public static void Escribir() {
	        try {
	        	try {	
		        Vector<Aeropuerto> Aeropuertos= new Vector<>();
		        FileWriter ficheros = null;
		        Aeropuertos=Admin.destinos;
		        String json = gson.toJson(Aeropuertos);
				ficheros = new FileWriter(fichero.getAbsolutePath()+"\\src\\Basededatos\\Aeropuertos.json",true);
				pw=new PrintWriter(ficheros);
	            pw.println(json);
	            ficheros.close();
	            if (null != ficheros) {
	                ficheros.close();}
	            }catch(IOException e1) {
	        		System.out.println("Error adentro en Aeropuertos: "+e1);
	        	}
	        	try {
	        		FileWriter ficheros=null;
	        		for(int i=0;i<Admin.empleados.size();i++) {
	        			
	        		}
 	            }catch(IOException e1) {
	        		System.out.println("Error adentro en Empleados: "+e1);
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
