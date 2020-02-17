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
	
	String Pago(String medio, Reserva reserva) {
		boolean transaccion = false;
		switch (medio) {
			case "Efectivo":
				if(this.cuentabancaria.getSaldo() > reserva.costo) {
					this.cuentabancaria.setSaldo(this.cuentabancaria.getSaldo() - reserva.costo);
					transaccion = true;
				}
				break;
				
			case "millas":
				if(this.cuentamillas.millas  > reserva.costo) {
					this.cuentamillas.millas -= reserva.costo;
					transaccion = true;
				}
				break;
		}
		if(transaccion) {
			return "Pago realizado satisfactoriamente";
		}else {
			return "Saldo insuficiente";
		}
	}
	
}
