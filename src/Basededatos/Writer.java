package Basededatos;
import java.io.*;
import java.util.Vector;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import gestorAplicacion.AtencionAlCliente.Cliente;
import gestorAplicacion.AtencionAlCliente.Reserva;
import gestorAplicacion.Master.Admin;
import gestorAplicacion.Master.Aeropuerto;
import gestorAplicacion.Master.Empleado;
import gestorAplicacion.Master.Vuelo;
public class Writer{
	static Gson gson = new Gson();
	static File fichero = new File("");
	static PrintWriter pw;
	static FileWriter ficheros = null;
	public static void Escribir() {
		
		//borrar toda la informacion que tenian antes los archivos para las bases de datos 
	        try {
	        	BufferedWriter bw = new BufferedWriter(new FileWriter(fichero.getAbsolutePath()+"\\src\\Basededatos\\temp\\Aeropuertos.json"));
	    		bw.write("");
	    		bw.close();
	        	bw = new BufferedWriter(new FileWriter(fichero.getAbsolutePath()+"\\src\\Basededatos\\temp\\Vuelos.json"));
	    		bw.write("");
	    		bw.close();
	        	bw = new BufferedWriter(new FileWriter(fichero.getAbsolutePath()+"\\src\\Basededatos\\temp\\Clientes.json"));
	    		bw.write("");
	    		bw.close();
	        	bw = new BufferedWriter(new FileWriter(fichero.getAbsolutePath()+"\\src\\Basededatos\\temp\\Empleados.json"));
	    		bw.write("");
	    		bw.close();
	    		//guarda los aeropuertos en la base de datos
	        	try {	
		        Vector<Aeropuerto> Aeropuertos= new Vector<>();
		        Aeropuertos=Admin.destinos;
		        String json = gson.toJson(Aeropuertos);
				ficheros = new FileWriter(fichero.getAbsolutePath()+"\\src\\Basededatos\\temp\\Aeropuertos.json",true);
				pw=new PrintWriter(ficheros);
	            pw.println(json);
	            ficheros.close();
	            if (null != ficheros) {
	                ficheros.close();}
	            }catch(IOException e1) {
	        		System.out.println("Error adentro en Aeropuertos: "+e1);
	        	}
	        	//guarda los empleados en la base de datos 
	        	try {
			        String json = gson.toJson(Empleado.vuelos);
			        Type listType = new TypeToken<Vector<Vuelo>>(){}.getType();
			        Vector<Vuelo> arrayDeJson = gson.fromJson(json, listType);
			        json=gson.toJson(arrayDeJson);
					ficheros = new FileWriter(fichero.getAbsolutePath()+"\\src\\Basededatos\\temp\\Vuelos.json",true);
					pw=new PrintWriter(ficheros);
		            pw.println(json);
		            ficheros.close();
		            if (null != ficheros) {
		                ficheros.close();}

 	            }catch(IOException e1) {
	        		System.out.println("Error adentro en Empleados: "+e1);
	        	}
	        	//guarda los clientes en la base de datos 
	        	try {	
		        Vector<Cliente> Clientes= new Vector<>();
		        Clientes=Admin.clientes;
		        borrarenlaces(Clientes);
		        String json = gson.toJson(Clientes);
				ficheros = new FileWriter(fichero.getAbsolutePath()+"\\src\\Basededatos\\temp\\Clientes.json",true);
				pw=new PrintWriter(ficheros);
	            pw.println(json);
	            ficheros.close();
	            if (null != ficheros) {
	                ficheros.close();}
	            }catch(IOException e1) {
	        		System.out.println("Error adentro en Aeropuertos: "+e1);
	        	}
	        	//guarda los empleados en la base de datos
	        	try {	
		        Vector<Empleado> Empleados= new Vector<>();
		        Empleados=Admin.empleados;
		        String json = gson.toJson(Empleados);
				ficheros = new FileWriter(fichero.getAbsolutePath()+"\\src\\Basededatos\\temp\\Empleados.json",true);
				pw=new PrintWriter(ficheros);
	            pw.println(json);
	            ficheros.close();
	            if (null != ficheros) {
	                ficheros.close();}
	            }catch(IOException e1) {
	        		System.out.println("Error adentro en Aeropuertos: "+e1);
	        	}


	        


	        }catch (Exception e1) {
				System.out.println("\n No funciono general: "+e1);
				e1.printStackTrace();
			}

}
	//convierte atributos de la cartera de cliente a null(Vuelo,pasajero) para que no se generen problemas al guardar
	private static void borrarenlaces(Vector<Cliente> clientes) {
		for (Cliente i:clientes) {
			for(Reserva j:i.cartera) {
				j.setvuelo(null);
				j.setpasajero(null);
			}
		}
	}
	
	
	}
