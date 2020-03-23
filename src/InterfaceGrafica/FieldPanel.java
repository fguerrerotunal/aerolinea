package InterfaceGrafica;

import java.lang.reflect.Array;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class FieldPanel extends Pane {
	
	String tituloCriterios;
	String[] criterios;
	String tituloValores;
	String[]  valores;
	boolean[] habilitado;
	
	public FieldPanel(String tituloCriterios, String[] criterios, String tituloValores, String[] valores,
			boolean[] habilitado) {
		super(new GridPane());
		this.tituloCriterios = tituloCriterios;
		this.criterios = criterios;
		this.tituloValores = tituloValores;
		//if(valores == null) {
			//this.valores = new String[criterios.length-1];
		//}else{
		this.valores = valores;
		//}
		this.habilitado = habilitado;
		
		GridPane grid = ((GridPane) this.getChildren().get(0));
		grid.setVgap(5);
		grid.setHgap(5);
		grid.setAlignment(Pos.CENTER);
		for(int i = 0; i < criterios.length;i++) {	
			grid.add(new Label(criterios[i]), 0, i);
			TextField s = new TextField("");
			try {
				s.setText(valores[i]);
				grid.add(s, 1, i);
			}catch(Exception e) {
				grid.add(s, 1, i);
			}
			try{
				if(!habilitado[i]) {
					s.setEditable(false);
				}
			}catch(Exception e){
				
			}
		}
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
	
	public void GuardarDatos(){
		GridPane grid = ((GridPane) this.getChildren().get(0));
		for(int i = 0; i < criterios.length;i++) {	
			TextField a;
			a = (TextField) grid.getChildren().get((2*i)+1);
			if(!(a.getText()).equals("")) {
				this.valores[i] = a.getText();
				a.setText("");
			}
		}
	}
	
}
