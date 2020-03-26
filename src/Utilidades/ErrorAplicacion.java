package Utilidades;
/*
 * clase error propuesta en los requerimientos de la entrega
 */
public class ErrorAplicacion extends Exception{
	ErrorAplicacion(String error){
		super("Manejo de errores de la aplicacion: "+error);
	}
}
