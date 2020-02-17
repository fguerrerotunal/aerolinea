package gestorAplicacion;
import java.util.*;
public class CuentaMillas {
	static int cantidadCuentas;
	int numeroCuenta;
	Cliente titular;
	private int millas = 100;
	
	CuentaMillas(Cliente titular, int numeroCuenta){
		this.titular = titular;
		this.numeroCuenta = numeroCuenta;
		cantidadCuentas += 1;		
	}
	
	void setMillas(int millas){
		this.millas = millas;
	}
	
	int getMillas(){
		return millas;
	}
	
}
//hola como estan..bien