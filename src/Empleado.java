
public class Empleado extends Persona{
	String ocupacion;
	
	Empleado(int identificacion, int cuentabancaria, String nombre, String direccion, String correo, String ocupacion){
		super(identificacion, cuentabancaria, nombre, direccion, correo);
		this.ocupacion = ocupacion;
	}
}
