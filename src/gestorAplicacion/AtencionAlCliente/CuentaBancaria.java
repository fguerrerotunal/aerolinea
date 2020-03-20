package gestorAplicacion.AtencionAlCliente;
import java.io.*;
public class CuentaBancaria{

	static int cantidadCuentas;
	private int numeroCuenta;
	transient Persona titular;
	private int saldo = 12500*4*15;
	
	public CuentaBancaria(int numeroCuenta, Persona titular){
		cantidadCuentas += 1;
		this.numeroCuenta = numeroCuenta;
		this.titular = titular;
	}
	
	public int getSaldo() {
		return saldo;
	}
	
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	
	public void Actualizar(){
		saldo += 1000000*15;
	}
	public void add(int nv) {
		saldo=saldo+nv;
	}
	public void  setCuentaB(int x){
		this.numeroCuenta = x;
	}
	public int getCuentaB() {
		return this.numeroCuenta;
	}

}
