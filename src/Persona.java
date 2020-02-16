import java.util.*;
public class Persona {
	int identificacion;
	CuentaBancaria cuentabancaria;
	String nombre;
	String direccion;
	String correo;
	Vector<String> historial = new Vector<>();
	
	Persona(int identificacion, int cuentabancaria, String nombre, String direccion, String correo){
		this.identificacion = identificacion;
		this.cuentabancaria = new CuentaBancaria(cuentabancaria,this);
		this.nombre = nombre;
		this.direccion = direccion;
		this.correo = correo;
	}
	
	void Historial(){
		Iterator i = historial.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
	}
	
}
