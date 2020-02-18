package gestorAplicacion;
import java.util.*;
public class Cliente extends Persona{
	CuentaMillas cuentamillas;
	int pasaporte;
	Vector<Reserva> cartera = new Vector<>();
	
	public Cliente(int identificacion, int cuentabancaria, String nombre, String direccion, String correo, int pasaporte){
		super(identificacion, cuentabancaria, nombre, direccion, correo);
		this.cuentamillas = new CuentaMillas(this,identificacion);
		this.pasaporte = pasaporte;
	}
	
	void Reservar(Vuelo vuelo) {
		this.cartera.add(new Reserva(vuelo, this));
	}
	
	String ConsultarVuelos(){
		this.A�adirHistorial("Consulta vuelos disponibles");
		return Empleado.VuelosDisponibles();
	}
	
	String ConsultarEstadoVuelos(){
		this.A�adirHistorial("Consulta estado de vuelos");
		return Empleado.EstadoVuelos();
	}
	
	void CambiarSilla(Reserva reserva, int silla) {
		reserva.setSilla(silla);
		this.A�adirHistorial("Cambio de silla en vuelo "+reserva.vuelo.numeroVuelo);
	}
	
	void CambiarEquipaje(Reserva reserva, int equipaje) {
		reserva.setEquipaje(equipaje);
	}
	
	String Pago(String medio, Reserva reserva) {

		boolean transaccion = false;
		switch (medio) {
			case "Efectivo":
				if(this.cuentabancaria.getSaldo() >= reserva.getCosto()) {
					this.cuentabancaria.setSaldo(this.cuentabancaria.getSaldo() - reserva.getCosto());
					transaccion = true;
				}
				break;
				
			case "millas":
				int millas=(int)reserva.getCosto()*2;
				if(this.cuentamillas.getMillas()  >= millas) {
					Empleado.ModMillas(reserva.pasajero, -millas);
					
					transaccion = true;
				}
				break;
		}
		if(transaccion) {
			this.A�adirHistorial("Transaccion satisfactora por $"+reserva.getCosto());
			reserva.setCosto(0);
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
					"ASIENTO: " + reserva.getSilla() + "\n";
		return A + reserva.vuelo.toString("Pasabordo");
	}

	String Cartera() {
		String cartera = "No cuentas con reservas activas por el momento.";
		if(!this.cartera.isEmpty()) {
			cartera = "";
			Iterator i = this.cartera.iterator();
			while(i.hasNext()) {
				cartera = cartera + Pasabordo((Reserva) i.next()) + "\n";
			}
		}
		return cartera;
	}
}
