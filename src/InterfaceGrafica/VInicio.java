package InterfaceGrafica;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;


import Basededatos.Reader;
import Basededatos.Writer;
import Utilidades.clienteInexistente;
import Utilidades.datoFaltante;
import Utilidades.modificarVuelo;
import Utilidades.registroDuplicado;
import Utilidades.saldoInsuficiente;
import Utilidades.tipoDato;
import gestorAplicacion.AtencionAlCliente.Cliente;
import gestorAplicacion.AtencionAlCliente.Reserva;
import gestorAplicacion.Master.Admin;
import gestorAplicacion.Master.Empleado;
import gestorAplicacion.Master.Vuelo;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;
import uiMain.menuconsola.MenuDeConsola;
import uiMain.menuconsola.opcionesdeMenu.Autores;
import uiMain.menuconsola.opcionesdeMenu.Descripccion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class VInicio extends Application {


	public static void main(String[] args) {
		Reader.Leer();
		Timer timer = new Timer();
		TimerTask estadoVuelos =  new TimerTask() {
			public void run() {
				Admin.empleados.get(0).ActualizarVuelos();
			}
		};

		timer.schedule(estadoVuelos, 60000,60000);//cada 1 min
		
		Admin.premios.add("Silla: 50");
		Admin.premios.add("Mercado: 100");
		Admin.premios.add("Olla de arroz:  200");
		Admin.premios.add("Computador: 300");
		Admin.premios.add("Nevera: 500");
		Admin.premios.add("Viaje gratis: 800");
		Admin.premios.add("Viaje en pareja: 1000");
		Admin.premios.add("Viaje Familiar(max 4): 1200");
		//Admin.Reiniciar();
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
	MenuItem canjearPremio = new MenuItem("Canjear Premio");
	Label procesoAct = new Label("Nombre del proceso o consulta");
	Label consulta = new Label("Consultas");
	ButtonType Nregistro = new ButtonType("Aceptar");
	ButtonType Cregistro = new ButtonType("Cancelar");
	
	
	//declaracion elementos varios inicio
	GridPane topright = new GridPane();
	MenuItem menuSalir = new MenuItem("Salir");
	MenuItem menuDescrip = new MenuItem("Descripcion");
	Button registro =new Button("Registrarse");
	Button ingreso =new Button("Ingresar");
	Image vidapng;
	Label hojaVida;
	Label bienvenida = new Label("AEROLINEA LUNA`S\n"
			+ "     BIENVENIDO");
	Image fotos;
	Label bfotos;
	TextField id = new TextField();
	Button Aceptar = new Button("Ingresar");
	Button Cancel = new Button("Cancelar");
	int imgpos = 0;
	int imgposvida = 6;
	
	
	@Override
	public void start(Stage ventana) throws Exception {
		
		Vapp = ventana;
		//imagenes
		vidapng = new Image(new FileInputStream(System.getProperty("user.dir") + "\\src\\InterfaceGrafica\\imagenes\\6.PNG"));
		hojaVida = new Label("DESARROLLADORES", new ImageView(vidapng));
		fotos = new Image(new FileInputStream(System.getProperty("user.dir") + "\\src\\InterfaceGrafica\\imagenes\\0.jpg"));
		
		
		//Vclientes
		//creacion de elementos iniciales Vclientes
		MenuBar barraMenuC = new MenuBar(); 
		Menu Archivo = new Menu("Archivo");
		Menu PyC = new Menu("Procesos y Consultas");
		Menu ayuda = new Menu("Ayuda");

		Label tutorial = new Label("                 En esta aplicación el usuario tendrá la capacidad de comprar vuelos,\n"
				+ " revisar y cancelar los ya pagados, además podrá canjear sus millas por diferentes premios.\n"
				+ " en la parte superior se encuentra los menús donde podrá acceder a estas funcionalidades*.\n"
				+ " *Algunas funcionalidades pueden generar costos extra.");
		tutorial.setFont(new Font(STYLESHEET_CASPIAN,15));

		BorderPane tutoInicio = new BorderPane();
		
		//Modificacion Elementos varios
		barraMenuC.getMenus().addAll(Archivo, PyC, ayuda);
		Archivo.getItems().addAll(Usuario, new SeparatorMenuItem(),Salir);
		PyC.getItems().addAll(comprarTiquete,new SeparatorMenuItem(), canjearPremio, new SeparatorMenuItem(), historialVuelo, new SeparatorMenuItem(),cartera,new SeparatorMenuItem(), vuelosdia,new SeparatorMenuItem(), pasabordo,new SeparatorMenuItem(), cancelreserva);
		ayuda.getItems().add(Acercade);
		
		//PROBAR LETRAS Y COLOR
		procesoAct.setTextFill(Color.GRAY);
		procesoAct.setFont(new Font("Agency FB",40));	
		consulta.setTextFill(Color.GRAY);
		consulta.setFont(new Font("Agency FB",20));
		
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
		canjearPremio.setOnAction(menuClientehandler);
		
		//scene cliente
		clientes.setTop(barraMenuC);
		clientes.setCenter(clientes2);
		tutoInicio.setCenter(tutorial);
		clientes2.setTop(procesoAct);
		clientes2.setCenter(consulta);
		clientes2.setBottom(tutoInicio);
		//PROBAR COLORES
		clientes2.setStyle("-fx-background-color: LIGHTGRAY;");
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
		
		
		Cancel.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
					topright.getChildren().removeAll(id, Aceptar,Cancel);
					topright.add(registro,0,0);
					topright.add(ingreso,0,1);
			}
		});
		
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
					topright.getChildren().removeAll(id, Aceptar,Cancel);
					topright.getChildren().remove(0);
					topright.add(registro,0,0);
					topright.add(ingreso,0,1);
					a.setContentText(e.getMessage());
				}catch(NumberFormatException e){
            		tipoDato error = new tipoDato();
            		a.setContentText(error.getMessage());
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
				clientes2.setTop(procesoAct);
				clientes2.setCenter(consulta);
				procesoAct.setText("Nombre del proceso o consulta");
				consulta.setText("Consultas");
				clientes2.setBottom(tutoInicio);
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
				Writer.Escribir();
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
				a.getButtonTypes().setAll(Cregistro);
				
				String[] criterios = new String[] {"ID", "Cuenta Bancaria", "Nombre", "Direccion","Correo","Pasaporte"};
				String identificacionAut = String.valueOf(Admin.clientes.size()+1);
				String[] valores = new String[] {identificacionAut, "", "", "","",""};
				boolean[] habilitados = new boolean[] {false};
				FieldPanel formularioRegis = new FieldPanel("Criterio", criterios, "Valor", valores, habilitados);
				a.setGraphic(formularioRegis);
				a.setTitle("FORMULARIO REGISTRO");
				a.setHeaderText("   Ingreso de \n"
						+ "      datos");
				//handlers 
				ObservableList<Node> asd = ((GridPane) formularioRegis.getChildren().get(0)).getChildren();
				((Button)asd.get(asd.size()-2)).setOnMouseClicked(new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent event) {
                    	a.close();
                    	a.setGraphic(null);
                    	a.setHeaderText(null);
                    	try{
                    		formularioRegis.GuardarDatos();
                    		try {
                    			Admin.BuscarCliente(Integer.parseInt(formularioRegis.getValue("ID")));
                			throw new registroDuplicado();
                    		}catch(clienteInexistente e){
                    			Admin.clientes.add(new Cliente(Integer.parseInt(formularioRegis.getValue("ID")), Integer.parseInt(formularioRegis.getValue("Cuenta Bancaria")), formularioRegis.getValue("Nombre"), formularioRegis.getValue("Direccion"), formularioRegis.getValue("Correo"), Integer.parseInt(formularioRegis.getValue("Pasaporte"))));
                    			a.setContentText("Registrado Correctamente.");
                    		}catch(registroDuplicado e) {
                    			a.setContentText(e.getMessage());
                    		}
                    	}catch(datoFaltante e){
                    		a.setContentText(e.getMessage());
                    	}catch(NumberFormatException e){
                    		tipoDato error = new tipoDato();
                    		a.setContentText(error.getMessage());
                    	}finally {
                    		a.show();
                    	}
                    }});
				try {
					Optional<ButtonType> result = a.showAndWait();
					if(result.get()==Cregistro) {
						a.close();
					}
				}catch(Exception q){
					
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
			try {
				vidapng = new Image(new FileInputStream(System.getProperty("user.dir") + "\\src\\InterfaceGrafica\\imagenes\\"+ imgposvida +".PNG"));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ImageView asd = new ImageView(vidapng);
			asd.setFitWidth(Vapp.getWidth()*0.5);
			asd.setFitHeight(Vapp.getHeight()*0.7);
			hojaVida.setGraphic(asd);
		}
	};
	
	//fotos: cambio
	EventHandler<MouseEvent> bfotoshandler = new EventHandler<MouseEvent>(){
		@Override
		public void handle(MouseEvent e) {
			imgpos++;
			if(imgpos==5) {
				imgpos=0;
			}				
			try {
				fotos = new Image(new FileInputStream(System.getProperty("user.dir") + "\\src\\InterfaceGrafica\\imagenes\\"+ imgpos +".jpg"));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
			GridPane V = new GridPane();
			V.setVgap(5);
			V.setHgap(5);
			V.setAlignment(Pos.TOP_CENTER);
			V.setPrefHeight(Vapp.getHeight()*0.1);
			V.setPrefWidth(Vapp.getWidth()*0.2);
			
			ScrollPane aux = new ScrollPane();
			Button Act= new Button("Actualizar");
			GridPane auxgrid;
			Alert a = new Alert(AlertType.INFORMATION);
			a.setTitle("AEROLINEA LUNA`S");
			a.setHeaderText(null);
			clientes2.setCenter(consulta);
			aux.setContent(null);
			clientes2.setBottom(null);
			clientes2.setRight(null);
			consulta.setText("");
			consulta.setFont(new Font("Agency FB",20));
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
				V.getChildren().removeAll(V.getChildren());
				Button F = new Button(">>>");
				BorderPane.setAlignment(F, Pos.CENTER);
				clientes2.setRight(F);
				Button Acp = new Button("Aceptar");
				Button Cancelr = new Button("Cancelar");
				Button Silla = new Button("Cambiar silla");
				Button Con = new Button("Continuar");
				procesoAct.setText(accion);
				ComboBox<Integer> P = new ComboBox<Integer>();
				P.getItems().setAll(datos());
				//Boton que recargar consultar Vuelos disponibles
				Act.setOnMouseClicked((new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						consulta.setText(MenuDeConsola.usuarioactual.ConsultarVuelos());
						P.getItems().setAll(datos());
						P.getSelectionModel().selectFirst();
					} 
				}));
				F.setOnMouseClicked((new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						Admin.empleados.get(0).ActualizarVuelos();
						consulta.setText(MenuDeConsola.usuarioactual.ConsultarVuelos());
						P.getItems().setAll(datos());
						P.getSelectionModel().selectFirst();
					} 
				}));
				ComboBox<Integer> Si = new ComboBox<Integer>();
	    		Si.getItems().addAll(
	    			    1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20
	    			);
	    		ComboBox<String> Le = new ComboBox<String>();
	    		Le.getItems().addAll(
	    			    "SI","NO"
	    			);
	    		Le.getSelectionModel().select(0);
				consulta.setText(MenuDeConsola.usuarioactual.ConsultarVuelos());
				Label p1 = new Label("Seleccione una posicion:");
				Label p2 = new Label("Seleccione una silla: ");
				Label p3 = new Label("¿Limite de equipaje?: ");
				clientes2.setBottom(V);
				Act.setMaxWidth(Double.MAX_VALUE);
				Acp.setMaxWidth(Double.MAX_VALUE);
				Cancelr.setMaxWidth(Double.MAX_VALUE);
				Silla.setMaxWidth(Double.MAX_VALUE);
				Con.setMaxWidth(Double.MAX_VALUE);
				V.add(p1, 0, 3);
				V.add(P, 1, 3);
				V.add(Act, 0, 0,2,1);
				V.add(Acp, 6, 0,2,1);
				//confirma y verifica el vuelo selecionado
				Acp.setOnMouseClicked((new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						
						try{
							String verificacion = MenuDeConsola.usuarioactual.Reservar(Empleado.vuelos.get(P.getValue()));
							V.getChildren().removeAll(V.getChildren());
							
							//mostrar silla por defecto
							Si.getSelectionModel().select(MenuDeConsola.usuarioactual.cartera.get(MenuDeConsola.usuarioactual.cartera.size()-1).getSilla()-1);
							clientes2.setRight(null);
							int x=P.getValue();
							P.getItems().setAll(x);
							V.add(p1, 0, 3);
							V.add(P, 1, 3);
							V.add(p3, 6, 3);
							V.add(Le, 7,3);
							V.add(Cancelr,0,0,2,1);
							V.add(Silla,3,0,2,1);
							V.add(Con,6,0,2,1);
							V.add(p2, 3, 3);
							V.add(Si, 4,3);
							Reserva reserva = MenuDeConsola.usuarioactual.cartera.get(MenuDeConsola.usuarioactual.cartera.size()-1);
							consulta.setText(MenuDeConsola.usuarioactual.Pasabordo(reserva) +"\n"+reserva.getVuelo().toString("sillas"));
							procesoAct.setText("Su Tiquete es:");
							a.setContentText(verificacion);
							a.showAndWait();
							if(!(verificacion.equals("VUELO RESERVADO SATISFACTORIAMENTE"))){
								
								V.getChildren().removeAll(V.getChildren());
								V.add(p1, 0, 3);
								V.add(P, 1, 3);
								V.add(Act, 0, 0,2,1);
								V.add(Acp, 6, 0,2,1);
							}
						}catch(NullPointerException e) {
							datoFaltante error = new datoFaltante("Numero de vuelo");
	                   		a.setContentText(error.getMessage());
	                   		a.showAndWait();
							}
					}
					
					
				}));
				//boton que confirma el cambio de la silla
				Silla.setOnMouseClicked((new EventHandler<MouseEvent>() {
					
					@Override
					public void handle(MouseEvent event) {
						a.setContentText("Esta Accion puede generar costos desea continuar");
                		a.showAndWait();
                		Reserva reserva = MenuDeConsola.usuarioactual.cartera.get(MenuDeConsola.usuarioactual.cartera.size()-1);
						
						//cambio silla
                		String verifCambioSilla = MenuDeConsola.usuarioactual.CambiarSilla(reserva, Si.getValue());
						
						consulta.setText(MenuDeConsola.usuarioactual.Pasabordo(reserva) +"\n"+reserva.getVuelo().toString("sillas"));
						a.setContentText(verifCambioSilla);
						a.showAndWait();
						
						
					}
				}));
				//boton que cancela por si te arrepientes de reserver
				Cancelr.setOnMouseClicked((new EventHandler<MouseEvent>() {
					
					@Override
					public void handle(MouseEvent event) {
						BorderPane.setAlignment(F, Pos.CENTER);
						clientes2.setRight(F);
						procesoAct.setText(accion);
						P.getItems().setAll(datos());
						P.getSelectionModel().selectFirst();
						V.getChildren().removeAll(V.getChildren());
						V.add(p1, 0, 3);
						V.add(P, 1, 3);
						V.add(Act, 0, 0,2,1);
						V.add(Acp, 6, 0,2,1);
						Reserva reserva = MenuDeConsola.usuarioactual.cartera.get(MenuDeConsola.usuarioactual.cartera.size()-1);
						reserva.Finalize();
						consulta.setText(MenuDeConsola.usuarioactual.ConsultarVuelos());
						a.setContentText("OPERACION CANCELADA");
						a.showAndWait();
					}
				}));
				//bonton que te manda al proceso de pago
				Con.setOnMouseClicked((new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						procesoAct.setText(accion);
						P.getItems().setAll(datos());
						P.getSelectionModel().selectFirst();
						V.getChildren().removeAll(V.getChildren());
						Button efectivo = new Button("Efectivo");
						Button millas = new Button("Millas");
						V.add(efectivo, 0, 0);
						V.add(millas, 1, 0);
						consulta.setText("seleccione metodo de pago.");
						Reserva reserva = MenuDeConsola.usuarioactual.cartera.get(MenuDeConsola.usuarioactual.cartera.size()-1);
						
						if(Le.getValue().equals("NO")) {
							reserva.setEquipaje();
						}
						
						efectivo.setOnMouseClicked((new EventHandler<MouseEvent>() {
							@Override
							public void handle(MouseEvent event) {
								try{
									a.setContentText(MenuDeConsola.usuarioactual.Pago(0,reserva));
								}catch(saldoInsuficiente e) {
									a.setContentText(e.getMessage());
								}finally {
									consulta.setText(MenuDeConsola.usuarioactual.ConsultarVuelos());
									V.getChildren().removeAll(V.getChildren());
									BorderPane.setAlignment(F, Pos.CENTER);
									clientes2.setRight(F);
									V.add(p1, 0, 3);
									V.add(P, 1, 3);
									V.add(Act, 0, 0,2,1);
									V.add(Acp, 6, 0,2,1);
									a.showAndWait();
								}
							}
							
						}));
						
						millas.setOnMouseClicked((new EventHandler<MouseEvent>() {
							@Override
							public void handle(MouseEvent event) {
								try{
									a.setContentText(MenuDeConsola.usuarioactual.Pago(1,reserva));
								}catch(saldoInsuficiente e) {
									a.setContentText(e.getMessage());
								}finally {
									consulta.setText(MenuDeConsola.usuarioactual.ConsultarVuelos());
									V.getChildren().removeAll(V.getChildren());
									BorderPane.setAlignment(F, Pos.CENTER);
									clientes2.setRight(F);
									V.add(p1, 0, 3);
									V.add(P, 1, 3);
									V.add(Act, 0, 0,2,1);
									V.add(Acp, 6, 0,2,1);
									a.showAndWait();
								}
							}
							
						}));
					}
				}));
				break;
			case "Vuelos del Dia":
				V.getChildren().removeAll(V.getChildren());
				V.add(Act, 0, 0);
				V.setAlignment(Pos.TOP_CENTER);
				clientes2.setBottom(V);
				procesoAct.setText(accion);
				consulta.setText(Admin.empleados.get(0).EstadoVuelos());
				Act.setOnMouseClicked((new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						consulta.setText(Admin.empleados.get(0).EstadoVuelos());
					} 
				}));
				break;
			case "Historial de Vuelo":
				procesoAct.setText(accion);
				consulta.setText(MenuDeConsola.usuarioactual.Historial());
				break;
			case "Cartera":
				procesoAct.setText(accion);
				consulta.setText(MenuDeConsola.usuarioactual.Cartera());
				consulta.setAlignment(Pos.CENTER);
				aux.setContent(consulta);
				clientes2.setCenter(aux);
				consulta.setPrefWidth(clientes2.getWidth());
				break;
			case "Imprimir Pasabordo":
				V.getChildren().removeAll(V.getChildren());
				procesoAct.setText(accion);
				String comprobante= MenuDeConsola.usuarioactual.Cartera();
				
				if (comprobante.equals("No cuentas con reservas activas por el momento.")) {
					consulta.setText("No cuentas con reservas activas por el momento.");
				}
				else {
					consulta.setText(MenuDeConsola.usuarioactual.VuelosReservados());
					String[] c = {"Seleccione el # de Reserva a imprimir"};
	                String[] v = {""};
	                FieldPanel Reservaimp = new FieldPanel("",c,"",v,null);
	      
	                auxgrid=(GridPane) Reservaimp.getChildren().get(0);
	                V.add(Reservaimp,0,0);
	                clientes2.setBottom(V);
	                BorderPane.setAlignment(Reservaimp,Pos.CENTER);
	                
	                ObservableList<Node> asd = auxgrid.getChildren();
					((Button)asd.get(asd.size()-2)).setOnMouseClicked(new EventHandler<MouseEvent>() {
	                    public void handle(MouseEvent event) {
	                    	try{
	                    		Reservaimp.GuardarDatos();
	                    		int i=Integer.valueOf(Reservaimp.getValue("Seleccione el # de Reserva a imprimir"));
	                    		if(!(i >=0 && i < MenuDeConsola.usuarioactual.getCartera().size())) {
	                    			throw new tipoDato();
	                    		}
	                    		consulta.setText(MenuDeConsola.usuarioactual.Pasabordo(MenuDeConsola.usuarioactual.getCartera().get(i)));
	                    		clientes2.setBottom(null);
	                    	}catch(datoFaltante e){
	                    		a.setContentText(e.getMessage());
	                    		a.showAndWait();
	                    	}catch(tipoDato e) {
	                    		a.setContentText(e.getMessage());
	                    		a.showAndWait();
	                    	}catch(NumberFormatException e){
	                    		tipoDato error = new tipoDato();
	                    		a.setContentText(error.getMessage());
	                    		a.showAndWait();
	        				}
	                    	}});
			        }

				
				break;
			case "Cancelar Reserva":
				V.getChildren().removeAll(V.getChildren());
				procesoAct.setText(accion);
				consulta.setText(MenuDeConsola.usuarioactual.VuelosReservados());
				
				//consulta.setPrefWidth(clientes2.getWidth());
				
				String[] c1 = {"Reserva a cancelar:"};
				String[] v1 = {""};
				FieldPanel formcancelar = new FieldPanel("",c1,"",v1,null);
				auxgrid=(GridPane) formcancelar.getChildren().get(0);
				V.add(formcancelar, 0, 0);
                clientes2.setBottom(V);

				
				ObservableList<Node> asd1 = auxgrid.getChildren();
				((Button)asd1.get(asd1.size()-2)).setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						try {
							formcancelar.GuardarDatos();
							int reservaF = Integer.parseInt(formcancelar.getValue("Reserva a cancelar"));
							if(!(reservaF >=0 && reservaF < MenuDeConsola.usuarioactual.cartera.size())) {
								throw new tipoDato();
							}
							try{
								if(!MenuDeConsola.usuarioactual.cartera.isEmpty()) {
									MenuDeConsola.usuarioactual.cancelarReserva(MenuDeConsola.usuarioactual.cartera.get(reservaF));
									consulta.setText(MenuDeConsola.usuarioactual.Cartera());
								}else {
									a.setContentText("No cuentas con reservas activas por el momento.");
									a.showAndWait();
								}
							}catch(modificarVuelo e) {
								a.setContentText(e.getMessage());
								a.showAndWait();
							}catch (NumberFormatException e) {
								a.setContentText(e.getMessage());
								a.showAndWait();
							}
						}catch(datoFaltante e){
							a.setContentText(e.getMessage());
                			a.showAndWait();
                		}catch(tipoDato e){
                			a.setContentText(e.getMessage());
                			a.showAndWait();
                		}catch(NumberFormatException e){
                    		tipoDato error = new tipoDato();
                    		a.setContentText(error.getMessage());
                    		a.showAndWait();
        				}
					}
					
				});
				break;
			case "Canjear Premio":
				V.getChildren().removeAll(V.getChildren());
				procesoAct.setText(accion);
				consulta.setText("Sus millas: "+MenuDeConsola.usuarioactual.getCuentamillas().getMillas() +"\n\n"+ Admin.ImprimirPremios());
				String[] c2 = {"Premio a canjear"};
				String[] v2 = {""};
				FieldPanel formpremios = new FieldPanel("",c2,"",v2,null);
				auxgrid=(GridPane) formpremios.getChildren().get(0);
                V.add(formpremios,0,0);
                clientes2.setBottom(V);
				
				ObservableList<Node> asd2 = auxgrid.getChildren();
				((Button)asd2.get(asd2.size()-2)).setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						try {
							formpremios.GuardarDatos();
							String canjeo = MenuDeConsola.usuarioactual.CanjearMillas(Integer.parseInt(formpremios.getValue("Premio a canjear")));
							a.setContentText(canjeo);
						}catch(datoFaltante e){
							a.setContentText(e.getMessage());
            			}catch(tipoDato e) {
            				a.setContentText(e.getMessage());
            			}catch(NumberFormatException e){
                    		tipoDato error = new tipoDato();
                    		a.setContentText(error.getMessage());
        				}finally {
							a.showAndWait();
            			}
					}
					
				});
				break;
				//
			}
			BorderPane.setAlignment(procesoAct, Pos.CENTER);
		}
		public Vector<Integer> datos() {
			Iterator<Vuelo> i = Empleado.vuelos.iterator();
			Vector<Integer> NV = new Vector<>();
			int posicion = 0;
    		while(i.hasNext()) {
    			Vuelo vuelo = (Vuelo)i.next();
    			if(vuelo.getEstado().equals("Venta")) {
    				NV.add(posicion);
    			}
    			posicion++;
    		}
			return NV;
    		
			
		}		
	}
	
}
