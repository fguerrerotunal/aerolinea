package gestorAplicacion;
import java.util.*;
public class Cliente extends Persona{
	public CuentaMillas cuentamillas;
	int pasaporte;
	public Vector<Reserva> cartera = new Vector<>();
	
	public Cliente(int identificacion, int cuentabancaria, String nombre, String direccion, String correo, int pasaporte){
		super(identificacion, cuentabancaria, nombre, direccion, correo);
		this.cuentamillas = new CuentaMillas(this,identificacion);
		this.pasaporte = pasaporte;
	}
	
	public String Historial(){
		String historial = "Historial de Vuelo: \n# Vuelo \tPrecio \t Fecha/Hora \t \tSalida-Destino";
		if(!this.historial.isEmpty()) {
			Iterator i = this.historial.iterator();
			while(i.hasNext()) {
				historial = historial + "\n" + (String)i.next();
			}
		}
		return historial;
	}
	
	public void AñadirHistorial(String accion) {
		this.historial.add(accion);
	}
	
	public void Reservar(Vuelo vuelo) {
		this.cartera.add(new Reserva(vuelo, this));
	}
	
	public String ConsultarVuelos(){
		//this.AñadirHistorial("Consulta vuelos disponibles");
		return Admin.empleados.get(0).VuelosDisponibles();
	}
	
	public String ConsultarEstadoVuelos(){
		//this.AñadirHistorial("Consulta estado de vuelos");
		return Admin.empleados.get(0).EstadoVuelos();
	}
	
	public void CambiarSilla(Reserva reserva, int silla) {
		reserva.setSilla(silla);
	}
	
	void CambiarEquipaje(Reserva reserva, int equipaje) {
		reserva.setEquipaje(equipaje);
	}
	
	public String Pago(String medio) {

		boolean transaccion = false;
		int costo = this.Deuda();
		switch (medio) {
			case "Efectivo":
				if(this.cuentabancaria.getSaldo() >= costo) {
					this.cuentabancaria.setSaldo(this.cuentabancaria.getSaldo() - costo);
					transaccion = true;
				}
				break;
				
			case "millas":
				int millas=(int)costo*2;
				if(this.cuentamillas.getMillas()  >= millas) {
					Admin.empleados.get(0).ModMillas(this, -millas);
					
					transaccion = true;
				}
				break;
		}
		if(transaccion) {
			if(!this.cartera.isEmpty()) {
				Iterator i = this.cartera.iterator();
				while(i.hasNext()) {
					((Reserva) i.next()).setCosto(0);
				}
			}
			return "Transaccion realizada satisfactoriamente";
		}else {
			return "Transaccion fallida";
		}
	}
	
	public String CanjearMillas(int premio) {
		return Admin.Premios(this, premio);
	}
	
	public String Pasabordo(Reserva reserva) {
		String A = "PASE DE ABORDAR/BOARDING PASS: "+ cartera.indexOf(reserva) +"\n"+
					"PASAJERO: " + nombre + "\n" + 
					"ASIENTO: " + reserva.getSilla() + "\n";
		return A + reserva.vuelo.toString("pasabordo");
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
	
	public void cancelarReserva(Reserva reserva) {
		int retorno=reserva.Finalize();
		  cuentabancaria.add(retorno);
	}
	
	public int Deuda() {
		int deuda = 0;
		if(!this.cartera.isEmpty()) {
			Iterator i = this.cartera.iterator();
			while(i.hasNext()) {
				deuda +=  ((Reserva) i.next()).getCosto();
			}
		}
		return deuda;
	}
}
