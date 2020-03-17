package Basededatos;
import java.io.*;
import java.util.Iterator;
import org.json.*;
import com.google.*;
import gestorAplicacion.AtencionAlCliente.Cliente;
import gestorAplicacion.Master.Admin;
import gestorAplicacion.Master.Aeropuerto;
import gestorAplicacion.Master.Empleado;
import gestorAplicacion.Master.Vuelo;
public class Reader{
	File fichero=new File("");
	String JSON = gson.toJson(fichero.getAbsolutePath()+"\\src\\Basededatos\\Aeropuertos.txt");
	public static void Leer(){
		
		FileReader Reader=new FileReader(fichero.getAbsolutePath()+"\\src\\Basededatos\\Aeropuertos.txt");
		try {

			entradas = new ObjectInputStream(new FileInputStream(fichero.getAbsolutePath()+"\\src\\Basededatos\\Aeropuertos.txt"));

			Objeto=entradas.readObject();
			try{
				while (Objeto!=null) {
					Admin.destinos.add((Aeropuerto) Objeto);
					Objeto=entradas.readObject();
				}
			}catch(java.io.EOFException e){
				
			}
			entradas.close();
			entradas = new ObjectInputStream(new FileInputStream(fichero.getAbsolutePath()+"\\src\\Basededatos\\Clientes.txt"));
			Objeto=entradas.readObject();
			try{
				while (Objeto!=null) {
				Admin.clientes.add((Cliente) Objeto);
				Objeto=entradas.readObject();
				}
			}catch(java.io.EOFException e){
			
			}
			entradas.close();
			entradas = new ObjectInputStream(new FileInputStream(fichero.getAbsolutePath()+"\\src\\Basededatos\\Empleados.txt"));
			Objeto=entradas.readObject();
			try{
				while (Objeto!=null) {
					Admin.empleados.add((Empleado) Objeto);
					Objeto=entradas.readObject();
				}
			}catch(java.io.EOFException e){
				
			}
			entradas.close();
			entradas = new ObjectInputStream(new FileInputStream(fichero.getAbsolutePath()+"\\src\\Basededatos\\Vuelos.txt"));
			Objeto=entradas.readObject();
			try{
				while (Objeto!=null) {
					Empleado.vuelos.add((Vuelo) Objeto);
					Objeto=entradas.readObject();
				}
			}catch(java.io.EOFException e){
				
			}
			entradas.close();
		}catch(Exception e) {

			System.out.println(e.toString());

		}
	}
}
