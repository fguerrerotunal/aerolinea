package Basededatos;
import java.io.*;
import java.util.Vector;
import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import gestorAplicacion.AtencionAlCliente.*;
import gestorAplicacion.Master.*;
import java.io.*;
public class Reader {
	static Gson gson=new Gson();
	static File fichero = new File("");
	FileReader ficheros=null;
	public static void Leer(){
		try {
		       JsonParser parser = new JsonParser();
		       FileReader fr = new FileReader(fichero.getAbsolutePath()+"\\src\\Basededatos\\Aeropuertos.json");
		       JsonElement Aeropuertos = parser.parse(fr);	
		       String json = gson.toJson(Aeropuertos);
		       Type listType = new TypeToken<Vector<Aeropuerto>>(){}.getType();
		       Vector<Aeropuerto> arrayDeJson = gson.fromJson(json, listType);
		       Admin.destinos= arrayDeJson;
		}catch(Exception e){
			System.out.println("ERROR al entrar los datos");
			System.out.println(e);
			}
		try {
		       JsonParser parser = new JsonParser();
		       FileReader fr = new FileReader(fichero.getAbsolutePath()+"\\src\\Basededatos\\Vuelos.json");
		       JsonElement Aeropuertos = parser.parse(fr);	
		       String json = gson.toJson(Aeropuertos);
		       Type listType = new TypeToken<Vector<Vuelo>>(){}.getType();
		       Vector<Vuelo> arrayDeJson = gson.fromJson(json, listType);
		       Empleado.vuelos= arrayDeJson;
		      
		}catch(Exception e){
			System.out.println("ERROR al entrar los datos");
			System.out.println(e);
			}
		try {
		       JsonParser parser = new JsonParser();
		       FileReader fr = new FileReader(fichero.getAbsolutePath()+"\\src\\Basededatos\\Empleados.json");
		       JsonElement Aeropuertos = parser.parse(fr);	
		       String json = gson.toJson(Aeropuertos);
		       Type listType = new TypeToken<Vector<Empleado>>(){}.getType();
		       Vector<Empleado> arrayDeJson = gson.fromJson(json, listType);
		       Admin.empleados= arrayDeJson;
		}catch(Exception e){
			System.out.println("ERROR al entrar los datos");
			System.out.println(e);
			}
		try {
		       JsonParser parser = new JsonParser();
		       FileReader fr = new FileReader(fichero.getAbsolutePath()+"\\src\\Basededatos\\Clientes.json");
		       JsonElement Aeropuertos = parser.parse(fr);	
		       String json = gson.toJson(Aeropuertos);
		       Type listType = new TypeToken<Vector<Cliente>>(){}.getType();
		       Vector<Cliente> arrayDeJson = gson.fromJson(json, listType);
		       Admin.clientes= arrayDeJson;
		       for (int i=0;i<Admin.clientes.size();i++) {
		    	   Cliente cliente =Admin.clientes.get(i);
		    	   for (int j=0;i<Admin.clientes.get(i).cartera.size();i++) {
		    		   Reserva reserva=cliente.cartera.get(j);
		    		   
		    	   }
		       }
		       for (int i=0;i<Admin.clientes.size();i++) {
		    	   Cliente cliente =Admin.clientes.get(i);
		    	   cliente.getCuentabancaria().setTitular(cliente);;
		       }
		}catch(Exception e){
			System.out.println("ERROR al entrar los datos");
			System.out.println(e);
			}



	}  
	
}