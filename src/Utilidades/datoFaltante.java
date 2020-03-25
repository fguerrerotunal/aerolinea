package Utilidades;

public class datoFaltante extends ESugeridos{
	
	public datoFaltante(String datoF){
		super("Asegurate de llenar todos los campos antes de continuar.\n"
				+ "Campo vacio: "+ datoF);
	}
}
