package gestorAplicacion;

public class Reserva {
	Vuelo vuelo;
	Cliente pasajero;
	int silla;
	int equipaje;
	int costo;
	
	Reserva(Vuelo vuelo, Cliente pasajero){
		this.vuelo = vuelo;
		this.pasajero = pasajero;
	}
	
	int getSilla() {
		return silla;
	}
	
	int getEquipaje() {
		return equipaje;
	}
	
	void setSilla(int silla) {
		this.silla = silla;
		costo += 45000;
	}

	void setEquipaje(int equipaje) {
		this.equipaje = equipaje;
	}

}
