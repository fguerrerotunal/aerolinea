
public class Cliente extends Persona{
	CuentaMillas cuentamillas;
	int pasaporte;
	Reserva cartera;
	
	Cliente(int identificacion, int cuentabancaria, String nombre, String direccion, String correo, int pasaporte){
		super(identificacion, cuentabancaria, nombre, direccion, correo);
		this.pasaporte = pasaporte;
	}
	
	
	
}
