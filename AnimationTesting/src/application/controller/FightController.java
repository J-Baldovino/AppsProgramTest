package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class FightController implements Initializable{
    @FXML
    private Button attackButton;

    @FXML
    private ImageView sanic, goomba, sword;
    
    private TranslateTransition translateSword = new TranslateTransition();
    private RotateTransition rotateSword = new RotateTransition();
    private TranslateTransition translateGoomba = new TranslateTransition();
    private TranslateTransition translateSanic = new TranslateTransition();

    @FXML
    void attack(ActionEvent event) {
//    	rotateSword.play();
    	translateSword.play();
    	rotateSword.play();
    	translateGoomba.play();
    	translateSanic.play();
    }
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	//Preparing rotation movement for sword
    	rotateSword.setNode(sword);
    	rotateSword.setDuration(Duration.millis(100));
    	rotateSword.setCycleCount(4);
    	rotateSword.setInterpolator(Interpolator.LINEAR);
		rotateSword.setAxis(Rotate.Z_AXIS); 
		rotateSword.setByAngle(360);
		
		//Preparing translation movement for sword
		translateSword.setNode(sword);
		translateSword.setDuration(Duration.millis(200));
		translateSword.setCycleCount(2);
		translateSword.setByX(500); //moves the image to the right by 500 pixels
		translateSword.setByY(-200); //moves the image up by 200 pixels
		translateSword.setAutoReverse(true);
    	
		//Preparing translation movement for enemy
		translateGoomba.setNode(goomba);
		translateGoomba.setDuration(Duration.millis(200));
		translateGoomba.setCycleCount(4);
		translateGoomba.setByX(35); 
		translateGoomba.setAutoReverse(true);
		
		//Preparing translation movement for player
		translateSanic.setNode(sanic);
		translateSanic.setDuration(Duration.millis(200));
		translateSanic.setCycleCount(2);
		translateSanic.setByY(-35); 
		translateSanic.setAutoReverse(true);
    }

}
