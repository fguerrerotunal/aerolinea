//esta clase se encarga de hacer los procesos de tranferecias que tiene nuestra 
//aplicacion con el usuario
package gestorAplicacion.AtencionAlCliente;
import java.io.*;
public class CuentaBancaria{
//Atributos de los objeto de tipo clase cuentabancaria
	static int cantidadCuentas;
	private int numeroCuenta;
	private transient int titular;
	private int saldo = 1000000000;
	//Constructor
	public CuentaBancaria(int numeroCuenta, int titular){
		cantidadCuentas += 1;
		this.numeroCuenta = numeroCuenta;
		this.setTitular(titular);
	}
	//actualiza el saldo del cliente
	public void Actualizar(){
		saldo += 1000000*15;
	}
	//Agrega saldo a la cuenta del cliente
	public void add(int nv) {
		saldo=saldo+nv;
	}
	//Getters y setters de la clase
	public int getSaldo() {
		return saldo;
	}
	
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public void  setCuentaB(int x){
		this.numeroCuenta = x;
	}
	public int getCuentaB() {
		return this.numeroCuenta;
	}

	public int getTitular() {
		return titular;
	}

	public void setTitular(int titular) {
		this.titular = titular;
	}

}
