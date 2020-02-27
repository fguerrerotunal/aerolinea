package gestorAplicacion;
import java.util.*;
public class Cliente extends Persona{
	CuentaMillas cuentamillas;
	int pasaporte;
	public Vector<Reserva> cartera = new Vector<>();
	
	public Cliente(int identificacion, int cuentabancaria, String nombre, String direccion, String correo, int pasaporte){
		super(identificacion, cuentabancaria, nombre, direccion, correo);
		this.cuentamillas = new CuentaMillas(this,identificacion);
		this.pasaporte = pasaporte;
	}
	
	public String Historial(){
		Iterator i = historial.iterator();
		String historial = "Historial de acciones de: " + nombre;
		while(i.hasNext()) {
			historial = historial + "\n" + i.next();
		}
		this.AñadirHistorial("Consulta historial de acciones");
		return historial;
	}
	
	public void AñadirHistorial(String accion) {
		this.historial.add(dateFormat.format(new Date()) + " "+ accion);
	}
	
	public void Reservar(Vuelo vuelo) {
		this.cartera.add(new Reserva(vuelo, this));
	}
	
	public String ConsultarVuelos(){
		this.AñadirHistorial("Consulta vuelos disponibles");
		return Empleado.VuelosDisponibles();
	}
	
	public String ConsultarEstadoVuelos(){
		this.AñadirHistorial("Consulta estado de vuelos");
		return Empleado.EstadoVuelos();
	}
	
	void CambiarSilla(Reserva reserva, int silla) {
		reserva.setSilla(silla);
		this.AñadirHistorial("Cambio de silla en vuelo "+reserva.vuelo.numeroVuelo);
	}
	
	void CambiarEquipaje(Reserva reserva, int equipaje) {
		reserva.setEquipaje(equipaje);
	}
	
	public String Pago(String medio, Reserva reserva) {

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
			this.AñadirHistorial("Transaccion satisfactora por $"+reserva.getCosto());
			reserva.setCosto(0);
			return "Transaccion realizada satisfactoriamente";
		}else {
			return "Transaccion fallida";
		}
	}
	
	public String CanjearMillas(int premio) {
		return Admin.Premios(this, premio);
	}
	
	public String Pasabordo(Reserva reserva) {
		String A = "PASE DE ABORDAR/BOARDING PASS" +"\n"+
					"PASAJERO: " + nombre + "\n" + 
					"ASIENTO: " + reserva.getSilla() + "\n";
		return A + reserva.vuelo.toString("Pasabordo");
	}

	public String Cartera() {
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
