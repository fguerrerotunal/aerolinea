
public class Cliente extends Persona{
	CuentaMillas cuentamillas;
	private int pasaporte;
	private Reserva cartera;
	
	Cliente(int identificacion, int cuentabancaria, String nombre, String direccion, String correo, int pasaporte){
		super(identificacion, cuentabancaria, nombre, direccion, correo);
		this.pasaporte = pasaporte;
	}
	
	
	
}
