package Basededatos;
import java.io.*;
import java.util.Vector;
import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import gestorAplicacion.AtencionAlCliente.*;
import gestorAplicacion.Master.*;



//Esta clase se usa para leer los datos los cuales se encuentran en los archivos 
//.json en los cuales se guarda la informacion del usuario al salir.
public class Reader {
	static Gson gson=new Gson();
	static File fichero = new File("");
	FileReader ficheros=null;
	//este metodo es el que se utiliza para poder realizar la lectura en el momento en que se llame.
	public static void Leer(){
		//Pasa los Aeropuertos a el programa
		try {
		       JsonParser parser = new JsonParser();
		       FileReader fr = new FileReader(fichero.getAbsolutePath()+"\\src\\Basededatos\\temp\\Aeropuertos.json");
		       JsonElement Aeropuertos = parser.parse(fr);	
		       String json = gson.toJson(Aeropuertos);
		       Type listType = new TypeToken<Vector<Aeropuerto>>(){}.getType();
		       Vector<Aeropuerto> arrayDeJson = gson.fromJson(json, listType);
		       Admin.destinos= arrayDeJson;
		}catch(Exception e){
			System.out.println("ERROR al entrar aeropuertos");
			System.out.println(e);
			}
		//pasa los Vuelos al programa
		try {
		       JsonParser parser = new JsonParser();
		       FileReader fr = new FileReader(fichero.getAbsolutePath()+"\\src\\Basededatos\\temp\\Vuelos.json");
		       JsonElement Aeropuertos = parser.parse(fr);	
		       String json = gson.toJson(Aeropuertos);
		       Type listType = new TypeToken<Vector<Vuelo>>(){}.getType();
		       Vector<Vuelo> arrayDeJson = gson.fromJson(json, listType);
		       Empleado.vuelos= arrayDeJson;
		       for (int i=0;i<Empleado.vuelos.size();i++) {
		    	   //crea en cada vuelo la lista reservas para poder a�adir a los pasajeros
		    	   Empleado.vuelos.get(i).setPuestos(new Reserva[20]);
		       }
		      
		}catch(Exception e){
			System.out.println("ERROR al entrar los vuelos");
			System.out.println(e);
			}
		//pasa los empleados a el empleado
		try {
		       JsonParser parser = new JsonParser();
		       FileReader fr = new FileReader(fichero.getAbsolutePath()+"\\src\\Basededatos\\temp\\Empleados.json");
		       JsonElement Aeropuertos = parser.parse(fr);	
		       String json = gson.toJson(Aeropuertos);
		       Type listType = new TypeToken<Vector<Empleado>>(){}.getType();
		       Vector<Empleado> arrayDeJson = gson.fromJson(json, listType);
		       Admin.empleados= arrayDeJson;
		}catch(Exception e){
			System.out.println("ERROR al entrar empleado");
			System.out.println(e);
			}
		//pasa los usuarios o clientes al programa
		try {
		       JsonParser parser = new JsonParser();
		       FileReader fr = new FileReader(fichero.getAbsolutePath()+"\\src\\Basededatos\\temp\\Clientes.json");
		       JsonElement Clientes = parser.parse(fr);	
		       String json = gson.toJson(Clientes);
		       Type listType = new TypeToken<Vector<Cliente>>(){}.getType();
		       Vector<Cliente> arrayDeJson = gson.fromJson(json, listType);
		       Admin.clientes= arrayDeJson;
		       for (Cliente Cliente : Admin.clientes) {
		    	   //asigna a cada cliente su cartera y a sus carteras sus respectivos vuelos 
		    	   Cliente.getCuentabancaria().setTitular(Cliente.getIdentificacion());
		    	   Cliente.getCuentamillas().setTitular(Cliente);
		    	   String jsoncartera=gson.toJson(Cliente.cartera);
		    	   Reserva[] hi = gson.fromJson(jsoncartera,Reserva[].class);
		    	   Vector<Reserva> asd=VectorReservas(hi,Cliente);

		    	   Cliente.cartera=asd;
		 
		       }
		}catch(Exception e){
			System.out.println("ERROR al entrar cliente");
			System.out.println(e);
			}
		Vuelo.setCantidaddevuelos(Empleado.vuelos.get(Empleado.vuelos.size()-1).getNumeroVuelo());

	}
	// convierte la lista de cartera generada en la escritura vector
	private static Vector<Reserva> VectorReservas(Reserva[] hi,Cliente cliente) {
		Vector<Reserva> A=new Vector<>();
		   for(int i=0;i<hi.length;i++) {
 		   int a=hi[i].getCodigovuelo();
 		   boolean b=hi[i].getEquipaje();
 		   Cliente c=cliente;
 		   int d=hi[i].getCosto();
 		   int e=hi[i].getSilla();
 		   Vuelo f=hi[i].asignarReserva();
 		   Reserva restaurar=new Reserva(a,f,c,d,b,e);
 		   f.getPuestos()[e-1]=restaurar;
		   A.add(restaurar);
				}
				
		return A;
	}  
	
}