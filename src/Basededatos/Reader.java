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
		        while(true) {
		        	Aeropuertos=null;
		        	break;}
		        
		}catch(Exception e){
			System.out.println("ERROR al entrar los datos");
			System.out.println(e);
			}


	}  
	
}