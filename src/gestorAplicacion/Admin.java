package gestorAplicacion;
import java.text.DateFormat;
import java.util.*;
public class Admin {
	//hola como estan esta es una prueba para que entiendan
	public static Vector<Cliente>clientes= new Vector <>();
	public static Vector<String> premios = new Vector<>(); 
	public static Vector<Aeropuerto> destinos = new Vector<>();
	Aeropuerto A1 = new Aeropuerto("Jose Maria Cordoba","Rio Negro","Colombia"); 
	Aeropuerto A2 = new Aeropuerto("El Dorado","Bogota","Colombia");
	Aeropuerto A3 = new Aeropuerto("Rafael Nuņez","Cartagena de Indias","Colombia");
	Aeropuerto A4 = new Aeropuerto("","Cali","Colombia");
	Aeropuerto A5 = new Aeropuerto("Miami International Airport","Miami","Esados Unidos");
	Aeropuerto A6 = new Aeropuerto("UNAL","Bloque 11","Combativa");

	static String Premios(Cliente cliente, String premio) {
		String aviso = "Millas insuficientes";
		int precio = 0;
		switch (premio) {
			case "Carroo":
				precio = 15000;
				break;
			case "Sala-Comedor":
				precio = 400;
				break;
			case "iphone A20":
				precio = 950;
				break;
		}
		if(cliente.cuentamillas.getMillas() >= precio) {
			Empleado.ModMillas(cliente, -precio);
			aviso = "Premio canjeado correctamente";
			cliente.AņadirHistorial("Canjeo Premio "+ premio);
		}else {
			cliente.AņadirHistorial("Canjeo premio fallido, millas insuficientes");
		}
		return aviso;
	}
	
	public static int BuscarCliente(int id) {
		int posicion = 0;
		Cliente busqueda;
		Iterator i = clientes.iterator();
		while(i.hasNext()) {
			busqueda = (Cliente) i.next();
			if(busqueda.identificacion == id) {
				break;
			}
			posicion++;
		}
		if(posicion==clientes.size()) {
			posicion = -1;
		}
		return posicion;
	}
//	public static void main(String[] args) {
		
		
//		Scanner sc = new Scanner(System.in);
		//		Cliente cliente1 = new Cliente(1002899765, 123, "federico", "cra35No46-60", "fredde@gmail.com", 1234);
		//		Empleado empleado1 = new Empleado(1002000123, 321 ,"pirobo", "carlosE", "maricatu@gmail.com", "gestordevuelo");
		//while(true) {
		//String opccion = sc.next();
		//switch (opccion) {
		//	case "invitado":
		//		System.out.println("pantalla invitado");
		//		break;
		//	case "usuario":
		//		
		//}
		//}
//	}

}
