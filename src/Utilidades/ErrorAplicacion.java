package Utilidades;

public class ErrorAplicacion extends Exception{
	ErrorAplicacion(String error){
		super("Manejo de errores de la aplicacion: "+error);
	}
}
