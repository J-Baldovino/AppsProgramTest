package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
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
<<<<<<< HEAD
    private Button attackButton, healButton;
=======
    private Button attackButton, defendBtn;
>>>>>>> refs/heads/myTestBranch

    @FXML
<<<<<<< HEAD
    private ImageView sanic, goomba, sword, heal;
=======
    private ImageView sanic, goomba, sword, shield;
>>>>>>> refs/heads/myTestBranch
    
    private TranslateTransition translateSword = new TranslateTransition();
    private RotateTransition rotateSword = new RotateTransition();
    private TranslateTransition translateGoomba = new TranslateTransition();
    private TranslateTransition translateSanic = new TranslateTransition();
<<<<<<< HEAD
    private FadeTransition fadeGoomba = new FadeTransition();
    private FadeTransition fadeHeal = new FadeTransition();
=======
    private TranslateTransition translateShield = new TranslateTransition();
>>>>>>> refs/heads/myTestBranch

    @FXML
    void attack(ActionEvent event) {
    	sword.setVisible(true);
    	heal.setVisible(false);
    	translateSword.play();
    	rotateSword.play();
    	translateGoomba.play();
    	translateSanic.play();
    	fadeGoomba.play();
    }
    
    @FXML
    void healing(ActionEvent event) {
    	sword.setVisible(false);
    	heal.setVisible(true);
    	fadeHeal.play();
    	
    }
    
    @FXML
    void defendHero(ActionEvent event) {
    	translateShield.play();
    }
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	sword.setVisible(false); //start the sword as not visible
    	heal.setVisible(false);
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

		//preparing translation movement for shield
		translateShield.setNode(shield);
		translateShield.setDuration(Duration.millis(200));
		translateShield.setCycleCount(2);
		translateShield.setByY(-40);
		translateShield.setAutoReverse(true);
    	
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
		
<<<<<<< HEAD
		//Preparing fade animation for the enemy
		fadeGoomba.setNode(goomba);
		fadeGoomba.setDuration(Duration.millis(1000));
		fadeGoomba.setCycleCount(1);
		fadeGoomba.setInterpolator(Interpolator.EASE_OUT); //Causes the animation to slow down near the end of the sequence
		fadeGoomba.setFromValue(1); //original opacity value
		fadeGoomba.setToValue(0);	//target opacity value
		
		//Preparing fade animation for healing
		fadeHeal.setNode(heal);
		fadeHeal.setDuration(Duration.millis(1000));
		fadeHeal.setCycleCount(2);
		fadeHeal.setInterpolator(Interpolator.EASE_OUT); //Causes the animation to slow down near the end of the sequence
		fadeHeal.setAutoReverse(true);
		fadeHeal.setFromValue(0); //original opacity value
		fadeHeal.setToValue(1);	//target opacity value
=======
>>>>>>> refs/heads/myTestBranch
    }

}
