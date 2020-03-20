package InterfaceGrafica;

import java.lang.reflect.Array;

import javafx.scene.layout.Pane;

public class FieldPanel extends Pane {
	
	String tituloCriterios;
	String[] criterios;
	String tituloValores;
	String[]  valores;
	boolean[] habilitado;
	
	public FieldPanel(String tituloCriterios, String[] criterios, String tituloValores, String[] valores,
			boolean[] habilitado) {
		super();
		this.tituloCriterios = tituloCriterios;
		this.criterios = criterios;
		this.tituloValores = tituloValores;
		this.valores = valores;
		this.habilitado = habilitado;
	}
	
	public String getValue(String criterio) {
		String valor="";
		for(int i = 0; i< this.criterios.length;i++) {
			if(this.criterios[i].equals(criterio)) {
				valor = this.valores[i]; 
			}
		}
		return valor;
	}
	
	
}
