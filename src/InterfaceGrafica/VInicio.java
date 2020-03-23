package InterfaceGrafica;
import java.io.File;

import Basededatos.Reader;
import Utilidades.clienteInexistente;
import gestorAplicacion.Master.Admin;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.*;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import uiMain.menuconsola.MenuDeConsola;
import uiMain.menuconsola.opcionesdeMenu.Descripccion;
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
	
	String[] criterios = new String[] {"Codigo", "Nombre", "Descripción", "Ubicación"};
	FieldPanel formulario = new FieldPanel("Criterio", criterios, "Valor", null, null);
	
	//declaracion elementos varios inicio
	GridPane topright = new GridPane();
	MenuItem menuSalir = new MenuItem("Salir");
	MenuItem menuDescrip = new MenuItem("Descripccion");
	Button registro =new Button("Registrarse");
	Button ingreso =new Button("Ingresar");
	Image vidapng = new Image(getClass().getResourceAsStream("./imagenes/6.PNG"));
	Label hojaVida = new Label("DESARROLLADORES", new ImageView(vidapng));
	//Label hojaVida = new Label("DESARROLLADORES");
	Label bienvenida = new Label(Descripccion.mensaje);
	Image fotos = new Image(getClass().getResourceAsStream("./imagenes/0.jpg"));
	Label bfotos;
	TextField id = new TextField();
	Button Aceptar = new Button("Ingresar");
	int imgpos = 0;
	int imgposvida = 6;
	@Override
	public void start(Stage ventana) throws Exception {
		Reader.Leer();
		Vapp = ventana;
		
		//Vclientes
		//creacion de elementos iniciales Vclientes
		MenuBar barraMenuC = new MenuBar(); 
		Menu Archivo = new Menu("Archivo");
		Menu PyC = new Menu("Procesos y Consultas");
		Menu ayuda = new Menu("Ayuda");
		BorderPane clientes2 = new BorderPane();
		
		//Modificacion Elementos varios
		barraMenuC.getMenus().addAll(Archivo, PyC, ayuda);
		Archivo.getItems().addAll(Usuario, new SeparatorMenuItem(),Salir);
		PyC.getItems().addAll(comprarTiquete, new SeparatorMenuItem(), historialVuelo, new SeparatorMenuItem(),cartera,new SeparatorMenuItem(), vuelosdia,new SeparatorMenuItem(), pasabordo,new SeparatorMenuItem(), cancelreserva);
		ayuda.getItems().add(Acercade);
		
		//oyentes de menu
		MenuClienteHandlerClass menuClientehandler = new MenuClienteHandlerClass();
		Usuario.setOnAction(menuClientehandler);
		Acercade.setOnAction(menuClientehandler);
		
		//scene cliente
		clientes.setTop(barraMenuC);
		clientes.setCenter(clientes2);
		clientes2.setTop(procesoAct);
		clientes2.setCenter(consulta);
		clientes2.setBottom(formulario);
		BorderPane.setAlignment(procesoAct, Pos.CENTER);
		BorderPane.setAlignment(consulta, Pos.CENTER);
		BorderPane.setAlignment(formulario, Pos.CENTER);
		
		//Vinicio
		//Creacion de elementos iniciales inico
		BorderPane ventanainicio = new BorderPane();
		BorderPane left = new BorderPane();
		BorderPane right = new BorderPane();
		BorderPane topleft = new BorderPane();
		BorderPane bottomleft = new BorderPane();
		BorderPane bottomright = new BorderPane();
		MenuBar barramenu = new MenuBar();
		Menu menuInicio = new Menu("Inicio");
		
		//modificacion de elementos varios
		//topright
		registro.prefHeightProperty().bind(topright.heightProperty().multiply(0.4));
		registro.prefWidthProperty().bind(topright.widthProperty().multiply(0.4));
		ingreso.prefHeightProperty().bind(topright.heightProperty().multiply(0.4));
		ingreso.prefWidthProperty().bind(topright.widthProperty().multiply(0.4));
		topright.setVgap(5);
		topright.setHgap(5);
		topright.setAlignment(Pos.CENTER);
		topright.add(registro,0,0);
		topright.add(ingreso,0,1);
		
		
		//bottomright 
		hojaVida.setTextFill(Color.BLACK);
		hojaVida.setWrapText(true);
		hojaVida.setFont(new Font("Arial",40));
		hojaVida.setContentDisplay(ContentDisplay.BOTTOM);
		hojaVida.setMaxWidth(Double.MAX_VALUE);
		hojaVida.setMaxHeight(Double.MAX_VALUE);
		hojaVida.setMaxWidth(400);
		hojaVida.setMaxHeight(40);
		bottomright.setCenter(hojaVida);
		
		//topleft
		bienvenida.setTextFill(Color.BLACK);
		bienvenida.setWrapText(true);
		bienvenida.setFont(new Font("Arial",30));
		bienvenida.setMaxWidth(Double.MAX_VALUE);
		bienvenida.setMaxHeight(Double.MAX_VALUE);
		topleft.setCenter(bienvenida);
		
		
		//bottomleft 
		bfotos = new Label("", new ImageView(fotos));
		bfotos.setPrefWidth(Double.MAX_VALUE);
		bfotos.setPrefHeight(Double.MAX_VALUE);
		
		bottomleft.setCenter(bfotos);
		
		//oyentes de botones topright
		ToprightHandlerClass toprighthandler = new ToprightHandlerClass();
		registro.setOnAction(toprighthandler);
		ingreso.setOnAction(toprighthandler);
		//ingreso
	
		
		
		
		//oyentes de hojas de vida (mouse events)
		hojaVida.setOnMouseClicked(hvidahandler);
		
		//oyentes de fotos (mouse events)
		bfotos.setOnMouseEntered(bfotoshandler);
		
		
		//oyentes de menu
		MenuHandlerClass menuhandler = new MenuHandlerClass();
		menuSalir.setOnAction(menuhandler);
		menuDescrip.setOnAction(menuhandler);
		
		//scene inicio
		Screen screen = Screen.getPrimary();
	    Rectangle2D bounds = screen.getVisualBounds();
	    Vapp.setX(bounds.getMinX());
	    Vapp.setY(bounds.getMinY());
	    Vapp.setWidth(bounds.getWidth()*0.8);
	    Vapp.setHeight(bounds.getHeight()*0.9);
	    
		menuInicio.getItems().addAll(menuSalir, new SeparatorMenuItem(), menuDescrip);
		barramenu.getMenus().add(menuInicio);
		ventanainicio.setTop(barramenu);
		
		topleft.prefHeightProperty().bind(Vapp.heightProperty().multiply(0.3));
		topright.prefHeightProperty().bind(Vapp.heightProperty().multiply(0.3));
		bottomleft.prefHeightProperty().bind(Vapp.heightProperty().multiply(0.7));
		bottomright.prefHeightProperty().bind(Vapp.heightProperty().multiply(0.7));

		left.setTop(topleft);
		left.setBottom(bottomleft);
		right.setTop(topright);
		right.setBottom(bottomright);
		ventanainicio.setLeft(left);
		ventanainicio.setRight(right);
		
		left.prefWidthProperty().bind(Vapp.widthProperty().multiply(0.5));
		right.prefWidthProperty().bind(Vapp.widthProperty().multiply(0.5));
		
		
		//definicion scenas
		Scene Vinicio = new Scene(ventanainicio);	
		Scene Vcliente = new Scene(clientes);
		
		//cambio de escena inicio a cliente
		Aceptar.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				Alert a = new Alert(AlertType.INFORMATION);
				a.setTitle("AEROLINEA LUNA`S");
				a.setHeaderText(null);
				try{
					int posicion = Admin.BuscarCliente(Integer.valueOf(id.getText()));
					MenuDeConsola.usuarioactual = Admin.clientes.get(posicion);
					a.setContentText("Ingreso exitoso.");
					Vapp.setTitle("Cliente: " + MenuDeConsola.usuarioactual.getNombre());
					Vapp.setScene(Vcliente);
				}catch(clienteInexistente e) {
					a.setContentText(e.getMessage());
				}finally{
					a.showAndWait();
				}
					
				
			}
		});
				
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
			Label b = new Label("Identificacion");
			Object accion = e.getSource();
			if(accion.equals(registro)) {
				//formulario registro
				bienvenida.setText("b");
			}else {
				//formulario ingreso
				topright.getChildren().remove(registro);
				topright.getChildren().remove(ingreso);
				topright.add(b,0,0);
				topright.add(id,0,1);
				topright.add(Aceptar,0,2);
			}
		}
	}
	
	EventHandler<MouseEvent> hvidahandler = new EventHandler<MouseEvent>(){
		@Override
		public void handle(MouseEvent e) {
			// hvida : combio foto
			imgposvida++;
			if(imgposvida==9) {
				imgposvida=6;
			}
			vidapng = new Image(getClass().getResourceAsStream("./imagenes/"+ imgposvida +".PNG"));
			ImageView asd = new ImageView(vidapng);
			asd.setFitWidth(Vapp.getWidth()*0.5);
			asd.setFitHeight(fotos.getHeight()*0.7);
			hojaVida.setGraphic(asd);
		}
	};
	
	EventHandler<MouseEvent> bfotoshandler = new EventHandler<MouseEvent>(){
		@Override
		public void handle(MouseEvent e) {
			imgpos++;
			if(imgpos==4) {
				imgpos=0;
			}
			fotos = new Image(getClass().getResourceAsStream("./imagenes/"+ imgpos +".jpg"));
			ImageView asd = new ImageView(fotos);
			asd.setFitWidth(Vapp.getWidth()*0.5);
			asd.setFitHeight(fotos.getHeight()*0.7);
			bfotos.setGraphic(asd);
		}
	};

	
	class MenuClienteHandlerClass implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			String accion = (((MenuItem) e.getSource()).getText());
			Alert a = new Alert(AlertType.INFORMATION);
			a.setTitle("AEROLINEA LUNA`S");
			a.setHeaderText(null);
			
			switch (accion){
			case "Usuario":
				a.setContentText("asfasdfdfds");
				a.showAndWait();
				break;
			case "Acerca de":
				consulta.setText(accion);
				break;
			
			}
			//donde poner la descripccion?.
		}
	}
	
}
