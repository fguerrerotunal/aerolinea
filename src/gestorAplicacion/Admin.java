package gestorAplicacion;
import java.util.*;
public class Admin {
	static Vector<Aeropuerto> destinos = new Vector<>();
	Aeropuerto A1 = new Aeropuerto("Jose Maria Cordoba","Rio Negro","Colombia"); 
	Aeropuerto A2 = new Aeropuerto("El Dorado","Bogota","Colombia");
	Aeropuerto A3 = new Aeropuerto("Rafael Nuñez","Cartagena de Indias","Colombia");
	Aeropuerto A4 = new Aeropuerto("","Cali","Colombia");
	Aeropuerto A5 = new Aeropuerto("Miami International Airport","Miami","Esados Unidos");
	Aeropuerto A6 = new Aeropuerto("UNAL","Bloque 11","Combativa");

	static void Premios(Cliente cliente, String premio) {
		int precio;
		switch (premio) {
			case "Carro":
				precio = 15000;
				break;
			case "Sala-Comedor":
				precio = 400;
				break;
			case "iphone A20":
				precio = 950;
				break;
		}
		Empleado.
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
