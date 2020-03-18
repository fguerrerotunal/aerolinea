package uiMain.menuconsola;

public class MenuCliente extends MenuDeConsola{
	
	public String Mensaje() {
		return "CLIENTE: "+ MenuDeConsola.usuarioactual.getNombre() + "\n\nSaldo Millas: " + MenuDeConsola.usuarioactual.getCuentamillas().getMillas();
	}

}
