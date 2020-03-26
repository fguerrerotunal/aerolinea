package Utilidades;
/*
 * Error lanzado cuando se intenta registrar nuevamente un usuario ya existente
 */
public class registroDuplicado extends EPropios{

	public registroDuplicado() {
		super("Usuario Existente. Intentalo de nuevo");
	}

}
