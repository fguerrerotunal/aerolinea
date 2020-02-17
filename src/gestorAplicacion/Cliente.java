package gestorAplicacion;
import java.util.*;
public class Cliente extends Persona{
	CuentaMillas cuentamillas;
	int pasaporte;
	Vector<Reserva> cartera = new Vector<>();
	
	Cliente(int identificacion, int cuentabancaria, String nombre, String direccion, String correo, int pasaporte){
		super(identificacion, cuentabancaria, nombre, direccion, correo);
		this.cuentamillas = new CuentaMillas(this,identificacion);
		this.pasaporte = pasaporte;
	}
	
	void Reservar(Vuelo vuelo) {
		this.cartera.add(new Reserva(vuelo, this));
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
					reserva.costo=0;
					transaccion = true;
				}
				break;
				
			case "millas":
				int millas=(int)reserva.costo*2;
				if(this.cuentamillas.getMillas()  > millas) {
					Empleado.ModMillas(reserva.pasajero, -millas);
					reserva.costo=0;
					transaccion = true;
				}
				break;
		}
		if(transaccion) {
			return "Transaccion realizada satisfactoriamente";
		}else {
			return "Transaccion fallida";
		}
	}
	
	String CanjearMillas(String premio) {
		return Admin.Premios(this, premio);
	}
	
	String Pasabordo(Reserva reserva) {
		String A = "PASE DE ABORDAR/BOARDING PASS" +"\n"+
					"PASAJERO: " + nombre + "\n" + 
					"ASIENTO: " + reserva.silla + "\n";
		
		return A + reserva.vuelo.toString("Pasabordo");
	}
}
