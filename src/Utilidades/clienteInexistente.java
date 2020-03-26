package Utilidades;

/*
 * Error lanzado cuando se intenta ingresar a la aplicacion con un id
 * no registrado 
 */
public class clienteInexistente extends EPropios{

	public clienteInexistente() {
		super("Usuario inexistente. Comprueba los datos");
	}
}
