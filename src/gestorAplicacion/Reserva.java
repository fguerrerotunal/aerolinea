package gestorAplicacion;

public class Reserva {
	public Vuelo vuelo;
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
		if(vuelo.puestos[Nsilla] == null) {
			this.vuelo.puestos[Nsilla] = this;
			this.vuelo.puestos[silla]=null;
			this.silla=Nsilla;
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
