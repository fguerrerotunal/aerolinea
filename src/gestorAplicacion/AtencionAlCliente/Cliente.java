package gestorAplicacion.AtencionAlCliente;

import gestorAplicacion.Master.Admin;
import gestorAplicacion.Master.Vuelo;

import java.util.*;

import Utilidades.modificarVuelo;
import Utilidades.saldoInsuficiente;
import Utilidades.sillaOcupada;
import Utilidades.tipoDato;

import java.io.*;
public class Cliente extends Persona{
	
//atributos asignados a la persona cuando esta es un cliente
	private CuentaMillas cuentamillas;
	private int pasaporte;
	public Vector<Reserva> cartera = new Vector<>();
	
	//constructor de cliente
	public Cliente(int identificacion, int cuentabancaria, String nombre, String direccion, String correo, int pasaporte){
		super(identificacion, cuentabancaria, nombre, direccion, correo);
		this.setCuentamillas(new CuentaMillas(this,identificacion));
		this.setPasaporte(pasaporte);
	}
	//devuelve un String con el Historial de vuelos con el cliente
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
	//añade un vuelo al historial del cliente
	public void AñadirHistorial(String accion) {
		this.historial.add(accion);
	}
	//añade una reserva a la cartera del cliente y imprime que su reserva se realizo,
	///de no ser posible devuelve un mensaje de que no se logro hacer esto
	public String Reservar(Vuelo vuelo) {
			if (Contarpuestos(vuelo)<20) {
				this.cartera.add(new Reserva(vuelo, this));
				return "VUELO RESERVADO SATISFACTORIAMENTE";
			}
			else {
				return "VUELOS SIN ASIENTOS DISPONIBLES";
			}	
	}
	//Metodo que retorna la lista de vuelos disponibles al hacer la consulta
	public String ConsultarVuelos(){
		return Admin.empleados.get(0).VuelosDisponibles();
	}
	//Metodo que devuelve el estado de los vuelos para al hacer la consulta
	public String ConsultarEstadoVuelos(){
		return Admin.empleados.get(0).EstadoVuelos();
	}
	//Metodo para cambiar la silla en un vuelo de un determinado usuario, utilizando su reserva
	public String CambiarSilla(Reserva reserva, int silla) {
		try{
			return reserva.setSilla(silla);
		}catch(sillaOcupada e) {
			return e.getMessage();
		}
	}
	//Metodo para cambiar el equipaje del usuario cuando este elimina el limite de equipaje(esto genera costos)
	void CambiarEquipaje(Reserva reserva) {
		reserva.setEquipaje();
	}
	//Metodo el cual se ejecuta al realizar el pago de una Reserva
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
	//Metodo que se ejecuta cuando el cliente utiliza sus millas para canjear un premio
	public String CanjearMillas(int premio) throws tipoDato {
		if(!(premio >=0 && premio <=7 )) {
			throw new tipoDato();
		}
		return Admin.Premios(this, premio);
	}
	//Metodo que imprime el tiquete o pasabordo de una Reserva de un cliente
	public String Pasabordo(Reserva reserva) {
		String A = "PASE DE ABORDAR/BOARDING PASS: "+ cartera.indexOf(reserva) +"\n"+
					"PASAJERO: " + getNombre() + "\n" + 
					"ASIENTO: " + reserva.getSilla() + "\n" + 
					"¿LIMITE EQUIPAJE?: " + reserva.getEquipaje()+"\n";
		return A + reserva.getVuelo().toString("pasabordo");
	}
//Metodo que imprime las reservas actuales que tiene el usuario 
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
	//Metodo que se ejecuta cuando un cliente quiere cancelar la reserva
	public String cancelarReserva(Reserva reserva) throws modificarVuelo{
		if (reserva.getVuelo().getEstado().equals("Venta")) {
			int retorno=reserva.Finalize();
			getCuentabancaria().add(retorno);
			return "Cancelado exitosamente";
		}
		else
			throw new modificarVuelo();
	}
	//Metodo que revisa si hay puestos disponibles en un vuelo 
	public int Contarpuestos(Vuelo vuelo) {
		int contador=0;
		for (int i=0;i<20;i++) {
			if(vuelo.getPuestos()[i]!=null) {
				contador++;
			}
		}
		return contador;
	}
	
	//metodo que presenta de forma mas organizada la info del usuario
	public String toString() {
		String mensaje = "Nombre de cliente: "
				+ this.getNombre() +"\n"
				+ "ID: "+this.getIdentificacion()+"\n"
				+ "CORREO: "+this.getCorreo()+"\n"
				+"DIRECCION: "+this.getDireccion()+"\n"
				+"# PASAPORTE: "+this.getPasaporte();
				
		return mensaje;
	}
	public String VuelosReservados() {
		String vuelosDisponibles = "#Reserva\t #Vuelo\t    Silla\t\tFecha/Hora \t Salida-Destino";
		int contador=0;
		for(Reserva i:this.cartera) {
			
			vuelosDisponibles=vuelosDisponibles+"\n\t"+contador+"\t\t"+i.getVuelo().getNumeroVuelo()+"\t\t"+i.getSilla()+"\t"+i.getVuelo().getFechaString()+
					"\t"+i.getVuelo().getSalida().getCiudad()+"-"+i.getVuelo().getDestino().getCiudad() ;
			contador++;
			}
		return vuelosDisponibles;}

//Getters y Setters de los Atributos del CLiente
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
	public Vector<Reserva> getCartera() {
		return this.cartera;
	}
}
