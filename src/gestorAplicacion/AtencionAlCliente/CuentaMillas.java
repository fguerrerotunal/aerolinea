package gestorAplicacion.AtencionAlCliente;
import java.util.*;
import java.io.*;
public class CuentaMillas{
//Atributos de los objetos de tipo clase cuentamillas
	private static int cantidadCuentas;
	private int numeroCuenta;
	private transient Cliente titular;
	private int millas = 100;
	//Constructor
	CuentaMillas(Cliente titular, int numeroCuenta){
		this.setTitular(titular);
		this.setNumeroCuenta(numeroCuenta);
		setCantidadCuentas(getCantidadCuentas() + 1);		
	}
//Setters y getters de los atributos de la clase
	public void setMillas(int millas){
		this.millas = millas;
	}
	
	public int getMillas(){
		return millas;
	}

	public static int getCantidadCuentas() {
		return cantidadCuentas;
	}

	public static void setCantidadCuentas(int cantidadCuentas) {
		CuentaMillas.cantidadCuentas = cantidadCuentas;
	}

	public int getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public Cliente getTitular() {
		return titular;
	}

	public void setTitular(Cliente titular) {
		this.titular = titular;
	}
	
}
