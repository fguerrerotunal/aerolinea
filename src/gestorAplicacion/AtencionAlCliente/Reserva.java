package gestorAplicacion.AtencionAlCliente;
import java.io.*;

import Utilidades.sillaOcupada;
import gestorAplicacion.Master.Empleado;
import gestorAplicacion.Master.Vuelo;
public class Reserva{
	private int codigovuelo;
	private Vuelo vuelo;
	private Cliente pasajero;
	private int silla;
	private Boolean equipaje = true;
	private int costo = 0;
	
	//constructor por defecto
	public Reserva(Vuelo vuelo, Cliente pasajero){
		this.codigovuelo= vuelo.getNumeroVuelo();
		this.vuelo = vuelo;
		this.pasajero = pasajero;
		this.costo += vuelo.getPrecioTiquete();
		for(int i = 0; i < vuelo.getPuestos().length; i++) {
			if(vuelo.getPuestos()[i] == null) {
				this.vuelo.getPuestos()[i] = this;
				this.silla=i+1;
				break;
			}
			
		}	
	}
	
	//construcctor reservado para la base de datos
	public Reserva(int codigo,Vuelo vuelo,Cliente pasajero,int costo,boolean equipaje,int silla){
			this.codigovuelo=codigo;
			this.setvuelo(vuelo);
			this.setpasajero(pasajero);
			this.setCosto(costo);
			this.SetEquipaje(equipaje);
			try{
				this.setSilla(silla);	
			}catch(sillaOcupada e){
				
			}
	}
	
	//Getters y setters
	public int getSilla() {
		return silla;
	}
	
	public boolean getEquipaje() {
		return equipaje;
	}
	
	public int getCosto() {
		return costo;
	}
	public Vuelo getVuelo() {
		return vuelo;
	}
	
	public Cliente getPasajero() {
		return this.pasajero;
	}
	
	//cambio de silla verificando su disponibilidad antes de hacer el cambio 
	public String setSilla(int Nsilla) throws sillaOcupada{
		costo += 45000;
		if(vuelo.getPuestos()[Nsilla-1] == null) {
			this.vuelo.getPuestos()[Nsilla-1] = this;
			this.vuelo.getPuestos()[silla]=null;
			this.silla=Nsilla;
			return "CAMBIO EXITOSO";
		}else {
			throw new sillaOcupada();
		}
	}

	
	public void setEquipaje() {
		this.equipaje = false;
		costo += 30000;
	}
	
	public void SetEquipaje(boolean equipaje) {
		this.equipaje = equipaje;
	}
	
	public void setCosto(int costo) {
		this.costo = costo;
	}
	
	public int getCodigovuelo() {
		return codigovuelo;
	}
	

	public void setvuelo(Vuelo vuelo2) {
		this.vuelo=vuelo2;
		
	}

	public void setCodigovuelo(int codigovuelo) {
		this.codigovuelo = codigovuelo;
	}

	public void setpasajero(Cliente cliente) {
		this.pasajero=cliente;
	}
	
	//metodo reservado para la base de datos para cargar las reservas
	public Vuelo asignarReserva() {
		for(Vuelo i:Empleado.vuelos ) {
			if(this.getCodigovuelo()==i.getNumeroVuelo()) {
				return i;
	
			}
		}

		return vuelo ;
	}

	//cancela la reserva  
	public int Finalize(){
		this.vuelo.getPuestos()[silla]=null;
		this.pasajero.cartera.remove(this.pasajero.cartera.indexOf(this));
		return vuelo.getPrecioTiquete();
	}
}
