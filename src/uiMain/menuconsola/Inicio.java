package uiMain.menuconsola;

public class Inicio extends MenuDeConsola{
	public String Mensaje() {
		return "AEROLINEA LUNA`S";
	}
	public static void main(String[] args) {
		
		Inicio inicio = new Inicio();
		MenuCliente menucliente = new MenuCliente();
		MenuCartera menucartera = new MenuCartera();
		
		UsuarioRegistrado usuarioregistrado = new UsuarioRegistrado(menucliente); // listo
		NuevoRegistro nuevoregistro = new NuevoRegistro(); //listo
		VuelosDelDia vuelos = new VuelosDelDia();  //listo
		Salir salir = new Salir();  //listo
		ComprarTiquete comprartiquete = new ComprarTiquete();  //listo
		CanjearMillas canjearmillas = new CanjearMillas();   
		HistorialDeVuelo historialdevuelo = new HistorialDeVuelo(); //listo
		Cartera cartera = new Cartera(menucartera);  //listo
		Cartera cartera1 = new Cartera();  // listo
		ModificarSilla modificarsilla = new ModificarSilla();
		ModificarEquipaje modificarequipaje = new ModificarEquipaje();
		ImprimirPasabordo imprimirpasabordo = new ImprimirPasabordo();  //listo
		Atras atras = new Atras(menucliente);  //listo
		
		inicio.opciones.add(usuarioregistrado);
		inicio.opciones.add(nuevoregistro);
		inicio.opciones.add(vuelos);
		inicio.opciones.add(salir);
		menucliente.opciones.add(comprartiquete);
		menucliente.opciones.add(canjearmillas);
		menucliente.opciones.add(historialdevuelo);
		menucliente.opciones.add(cartera);
		menucliente.opciones.add(vuelos);
		menucliente.opciones.add(salir);
		menucartera.opciones.add(cartera1);
		menucartera.opciones.add(modificarsilla);
		menucartera.opciones.add(modificarequipaje);
		menucartera.opciones.add(imprimirpasabordo);
		menucartera.opciones.add(atras);
		
		inicio.LanzarMenu();
		
	}
}