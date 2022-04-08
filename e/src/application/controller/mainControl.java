package application.controller;


import java.io.IOException;

import java.awt.Button;
//import java.awt.Label;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class mainControl {
	
    @FXML
    private AnchorPane mainScreen;

    
    @FXML
    private Button creditsBtn;

    @FXML
    private Button startGameBtn;
    
    @FXML
    void startGame(ActionEvent event) throws IOException{
    	Parent root = FXMLLoader.load(getClass().getResource("/stage.fxml"));
		Scene scene = new Scene(root);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		
		window.show();
    }

    @FXML
    void credits(ActionEvent event) throws IOException{
    	Parent root = FXMLLoader.load(getClass().getResource("/info.fxml"));
		Scene scene = new Scene(root);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		
		window.show();
    }

}
