package application.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class winScreenControl {

    @FXML
    private Button winMenuBtn;

    @FXML
    private Button continueBtn;

    @FXML
    void continueGame(ActionEvent event) throws IOException{
    	  Parent root = FXMLLoader.load(getClass().getResource("/stage.fxml"));
    	    Scene scene = new Scene(root);
    	    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	    window.setScene(scene);
    	    		
    	    window.show();
    }

    @FXML
    void toMainScrn(ActionEvent event) throws IOException{
    	  Parent root = FXMLLoader.load(getClass().getResource("/main.fxml"));
    	    Scene scene = new Scene(root);
    	    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	    window.setScene(scene);
    	    		
    	    window.show();
    }

}