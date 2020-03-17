package gestorAplicacion.AtencionAlCliente;
import gestorAplicacion.*;
import gestorAplicacion.Master.Admin;
import gestorAplicacion.Master.Vuelo;

import java.util.*;

import uiMain.menuconsola.*;
import uiMain.menuconsola.MenuDeConsola;

import java.io.*;
public class Cliente extends Persona{

	private CuentaMillas cuentamillas;
	private int pasaporte;
	public Vector<Reserva> cartera = new Vector<>();
	
	public Cliente(int identificacion, int cuentabancaria, String nombre, String direccion, String correo, int pasaporte){
		super(identificacion, cuentabancaria, nombre, direccion, correo);
		this.setCuentamillas(new CuentaMillas(this,identificacion));
		this.setPasaporte(pasaporte);
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
	
			if (Contarpuestos(vuelo)<20) {
				this.cartera.add(new Reserva(vuelo, this));
				System.out.println("VUELO RESERVADO SATISFACTORIAMENTE");
				x=true;
			}
			else {
				System.out.println("Vuelo sin asientos disponibles");
			}	
		return x;
	}
	
	public String ConsultarVuelos(){
		return Admin.empleados.get(0).VuelosDisponibles();
	}
	
	public String ConsultarEstadoVuelos(){
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
				if((this.getCuentabancaria()).getSaldo() >= costo) {
					(this.getCuentabancaria()).setSaldo((this.getCuentabancaria()).getSaldo() - costo);
					System.out.println("\nSaldo restante: "+ (this.getCuentabancaria()).getSaldo());
					transaccion = true;
				}
				break;
				
			case 1:
				int millas=(int)costo*2;
				if(this.getCuentamillas().getMillas()  >= millas) {
					Admin.empleados.get(0).ModMillas(this, -millas);
					
					transaccion = true;
				}
				break;
		}
		if(transaccion) {
			reserva.setCosto(0);
			return "Transaccion realizada satisfactoriamente";
		}else {
			this.cancelarReserva(reserva);
			this.getCuentabancaria().Actualizar();
			return "Transaccion fallida,se ha cancelado tu reserva";
		}
	}
	
	public String CanjearMillas(int premio) {
		return Admin.Premios(this, premio);
	}
	
	public String Pasabordo(Reserva reserva) {
		String A = "PASE DE ABORDAR/BOARDING PASS: "+ cartera.indexOf(reserva) +"\n"+
					"PASAJERO: " + getNombre() + "\n" + 
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
		if (reserva.vuelo.getEstado().equals("Venta")) {
		int retorno=reserva.Finalize();
		  getCuentabancaria().add(retorno);
		  return "Cancelado exitosamente";
		}
		else
			return "los vuelos solo se puede cancelar en tiempo de venta";
	}
	
	public int Contarpuestos(Vuelo vuelo) {
		int contador=0;
		for (int i=0;i<20;i++) {
			if(vuelo.getPuestos()[i]!=null) {
				contador++;
			}
		}
		return contador;
	}

	public int getPasaporte() {
		return pasaporte;
	}

	public void setPasaporte(int pasaporte) {
		this.pasaporte = pasaporte;
	}

	public CuentaMillas getCuentamillas() {
		return cuentamillas;
	}

	public void setCuentamillas(CuentaMillas cuentamillas) {
		this.cuentamillas = cuentamillas;
	}
}
