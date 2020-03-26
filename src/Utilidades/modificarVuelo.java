package Utilidades;
/*
 * Error que se lanza cuando se trata de modificar algun elemento del vuelo o la reserva
 * cuando el estado del vuelo es distinto a "Venta"
 */
public class modificarVuelo extends EPropios{

	public modificarVuelo() {
		super("Los vuelos solo se pueden cancelar en tiempo de venta");
	}
	
}
