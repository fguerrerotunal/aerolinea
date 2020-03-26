package Utilidades;

/*
 * Error lanzado cuando hay un campo vacio en los dististos formularios usados en la applicacion
 */
public class datoFaltante extends ESugeridos{
	
	public datoFaltante(String datoF){
		super("Asegurate de llenar todos los campos antes de continuar.\n"
				+ "Campo vacio: "+ datoF);
	}
}
