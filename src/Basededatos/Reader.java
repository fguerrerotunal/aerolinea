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
	static Gson archivo=new Gson();
	static File fichero = new File("");
	public static void Leer(){
		try {
	       JsonElement Aeropuertos=lector.parse(new FileReader(fichero.getAbsolutePath()+"\\src\\Basededatos\\Aeropuertos.txt"));
	       
	        Type listType = new TypeToken<Vector<Aeropuerto>>(){}.getType();
			Admin.destinos= archivo.fromJson(Aeropuertos,listType);
		}catch(Exception e){
			System.out.println("ERROR al entrar los datos");
			System.out.println(e);
			}
		JsonParser parser = new JsonParser();
		try{
			Object obj = parser.parse(new FileReader(fichero.getAbsolutePath()+"\\src\\Basededatos\\Aeropuertos.txt"));
			 
			JsonObject jsonObject = (JsonObject) obj;
	 
			String nombre = (String) jsonObject.get("nombre");
			System.out.println("nombre:"+nombre);
	 
			long edad = (Long) jsonObject.get("edad");
			System.out.println("edad:"+edad);
	 
			// recorrer arreglo
			JSONArray leng= (JSONArray) jsonObject.get("lenguajes_favoritos");
			System.out.println("lenguajes_favoritos:");
			Iterator iterator =leng.iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
			}
			
		}catch(Exception ex){
			System.err.println("Error: "+ex.toString());
		}finally{
			
		}

	}  

}