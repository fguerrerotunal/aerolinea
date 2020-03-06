package gestorAplicacion.AtencionAlCliente;
import java.util.*;
import java.io.*;
public class CuentaMillas implements Serializable {
	private static final long serialVersionUID = 1L;
	static int cantidadCuentas;
	int numeroCuenta;
	Cliente titular;
	private int millas = 100;
	
	CuentaMillas(Cliente titular, int numeroCuenta){
		this.titular = titular;
		this.numeroCuenta = numeroCuenta;
		cantidadCuentas += 1;		
	}
	
	public void setMillas(int millas){
		this.millas = millas;
	}
	
	public int getMillas(){
		return millas;
	}
	
}
