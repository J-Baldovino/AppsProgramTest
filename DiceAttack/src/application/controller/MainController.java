package application.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainController {

	@FXML
	private AnchorPane mainPane;

	@FXML
	private ImageView backgroundPicture;

	@FXML
	private ImageView buglePicture;

	@FXML
	private Button classifiedsButton;

	@FXML
	private Button Info;

	 
	public void Info(ActionEvent event) throws IOException {
		mainPane = FXMLLoader.load(getClass().getClassLoader().getResource("Info.fxml"));
		Scene scene = new Scene(mainPane);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	public void handleTransition(ActionEvent event) throws IOException {
		mainPane = FXMLLoader.load(getClass().getClassLoader().getResource("SceneTransition.fxml"));
		Scene scene = new Scene(mainPane);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}

//	public void handleCrossword(ActionEvent event) throws IOException {
//		mainPane = FXMLLoader.load(getClass().getClassLoader().getResource("Crossword.fxml"));
//		Scene scene = new Scene(mainPane);
//		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
//		window.setScene(scene);
//		window.show();
//	}
	

}