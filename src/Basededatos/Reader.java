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
			System.out.println("ERROR al entrar aeropuertos");
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
		       for (int i=0;i<Empleado.vuelos.size();i++) {
		    	   Empleado.vuelos.get(i).setPuestos(new Reserva[20]);
		       }
		      
		}catch(Exception e){
			System.out.println("ERROR al entrar los vuelos");
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
			System.out.println("ERROR al entrar empleado");
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
		       for (Cliente Cliente : Admin.clientes) {
		    	   Type listType2 = new TypeToken<Vector<Reserva>>(){}.getType();
			       Vector<Reserva> arrayDeJson1 = gson.fromJson(json, listType2);
		    	   Cliente.getCuentabancaria().setTitular(Cliente.getIdentificacion());
		    	   Cliente.getCuentamillas().setTitular(Cliente);
		    	   for(Reserva Reserva :Cliente.cartera) {
		    		   Reserva.setpasajero(Cliente);
		    		   Reserva.asignarReserva();
		    		   
		    	   }
		       }
		}catch(Exception e){
			System.out.println("ERROR al entrar cliente");
			System.out.println(e);
			}



	}  
	
}