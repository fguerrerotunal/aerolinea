package InterfaceGrafica;
import java.io.File;
import java.util.Optional;

import Basededatos.Reader;
import Utilidades.clienteInexistente;
import gestorAplicacion.AtencionAlCliente.Cliente;
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
import javafx.scene.control.ComboBox;
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
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import uiMain.menuconsola.MenuDeConsola;
import uiMain.menuconsola.opcionesdeMenu.Autores;
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
	BorderPane clientes2 = new BorderPane();
	MenuItem Usuario = new MenuItem("Usuario");
	MenuItem Salir = new MenuItem("Salir");
	MenuItem Acercade = new MenuItem("Acerca de");
	MenuItem comprarTiquete = new MenuItem("Comprar Tiquete");
	MenuItem historialVuelo = new MenuItem("Historial de Vuelo");
	MenuItem cartera = new MenuItem("Cartera");
	MenuItem vuelosdia = new MenuItem("Vuelos del Dia");
	MenuItem pasabordo = new MenuItem("Imprimir Pasabordo");
	MenuItem cancelreserva = new MenuItem("Cancelar Reserva");
	Label procesoAct = new Label("Nombre del proceso o consulta");
	Label consulta = new Label("Colnsultas aqui");
	ButtonType Nregistro = new ButtonType("Aceptar");
	ButtonType Cregistro = new ButtonType("Cancelar");
	
	String[] criterios = new String[] {"ID", "Cuenta Bancaria", "Nombre", "Direccion","Correo","Pasaporte"};
	String[] valores = new String[] {"", "", "", "","",""};
	FieldPanel formulario = new FieldPanel("Criterio", criterios, "Valor", valores, null);
	
	//declaracion elementos varios inicio
	GridPane topright = new GridPane();
	MenuItem menuSalir = new MenuItem("Salir");
	MenuItem menuDescrip = new MenuItem("Descripccion");
	Button registro =new Button("Registrarse");
	Button ingreso =new Button("Ingresar");
	Image vidapng = new Image(getClass().getResourceAsStream("./imagenes/6.PNG"));
	Label hojaVida = new Label("DESARROLLADORES", new ImageView(vidapng));
	Label bienvenida = new Label("AEROLINEA LUNA`S");
	Image fotos = new Image(getClass().getResourceAsStream("./imagenes/0.jpg"));
	Label bfotos;
	TextField id = new TextField();
	Button Aceptar = new Button("Ingresar");
	Button Cancel = new Button("Cancelar");
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
		Label tutorial = new Label("hola");
		BorderPane tutoInicio = new BorderPane();
		
		//Modificacion Elementos varios
		barraMenuC.getMenus().addAll(Archivo, PyC, ayuda);
		Archivo.getItems().addAll(Usuario, new SeparatorMenuItem(),Salir);
		PyC.getItems().addAll(comprarTiquete, new SeparatorMenuItem(), historialVuelo, new SeparatorMenuItem(),cartera,new SeparatorMenuItem(), vuelosdia,new SeparatorMenuItem(), pasabordo,new SeparatorMenuItem(), cancelreserva);
		ayuda.getItems().add(Acercade);
		
		//oyentes de menu
		MenuClienteHandlerClass menuClientehandler = new MenuClienteHandlerClass();
		Usuario.setOnAction(menuClientehandler);
		Acercade.setOnAction(menuClientehandler);
		cartera.setOnAction(menuClientehandler);
		comprarTiquete.setOnAction(menuClientehandler);
		historialVuelo.setOnAction(menuClientehandler);
		vuelosdia.setOnAction(menuClientehandler);
		pasabordo.setOnAction(menuClientehandler);
		cancelreserva.setOnAction(menuClientehandler);
		
		
		//scene cliente
		clientes.setTop(barraMenuC);
		clientes.setCenter(clientes2);
		tutoInicio.setCenter(tutorial);
		clientes2.setTop(procesoAct);
		clientes2.setCenter(consulta);
		clientes2.setBottom(tutoInicio);
		BorderPane.setAlignment(procesoAct, Pos.CENTER);
		BorderPane.setAlignment(consulta, Pos.CENTER);
		BorderPane.setAlignment(tutoInicio, Pos.CENTER);
		
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
		hojaVida.setFont(new Font("Arial",30));
		hojaVida.setContentDisplay(ContentDisplay.BOTTOM);
		hojaVida.setMaxWidth(Double.MAX_VALUE);
		hojaVida.setMaxHeight(Double.MAX_VALUE);
		hojaVida.setMaxWidth(400);
		hojaVida.setMaxHeight(40);
		bottomright.setCenter(hojaVida);
		
		//topleft
		bienvenida.setTextFill(Color.BLACK);
		bienvenida.setWrapText(true);
		bienvenida.setFont(new Font("Arial", 16));
		bienvenida.setPrefWidth(Double.MAX_VALUE);
		bienvenida.setPrefHeight(Double.MAX_VALUE);
		bienvenida.setAlignment(Pos.BASELINE_CENTER);
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
	    Vapp.setWidth(720);
	    Vapp.setHeight(720);
	    
		menuInicio.getItems().addAll(menuSalir, new SeparatorMenuItem(), menuDescrip);
		barramenu.getMenus().add(menuInicio);
		ventanainicio.setTop(barramenu);
		
		topleft.setPrefSize(Vapp.getWidth()*0.5,Vapp.getHeight()*0.3);
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
		Cancel.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
					topright.getChildren().removeAll(id, Aceptar,Cancel);
					topright.add(registro,0,0);
					topright.add(ingreso,0,1);
			}
		});

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
					topright.getChildren().removeAll(id, Aceptar,Cancel);
					topright.getChildren().remove(0);
					topright.add(registro,0,0);
					topright.add(ingreso,0,1);
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
				MenuDeConsola.usuarioactual = null;
				topright.getChildren().removeAll(id, Aceptar,Cancel);
				topright.getChildren().remove(0);
				topright.add(registro,0,0);
				topright.add(ingreso,0,1);
				Vapp.setTitle("AEROLINEA LUNA`S");
				Vapp.setScene(Vinicio);
				
			}
		});
		
		Vapp.setTitle("AEROLINEA LUNA`S");
		Vapp.setX((bounds.getMaxX()-720)/2);
		Vapp.setY((bounds.getMaxY()-720)/2);
		Vapp.setScene(Vinicio);
		Vapp.show();

	}
	
	//handler menus
	class MenuHandlerClass implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			Object accion = e.getSource();
			if(accion.equals(menuSalir)) {
				System.exit(0);
			}else {
				bienvenida.setText(Descripccion.mensaje);
			}
		}
	}
	//formulario registro
	//formulario ingreso
	class ToprightHandlerClass implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			Label b = new Label("Identificacion");
			Object accion = e.getSource();
			if(accion.equals(registro)) {
				Alert a = new Alert(AlertType.INFORMATION);
				a.getButtonTypes().remove(0);
				a.getButtonTypes().setAll(Nregistro, Cregistro);
				a.setGraphic(formulario);
				a.setTitle("FORMULARIO REGISTRO");
				a.setHeaderText("   Ingreso de \n"
						+ "      datos");
				//handlers 
				Optional<ButtonType> result = a.showAndWait();
				if(result.get()==Nregistro) {
					formulario.GuardarDatos();
					Admin.clientes.add(new Cliente(Integer.parseInt(formulario.getValue("ID")), Integer.parseInt(formulario.getValue("Cuenta Bancaria")), formulario.getValue("Nombre"), formulario.getValue("Direccion"), formulario.getValue("Correo"), Integer.parseInt(formulario.getValue("Pasaporte"))));
					a.close();
				}else {
					a.close();
				}
			}else {
				topright.getChildren().remove(registro);
				topright.getChildren().remove(ingreso);
				id.setMaxWidth(Double.MAX_VALUE);
				topright.add(b,0,1);
				topright.add(id,0,2,2,1);
				topright.add(Aceptar,0,3);
				topright.add(Cancel,1,3);
			}
		}
	}
	
	// hvida : combio foto
	EventHandler<MouseEvent> hvidahandler = new EventHandler<MouseEvent>(){
		@Override
		public void handle(MouseEvent e) {
			
			imgposvida++;
			if(imgposvida==9) {
				imgposvida=6;
			}
			vidapng = new Image(getClass().getResourceAsStream("./imagenes/"+ imgposvida +".PNG"));
			ImageView asd = new ImageView(vidapng);
			asd.setFitWidth(Vapp.getWidth()*0.5);
			asd.setFitHeight(Vapp.getHeight()*0.7);
			hojaVida.setGraphic(asd);
		}
	};
	
	//fotos: cambio
	EventHandler<MouseEvent> bfotoshandler = new EventHandler<MouseEvent>(){
		boolean cambio = false;
		@Override
		public void handle(MouseEvent e) {
			imgpos++;
			if(imgpos==5) {
				imgpos=0;
			}				
			fotos = new Image(getClass().getResourceAsStream("./imagenes/"+ imgpos +".jpg"));
			ImageView asd = new ImageView(fotos);
			asd.setFitWidth(Vapp.getWidth()*0.5);
			asd.setFitHeight(Vapp.getHeight()*0.7);
			bfotos.setGraphic(asd);
		}
	};

	//handler menu ventana cliente
	class MenuClienteHandlerClass implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			Alert a = new Alert(AlertType.INFORMATION);
			a.setTitle("AEROLINEA LUNA`S");
			a.setHeaderText(null);
			
			clientes2.setBottom(null);
			
			String accion = (((MenuItem) e.getSource()).getText());
			switch (accion){
			case "Usuario":
				a.setContentText(MenuDeConsola.usuarioactual.toString());
				a.showAndWait();
				break;
			case "Acerca de":
				a.setContentText(Autores.getMensaje());
				a.showAndWait();
				break;
			case "Comprar Tiquete":
				GridPane V = new GridPane();
				procesoAct.setText(accion);
				consulta.setText(MenuDeConsola.usuarioactual.ConsultarVuelos());
				Label p1 = new Label("Seleccione un vuelo: ");
				V.setPrefHeight(200);
				V.setPrefWidth(Double.MAX_VALUE);
				clientes2.setBottom(V);
				V.add(p1, 0, 0);

				break;
			case "Historial de Vuelo":
				procesoAct.setText(accion);
				consulta.setText(MenuDeConsola.usuarioactual.Historial());
				break;
			case "Cartera":
				procesoAct.setText(accion);
				consulta.setText(MenuDeConsola.usuarioactual.Cartera());
				break;
			case "Vuelos del Dia":
				procesoAct.setText(accion);
				consulta.setText(Admin.empleados.get(0).EstadoVuelos());
				break;
			case "Imprimir Pasabordo":
				procesoAct.setText(accion);
				String comprobante= MenuDeConsola.usuarioactual.Cartera();
				if (comprobante.equals("No cuentas con reservas activas por el momento.")) {
					consulta.setText("llega el verano y me paso la mano");
				}
				else {
					a.setTitle("Cartera");
					a.setContentText(MenuDeConsola.usuarioactual.Cartera());
					a.showAndWait();
				}
				break;
			case "Cancelar Reserva":
				procesoAct.setText(accion);
				consulta.setText("aa");
				break;
			}
		}
	}
	
}
