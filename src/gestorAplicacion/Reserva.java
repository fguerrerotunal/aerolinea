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
				break;
			}
			
		}
			
			
			
			
		//this.vuelo.puestos.add(this);
	}
	
	int getSilla() {
		return silla;
	}
	
	int getEquipaje() {
		return equipaje;
	}
	
	int getCosto() {
		return costo;
	}
	
	void setSilla(int silla) {
		this.silla = silla;
		costo += 45000;
	}

	void setEquipaje(int equipaje) {
		this.equipaje = equipaje;
		if(this.equipaje >= 20) {
			costo += 30000;
		}
	}
	
	void setCosto(int costo) {
		this.costo = costo;
	}

}
