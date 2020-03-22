package gestorAplicacion.AtencionAlCliente;

import gestorAplicacion.Master.Admin;
import gestorAplicacion.Master.Vuelo;

import java.util.*;

import Utilidades.modificarVuelo;
import Utilidades.saldoInsuficiente;
import Utilidades.sillaOcupada;

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
	
	public String Reservar(Vuelo vuelo) {
			if (Contarpuestos(vuelo)<20) {
				this.cartera.add(new Reserva(vuelo, this));
				return "VUELO RESERVADO SATISFACTORIAMENTE";
			}
			else {
				return "VUELOS SIN ASIENTOS DISPONIBLES";
			}	
	}
	
	public String ConsultarVuelos(){
		return Admin.empleados.get(0).VuelosDisponibles();
	}
	
	public String ConsultarEstadoVuelos(){
		return Admin.empleados.get(0).EstadoVuelos();
	}
	
	public String CambiarSilla(Reserva reserva, int silla) {
		try{
			return reserva.setSilla(silla);
		}catch(sillaOcupada e) {
			return e.getMessage();
		}
	}
	
	void CambiarEquipaje(Reserva reserva) {
		reserva.setEquipaje();
	}
	
	public String Pago(int medio, Reserva reserva) throws saldoInsuficiente {
		
		boolean transaccion = false;
		int costo = reserva.getCosto();
		switch (medio) {
			case 0:
				if((this.getCuentabancaria()).getSaldo() >= costo) {
					(this.getCuentabancaria()).setSaldo((this.getCuentabancaria()).getSaldo() - costo);
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
			this.cartera.remove(reserva);
			this.getCuentabancaria().Actualizar();
			throw new saldoInsuficiente();
		}
		
	}
	
	public String CanjearMillas(int premio) {
		return Admin.Premios(this, premio);
	}
	
	public String Pasabordo(Reserva reserva) {
		String A = "PASE DE ABORDAR/BOARDING PASS: "+ cartera.indexOf(reserva) +"\n"+
					"PASAJERO: " + getNombre() + "\n" + 
					"ASIENTO: " + reserva.getSilla() + "\n" + 
					"¿LIMITE EQUIPAJE?: " + reserva.getEquipaje()+"\n";
		return A + reserva.getVuelo().toString("pasabordo");
	}

	public String Cartera() {
		String cartera = "No cuentas con reservas activas por el momento.";
		if(!this.cartera.isEmpty()) {
			cartera = "";
			Iterator<Reserva> i = this.cartera.iterator();
			while(i.hasNext()) {
				cartera = cartera + Pasabordo((Reserva) i.next()) + "\n";
			}
		}
		return cartera;
	}
	
	public String cancelarReserva(Reserva reserva) throws modificarVuelo{
		if (reserva.getVuelo().getEstado().equals("Venta")) {
			int retorno=reserva.Finalize();
			getCuentabancaria().add(retorno);
			return "Cancelado exitosamente";
		}
		else
			throw new modificarVuelo();
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
