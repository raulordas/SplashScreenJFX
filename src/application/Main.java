package application;
	
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class Main extends Application {
	Stage stage;

	@FXML
	Label logoLabel;
	
	@Override
	public void start(Stage primaryStage) {
		stage = primaryStage;
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource(
				"VentanaPrincipal.fxml"));
		AnchorPane pane;
		try {
			pane = loader.load();
			Scene scene = new Scene(pane);

			// adding Custom fonts
			Font.loadFont(
					getClass().getResourceAsStream("assets/Anton-Regular.ttf"), 30);
			
			// adding Google fonts
			scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Muli");
			
			stage.initStyle(StageStyle.UNDECORATED);
			stage.setScene(scene);
			stage.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
		
	public static void main(String[] args) {
		launch(args);
	}
}
