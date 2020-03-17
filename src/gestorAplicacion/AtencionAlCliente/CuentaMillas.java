package gestorAplicacion.AtencionAlCliente;
import java.util.*;
import java.io.*;
public class CuentaMillas implements Serializable {
	private static final long serialVersionUID = 1L;
	private static int cantidadCuentas;
	private int numeroCuenta;
	private Cliente titular;
	private int millas = 100;
	
	CuentaMillas(Cliente titular, int numeroCuenta){
		this.setTitular(titular);
		this.setNumeroCuenta(numeroCuenta);
		setCantidadCuentas(getCantidadCuentas() + 1);		
	}
	
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
