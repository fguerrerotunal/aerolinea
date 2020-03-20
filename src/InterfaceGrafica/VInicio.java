package InterfaceGrafica;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class VInicio extends Application {

	//declaracion elementos varios
	Menu menuSalir = new Menu("Salir");
	Menu menuDescrip = new Menu("Descripccion");
	Button registro =new Button("Registrarse");
	Button ingreso =new Button("Ingresar");
	Image vidapng = new Image(getClass().getResourceAsStream(""));
	Label hojaVida = new Label("DESARROLLADORES", new ImageView(vidapng));
	Label bienvenida = new Label("AEROLINEA LUNA`S \n BIENVENIDO");
	Image fotos = new Image(getClass().getResourceAsStream(""));
	Button bfotos = new Button();

	@Override
	public void start(Stage inicio) throws Exception {
		
		//Creacion de elementos iniciales
		BorderPane root = new BorderPane();
		BorderPane left = new BorderPane();
		BorderPane right = new BorderPane();
		BorderPane topleft = new BorderPane();
		BorderPane bottomleft = new BorderPane();
		GridPane topright = new GridPane();
		BorderPane bottomright = new BorderPane();
		MenuBar menuinicio = new MenuBar();
		
		//modificacion de elementos varios
		//topright
		topright.setVgap(5);
		topright.setHgap(5);
		topright.setAlignment(Pos.CENTER);
		topright.add(registro,0,0);
		topright.add(registro,0,1);
		
		
		//bottomright 
		hojaVida.setTextFill(Color.web(""));
		hojaVida.setWrapText(true);
		hojaVida.setFont(new Font("Arial",80));
		hojaVida.setContentDisplay(ContentDisplay.BOTTOM);
		hojaVida.setMaxWidth(Double.MAX_VALUE);
		hojaVida.setMaxHeight(Double.MAX_VALUE);
		bottomright.setCenter(hojaVida);
		
		//topleft
		bienvenida.setTextFill(Color.web(""));
		bienvenida.setWrapText(true);
		bienvenida.setFont(new Font("Arial",80));
		bienvenida.setMaxWidth(Double.MAX_VALUE);
		bienvenida.setMaxHeight(Double.MAX_VALUE);
		topleft.setCenter(bienvenida);
		
		//bottomleft 
		bfotos.setGraphic(new ImageView(fotos));
		bfotos.setMaxWidth(Double.MAX_VALUE);
		bfotos.setMaxHeight(Double.MAX_VALUE);
		bottomleft.setCenter(bfotos);
		
		//oyentes de botones topright
		ToprightHandlerClass toprighthandler = new ToprightHandlerClass();
		registro.setOnAction(toprighthandler);
		ingreso.setOnAction(toprighthandler);
		
		//oyentes de hojas de vida (mouse events)
		hojaVida.setOnMouseClicked(hvidahandler);
		
		//oyentes de fotos (mouse events)
		bfotos.setOnMouseEntered(bfotoshandler);
		
		//oyentes de menu
		MenuHandlerClass menuhandler = new MenuHandlerClass();
		menuSalir.setOnAction(menuhandler);
		menuDescrip.setOnAction(menuhandler);
		
		//scene
		menuinicio.getMenus().add(menuSalir);
		menuinicio.getMenus().add(menuDescrip);
		root.setTop(menuinicio);
		left.setTop(topleft);
		left.setBottom(bottomleft);
		right.setTop(topright);
		right.setBottom(bottomright);
		root.setLeft(left);
		root.setRight(right);
		
		Scene scene = new Scene(root,300,400);
		inicio.setTitle("AEROLINEA LUNA`S");
		inicio.setScene(scene);
		inicio.show();
	}
	
	public static void main(String[] args) {
		launch(args);

	}
	
	class MenuHandlerClass implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			Object accion = e.getSource();
			if(accion instanceof Menu) {
				if(accion.equals(menuSalir)) {
					System.exit(0);
				}else {
					//donde poner la descripccion?
				}
			}
		}
	}
	
	class ToprightHandlerClass implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			Object accion = e.getSource();
			if(accion instanceof Button) {
				if(accion.equals(registro)) {
					
					//formulario registro
					
				}else {
					
					//formulario ingreso
					
				}
			}
		}
	}
	
	EventHandler<MouseEvent> hvidahandler = new EventHandler<MouseEvent>(){
		@Override
		public void handle(MouseEvent e) {
				// hvida : combio foto
			
		}
	};
	
	EventHandler<MouseEvent> bfotoshandler = new EventHandler<MouseEvent>(){
		@Override
		public void handle(MouseEvent e) {
				// bfotos: ciclo combio fotos
			
		}
	};
}
