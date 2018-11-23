package application;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTextField;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Controller {
	
	@FXML
	private AnchorPane root;
	
	@FXML
	private AnchorPane ventana2;
	
	@FXML
	private Label tituloSki;
	
	@FXML
	private Pane pane, paneImg;
	
	@FXML
	private Label subtituloSki;
	
	@FXML
	private ImageView logoSki;
	
	@FXML
	private JFXSpinner spinner;
	
	@FXML
	private Label labelSpinner;
	
	@FXML
	private JFXButton btnReservar;
	
	@FXML
	private JFXTextField txtNombre;
	
	
	public void initialize() {
		posicionarTextFields();
		paneImg.setEffect(new GaussianBlur(10));
		transicionLogo();
		transicionSpinner();
	}
	
	private void cargarVentana() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Ventana2.fxml"));
		try {
			ventana2 = (AnchorPane) loader.load();
			Scene scene = new Scene(ventana2);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void disolverStagePrincipal() {
		FadeTransition fade = new FadeTransition(Duration.seconds(3), root);
		fade.setFromValue(1);
		fade.setToValue(0);
		fade.play();
		fade.setOnFinished(event-> {
			cargarVentana();
			Stage st = (Stage) root.getScene().getWindow();
			st.close();
		});
	}
	
	private void posicionarTextFields() {
		TranslateTransition t1 = new TranslateTransition(Duration.seconds(0.2), txtNombre);
		t1.setByX(1500);
		t1.play();
		t1.setOnFinished(event -> {
			TranslateTransition t2 = new TranslateTransition(Duration.seconds(0.2), btnReservar);
			t2.setByX(-1500);
			t2.play();
		});
	}
	
	private void extraerTextFields() {
		TranslateTransition t1 = new TranslateTransition(Duration.seconds(0.5), txtNombre);
		t1.setByX(-1500);
		t1.play();
		
		TranslateTransition t2 = new TranslateTransition(Duration.seconds(0.5), btnReservar);
		t2.setByX(1500);
		t2.play();
	}
	
	
	private void transicionSpinner() {
		FadeTransition f1 = new FadeTransition(Duration.seconds(2),spinner);
		f1.setFromValue(0);
		f1.setToValue(1);
		f1.play();
		
		FadeTransition f2 = new FadeTransition(Duration.seconds(2),labelSpinner);
		f2.setFromValue(0);
		f2.setToValue(1);
		f2.play();
		
	}
	
	private void transicionLogo() {
		TranslateTransition t1 = new TranslateTransition(Duration.seconds(1), subtituloSki);
		t1.setByY(700);
		t1.play();
		
		TranslateTransition t2 = new TranslateTransition(Duration.seconds(1), tituloSki);
		t2.setByY(700);
		t2.play();
		
		TranslateTransition t3 = new TranslateTransition(Duration.seconds(1), logoSki);
		t3.setByY(700);
		t3.play();
		
		t3.setOnFinished(event -> {
			TranslateTransition tInicio = new TranslateTransition(Duration.seconds(0.8), logoSki);
			tInicio.setByY(-700);
			tInicio.play();
			
			tInicio.setOnFinished(event2 ->  {
				TranslateTransition tTitulo = new TranslateTransition(Duration.seconds(0.6), tituloSki);
				tTitulo.setByY(-700);
				tTitulo.play();
				
				tTitulo.setOnFinished(event3 -> {
					TranslateTransition tSubtitulo = new TranslateTransition(Duration.seconds(0.4), subtituloSki);
					tSubtitulo.setByY(-700);
					extraerTextFields();
					tSubtitulo.play();
					
					tSubtitulo.setOnFinished(event4 -> {
						disolverStagePrincipal();
					});
				});
			});
			
		});
	}
}
