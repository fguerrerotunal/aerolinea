package uiMain.menuconsola;
/*
 * esta clase es la que al llamar su metodo nos muestra el menu del cliente con sus opciones
 */
public class MenuCliente extends MenuDeConsola{
	//imprime las opciones del cliente mas el saldo de sus cuentas.
	public String Mensaje() {
		return "CLIENTE: "+ MenuDeConsola.usuarioactual.getNombre() + "\n\nSaldo Millas: " + MenuDeConsola.usuarioactual.getCuentamillas().getMillas()+"\n\nSaldo Cuenta bancaria: " + MenuDeConsola.usuarioactual.getCuentabancaria().getSaldo();
	}

}
