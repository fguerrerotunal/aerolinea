package Utilidades;
/*
 * Error lanzado cuando el usuario no cuenta con el saldo suficiente para realizar la transaccion en curso
 * ya sea saldo en millas o en dinero normal
 */
public class saldoInsuficiente extends EPropios{
	public saldoInsuficiente() {
		super("Saldo insuficiente. Por fvor intentalo de nuevo.");
	}
}
