package gestorAplicacion;
import java.util.*;
import uiMain.menuconsola.*;
import uiMain.menuconsola.MenuDeConsola;

import java.io.*;
public class Cliente extends Persona implements Serializable{
	private static final long serialVersionUID = 1L;
	public CuentaMillas cuentamillas;
	int pasaporte;
	public Vector<Reserva> cartera = new Vector<>();
	
	public Cliente(int identificacion, int cuentabancaria, String nombre, String direccion, String correo, int pasaporte){
		super(identificacion, cuentabancaria, nombre, direccion, correo);
		this.cuentamillas = new CuentaMillas(this,identificacion);
		this.pasaporte = pasaporte;
	}
	
	public String Historial(){
		String historial = "AUN NO HAS USADO NUESTROS SERVICIOS";
		if(!this.historial.isEmpty()) {
			historial = "Historial de Vuelo: \n# Vuelo \tPrecio \t Fecha/Hora \t \tSalida-Destino";
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
	
	public Boolean Reservar(Vuelo vuelo) {
		Boolean x = false;
		if(vuelo.estado.equals("Venta")) {
			if (Contarpuestos(vuelo)<20) {
				this.cartera.add(new Reserva(vuelo, this));
				System.out.println("VUELO RESERVADO SATISFACTORIAMENTE");
				x=true;
			}
			else {
				System.out.println("Vuelo sin asientos disponibles");
			}
		}
		else {
			System.out.println("Este vuelo ya no esta a la venta");
		}	
		return x;
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
	
	public String Pago(int medio, Reserva reserva) {

		boolean transaccion = false;
		int costo = reserva.getCosto();
		switch (medio) {
			case 0:
				if(this.cuentabancaria.getSaldo() >= costo) {
					this.cuentabancaria.setSaldo(this.cuentabancaria.getSaldo() - costo);
					System.out.println("\nSaldo restante: "+this.cuentabancaria.getSaldo());
					transaccion = true;
				}
				break;
				
			case 1:
				int millas=(int)costo*2;
				if(this.cuentamillas.getMillas()  >= millas) {
					Admin.empleados.get(0).ModMillas(this, -millas);
					
					transaccion = true;
				}
				break;
		}
		if(transaccion) {
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
	
	public String cancelarReserva(Reserva reserva) {
		if (reserva.vuelo.estado.equals("Venta")) {
		int retorno=reserva.Finalize();
		  cuentabancaria.add(retorno);
		  return "Cancelado exitosamente";
		}
		else
			return "los vuelos solo se puede cancelar en tiempo de venta";
	}
	
	public int Contarpuestos(Vuelo vuelo) {
		int contador=0;
		for (int i=0;i<20;i++) {
			if(vuelo.puestos[i]!=null) {
				contador++;
			}
		}
		System.out.println("Asientos"+contador);
		return contador;
	}
}
