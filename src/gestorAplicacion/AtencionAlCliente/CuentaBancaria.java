package gestorAplicacion.AtencionAlCliente;
import java.io.*;
public class CuentaBancaria implements Serializable{
	private static final long serialVersionUID = 1L;
	static int cantidadCuentas;
	int numeroCuenta;
	Persona titular;
	private int saldo = 12500*4*15;
	
	CuentaBancaria(int numeroCuenta, Persona titular){
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
	
	void Actualizar(){
		saldo += 1000000*15;
	}
	void add(int nv) {
		saldo=saldo+nv;
	}

}
