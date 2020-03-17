package gestorAplicacion.AtencionAlCliente;
import java.io.*;

import gestorAplicacion.Master.Vuelo;
public class Reserva implements Serializable {

	private static final long serialVersionUID = 1L;
	private public Vuelo vuelo;
	private public Cliente pasajero;
	private int silla;
	private int equipaje;
	private int costo = 0;
	
	public Reserva(Vuelo vuelo, Cliente pasajero){
		this.vuelo = vuelo;
		this.pasajero = pasajero;
		this.costo += vuelo.precioTiquete;
		for(int i = 0; i < vuelo.puestos.length; i++) {
			if(vuelo.puestos[i] == null) {
				this.vuelo.puestos[i] = this;
				this.silla=i;
				break;
			}
			
		}	
	}
	
	
	public int getSilla() {
		return silla;
	}
	
	public int getEquipaje() {
		return equipaje;
	}
	
	public int getCosto() {
		return costo;
	}
	public Vuelo getVuelo() {
		return vuelo;
	}

	public void setSilla(int Nsilla){
		costo += 45000;
		if(vuelo.puestos[Nsilla-1] == null) {
			this.vuelo.puestos[Nsilla-1] = this;
			this.vuelo.puestos[silla]=null;
			this.silla=Nsilla-1;
		}	
		else System.out.println("La silla esta ocupada");
	}


	public void setEquipaje(int equipaje) {
		this.equipaje = equipaje;
		if(this.equipaje >= 20) {
			costo += 30000;
		}
	}
	
	public void setCosto(int costo) {
		this.costo = costo;
	}
	
	public int Finalize(){
		this.vuelo.puestos[silla]=null;
		this.pasajero.cartera.remove(this.pasajero.cartera.indexOf(this));
		return vuelo.precioTiquete;
	}

}
