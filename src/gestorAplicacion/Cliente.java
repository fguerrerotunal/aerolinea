package gestorAplicacion;
import java.util.*;
public class Cliente extends Persona{
	CuentaMillas cuentamillas;
	int pasaporte;
	Vector<Reserva> cartera = new Vector<>();
	
	Cliente(int identificacion, int cuentabancaria, String nombre, String direccion, String correo, int pasaporte){
		super(identificacion, cuentabancaria, nombre, direccion, correo);
		this.pasaporte = pasaporte;
	}
	
	String ConsultarVuelos(){
		return Empleado.VuelosDisponibles();
	}
	
	void CambiarSilla(Reserva reserva, int silla) {
		reserva.setSilla(silla);
	}
	
	void CambiarEquipaje(Reserva reserva, int equipaje) {
		reserva.setEquipaje(equipaje);
	}
	
}
