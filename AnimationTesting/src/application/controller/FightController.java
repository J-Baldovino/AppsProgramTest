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

    @FXML
    void attack(ActionEvent event) {
//    	rotateSword.play();
    	translateSword.play();
    	rotateSword.play();
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
    	
    }

}
