package application.controller;

import java.awt.Button;
import java.awt.Label;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class stageControl{
	
	@FXML
	
	private Label stageLBL;
	
    @FXML
    private Button beginBtn;

    @FXML
    void toBattleScreen(ActionEvent event) throws IOException{
    	
    	  Parent root = FXMLLoader.load(getClass().getResource("/battle.fxml"));
    	    Scene scene = new Scene(root);
    	    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	    window.setScene(scene);
    	    		
    	    window.show();

    }
}
