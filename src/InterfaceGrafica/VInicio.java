package InterfaceGrafica;

import java.io.File;

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


	public static void main(String[] args) {
		launch(args);

	}
	
	static File imagen = new File("");
	
	//stage y scenas
	Stage Vapp;
	Scene Vinicio, Vcliente;
	
	//declaracion elementos varios Vcliente
	BorderPane clientes = new BorderPane();
	MenuItem Usuario = new MenuItem("Usuario");
	MenuItem Salir = new MenuItem("Salir");
	MenuItem Acercade = new MenuItem("Acerca de");
	MenuItem comprarTiquete = new MenuItem("Comprar Tiquete");
	MenuItem historialVuelo = new MenuItem("Historal de Vuelo");
	MenuItem cartera = new MenuItem("Cartera");
	MenuItem vuelosdia = new MenuItem("Vuelos del Dia");
	MenuItem pasabordo = new MenuItem("Imprimir Pasabordo");
	MenuItem cancelreserva = new MenuItem("Cancelar Reserva");
	Label procesoAct = new Label("Nombre del proceso o consulta");
	Label consulta = new Label("Colnsultas aqui");
	FieldPanel formulario;
	
	//declaracion elementos varios inicio
	MenuItem menuSalir = new MenuItem("Salir");
	MenuItem menuDescrip = new MenuItem("Descripccion");
	Button registro =new Button("Registrarse");
	Button ingreso =new Button("Ingresar");
	//Image vidapng = new Image(getClass().getResourceAsStream("./imagenes/image.jpg"));
	//Label hojaVida = new Label("DESARROLLADORES", new ImageView(vidapng));
	Label hojaVida = new Label("DESARROLLADORES");
	Label bienvenida = new Label("AEROLINEA LUNA`S \n BIENVENIDO");
	//Image fotos = new Image(getClass().getResourceAsStream("./imagenes/image.jpg"));
	Button bfotos = new Button("puto");

	@Override
	public void start(Stage ventana) throws Exception {
		Vapp = ventana;
		
		SeparatorMenuItem separador = new SeparatorMenuItem();
		//Vclientes
		//creacion de elementos iniciales Vclientes
		MenuBar barraMenuC = new MenuBar(); 
		Menu Archivo = new Menu("Archivo");
		Menu PyC = new Menu("Procesos y Consultas");
		Menu ayuda = new Menu("Ayuda");
		
		//Modificacion Elementos varios
		Archivo.getItems().addAll(Usuario, separador, Salir);
		PyC.getItems().addAll(comprarTiquete, separador, historialVuelo, separador, cartera, separador, vuelosdia, separador, pasabordo, separador, cancelreserva);
		ayuda.getItems().add(Acercade);
		barraMenuC.getMenus().addAll(Archivo, PyC, ayuda);
		
		
		//scene cliente
		clientes.setTop(procesoAct);
		clientes.setCenter(consulta);
		clientes.setBottom(formulario);
		
		
		
		//Vinicio
		//Creacion de elementos iniciales inico
		BorderPane ventanainicio = new BorderPane();
		BorderPane left = new BorderPane();
		BorderPane right = new BorderPane();
		BorderPane topleft = new BorderPane();
		BorderPane bottomleft = new BorderPane();
		GridPane topright = new GridPane();
		BorderPane bottomright = new BorderPane();
		MenuBar barramenu = new MenuBar();
		Menu menuInicio = new Menu("Inicio");
		
		//modificacion de elementos varios
		//topright
		topright.setVgap(5);
		topright.setHgap(5);
		topright.setAlignment(Pos.CENTER);
		topright.add(registro,0,0);
		topright.add(ingreso,0,1);
		
		
		//bottomright 
		hojaVida.setTextFill(Color.RED);
		hojaVida.setWrapText(true);
		hojaVida.setFont(new Font("Arial",40));
		hojaVida.setContentDisplay(ContentDisplay.BOTTOM);
		hojaVida.setMaxWidth(Double.MAX_VALUE);
		hojaVida.setMaxHeight(Double.MAX_VALUE);
		hojaVida.setMaxWidth(400);
		hojaVida.setMaxHeight(40);
		bottomright.setCenter(hojaVida);
		
		//topleft
		bienvenida.setTextFill(Color.RED);
		bienvenida.setWrapText(true);
		bienvenida.setFont(new Font("Arial",40));
		bienvenida.setMaxWidth(Double.MAX_VALUE);
		bienvenida.setMaxHeight(Double.MAX_VALUE);
		topleft.setCenter(bienvenida);
		
		
		//bottomleft 
		//bfotos.setGraphic(new ImageView(fotos));
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
		
		//scene inicio
		menuInicio.getItems().addAll(menuSalir, separador, menuDescrip);
		barramenu.getMenus().add(menuInicio);
		topright.setPrefHeight(300);
		bottomleft.setPrefHeight(700);
		bottomright.setPrefHeight(700);
		ventanainicio.setTop(barramenu);
		left.setPrefSize(500, Double.MAX_VALUE);
		left.setTop(topleft);
		left.setBottom(bottomleft);
		right.setPrefSize(500, Double.MAX_VALUE);
		right.setTop(topright);
		right.setBottom(bottomright);
		ventanainicio.setLeft(left);
		ventanainicio.setRight(right);
		
		Scene Vinicio = new Scene(ventanainicio,1000,1000);	
		Scene Vcliente = new Scene(clientes,1000,1000);
		
		
		//cambio de escena inicio a cliente
		//Salir.setOnAction(new EventHandler<ActionEvent>() {
		//	
		//	@Override
		//	public void handle(ActionEvent event) {
		//		Vapp.setTitle("AEROLINEA LUNA`S");
		//		Vapp.setScene(Vinicio);
		//		
		//	}
		//});
				
		//cambio de escena cliente a inicio
		Salir.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				Vapp.setTitle("AEROLINEA LUNA`S");
				Vapp.setScene(Vinicio);
				
			}
		});
		
		Vapp.setTitle("AEROLINEA LUNA`S");
		Vapp.setScene(Vinicio);
		Vapp.setResizable(false);
		Vapp.show();
	}
	
	class MenuHandlerClass implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			Object accion = e.getSource();
			if(accion.equals(menuSalir)) {
				System.exit(0);
			}else {
				bienvenida.setText("descrip");
				//donde poner la descripccion?
			}
		}
	}
	
	class ToprightHandlerClass implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			Object accion = e.getSource();
			if(accion.equals(registro)) {
				bienvenida.setText("b");
				//formulario registro
			}else {
				bienvenida.setText("a");
				//formulario ingreso	
			}
		}
	}
	
	EventHandler<MouseEvent> hvidahandler = new EventHandler<MouseEvent>(){
		@Override
		public void handle(MouseEvent e) {
			hojaVida.setText("puto proyecto de mierda");
				// hvida : combio foto
			
		}
	};
	
	EventHandler<MouseEvent> bfotoshandler = new EventHandler<MouseEvent>(){
		@Override
		public void handle(MouseEvent e) {
			bienvenida.setText("asd");
			
		}
	};
}
