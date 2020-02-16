
public class CuentaBancaria {
	static int cantidadCuentas;
	int numeroCuenta;
	Persona titular;
	int saldo = 12500*4*15;
	
	CuentaBancaria(int numeroCuenta, Persona titular){
		cantidadCuentas += 1;
		this.numeroCuenta = numeroCuenta;
		this.titular = titular;
	}
	
	int getSaldo() {
		return saldo;
	}
	
	void Actualizar(){
		saldo += 12500*15;
	}
	
}
