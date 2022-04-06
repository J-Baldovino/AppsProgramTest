package application;
	
import java.io.File;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;




public class Title extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			URL url = new File("Title.fxml").toURI().toURL();
			URL imgUrl = new File("images/icon.png").toURI().toURL();
			Image icon = new Image(imgUrl.toString());
			AnchorPane root = (AnchorPane)FXMLLoader.load(url);
			Scene scene = new Scene(root,800,450);
			scene.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
			primaryStage.getIcons().add(icon);
			primaryStage.setTitle("Dice Attack");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
