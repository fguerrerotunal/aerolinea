package gestorAplicacion;

public class Reserva {
	Vuelo vuelo;
	Cliente pasajero;
	private int silla;
	private int equipaje;
	private int costo = 0;
	
	Reserva(Vuelo vuelo, Cliente pasajero){
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
	
	Reserva cambioDeSilla(Vuelo vuelo,Cliente pasajero,int Nsilla){
		this.vuelo = vuelo;
		this.pasajero = pasajero;
		this.costo += vuelo.precioTiquete;
		
			if(vuelo.puestos[Nsilla] == null) {
				
				this.vuelo.puestos[Nsilla] = this;
				this.vuelo.puestos[silla]=null;
				this.silla=Nsilla;
		}
		return this;	
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
	
	public void setSilla(int silla) {
		this.silla = silla;
		costo += 45000;
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



				
	
}


