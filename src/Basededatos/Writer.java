package Basededatos;
import java.io.*;
import java.util.Vector;

import com.google.gson.Gson;

import gestorAplicacion.*;
import gestorAplicacion.AtencionAlCliente.Cliente;
import gestorAplicacion.Master.Admin;
import gestorAplicacion.Master.Empleado;
public class Writer{
	static File fichero = new File("");
	static ObjectOutputStream entradas;
	public static void Escribir() {
	        try {
	        	Gson gson = new Gson();
	        	FileWriter ficheros = null;
	        	PrintWriter pw=new PrintWriter(ficheros);
	        	try {	
		        Vector<Cliente> clientes= new Vector<>();
		        clientes=Admin.clientes;
		        String json = gson.toJson(clientes);
				ficheros = new FileWriter(fichero.getAbsolutePath()+"\\src\\Basededatos\\Aeropuertos.txt");
	            pw.println(json);
	            ficheros.close();
	            }catch(IOException e1) {
	        		System.out.println("Error adentro en Clientes: "+e1);
	        	}
			
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        } 
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        catch (Exception e1) {
				System.out.println("No funciono"+e1);
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

}
	}
