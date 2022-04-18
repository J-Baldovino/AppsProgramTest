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
    private Button basicAttackButton, multiAttackButton, healButton, defendBtn;

    @FXML
    private ImageView sanic, goomba, sword, heal, shield;
    private TranslateTransition translateSword1 = new TranslateTransition();
    private TranslateTransition translateSword2 = new TranslateTransition();
    private RotateTransition rotateSword1 = new RotateTransition();
    private RotateTransition rotateSword2 = new RotateTransition();
    private TranslateTransition translateGoomba = new TranslateTransition();
    private TranslateTransition translateSanic = new TranslateTransition();
    //private FadeTransition fadeGoomba = new FadeTransition();
    private FadeTransition fadeHeal = new FadeTransition();
    private FadeTransition fadeSword1 = new FadeTransition();
    private FadeTransition fadeSword2 = new FadeTransition();
    private FadeTransition fadeShield = new FadeTransition();
    private TranslateTransition translateShield = new TranslateTransition();

    @FXML
    void bAttack(ActionEvent event) {
    	sword.setVisible(true);
    	heal.setVisible(false);
    	shield.setVisible(false);
    	translateSword1.play();
    	rotateSword1.play();
    	translateGoomba.play();
    	translateSanic.play();
    	fadeSword1.play();
    	//fadeGoomba.play();
    }
    
    @FXML
    void mAttack(ActionEvent event) {
    	sword.setVisible(true);
    	heal.setVisible(false);
    	shield.setVisible(false);
    	translateSword2.play();
    	rotateSword2.play();
    	translateGoomba.play();
    	translateSanic.play();
    	try {
    		//translateShield.play();
    		wait(50);
    		
    		//fadeShield.play();
    	}
    	catch(Exception e){
    	}
    	fadeSword1.play();
    	//fadeGoomba.play();
    }
    
    @FXML
    void healing(ActionEvent event) {
    	sword.setVisible(false);
    	heal.setVisible(true);
    	shield.setVisible(false);
    	fadeHeal.play();
    }
    
    @FXML
    public synchronized void defendHero(ActionEvent event) {
    	sword.setVisible(false);
    	heal.setVisible(false);
    	shield.setVisible(true);
    	translateShield.play();
    	try {
    		//translateShield.play();
    		wait(50);
    		
    		//fadeShield.play();
    	}
    	catch(Exception e){
    	}
    	fadeShield.play();
    }
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	sword.setVisible(false); //start the sword as not visible
    	heal.setVisible(false);
    	shield.setVisible(false);
    	
    	
    	
    	//Preparing rotation movement for basic sword
    	rotateSword1.setNode(sword);
    	rotateSword1.setDuration(Duration.millis(100));
    	rotateSword1.setCycleCount(4);
    	rotateSword1.setInterpolator(Interpolator.LINEAR);
		rotateSword1.setAxis(Rotate.Z_AXIS); 
		rotateSword1.setByAngle(360);
		
		//Preparing translation movement for basic sword
		translateSword1.setNode(sword);
		translateSword1.setDuration(Duration.millis(200));
		translateSword1.setCycleCount(2);
		translateSword1.setByX(350); //moves the image to the right by 500 pixels
		translateSword1.setByY(-120); //moves the image up by 200 pixels
		translateSword1.setAutoReverse(true);
		
		//Preparing rotation movement for multi sword
    	rotateSword2.setNode(sword);
    	rotateSword2.setDuration(Duration.millis(100));
    	rotateSword2.setCycleCount(12);
    	rotateSword2.setInterpolator(Interpolator.LINEAR);
		rotateSword2.setAxis(Rotate.Z_AXIS); 
		rotateSword2.setByAngle(360);
		
		//Preparing translation movement for multi sword
		translateSword2.setNode(sword);
		translateSword2.setDuration(Duration.millis(200));
		translateSword2.setCycleCount(6);
		translateSword2.setByX(350); //moves the image to the right by 500 pixels
		translateSword2.setByY(-120); //moves the image up by 200 pixels
		translateSword2.setAutoReverse(true);

		//preparing translation movement for shield
		translateShield.setNode(shield);
		translateShield.setDuration(Duration.millis(250));
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
		
		//Preparing fade animation for the enemy
//		fadeGoomba.setNode(goomba);
//		fadeGoomba.setDuration(Duration.millis(1000));
//		fadeGoomba.setCycleCount(1);
//		fadeGoomba.setInterpolator(Interpolator.EASE_OUT); //Causes the animation to slow down near the end of the sequence
//		fadeGoomba.setFromValue(1); //original opacity value
//		fadeGoomba.setToValue(0);	//target opacity value
		
		//Preparing fade animation for healing
		fadeHeal.setNode(heal);
		fadeHeal.setDuration(Duration.millis(1000));
		fadeHeal.setCycleCount(2);
		fadeHeal.setInterpolator(Interpolator.EASE_OUT); //Causes the animation to slow down near the end of the sequence
		fadeHeal.setAutoReverse(true);
		fadeHeal.setFromValue(0); //original opacity value
		fadeHeal.setToValue(1);	//target opacity value
		
		//Preparing fade animation for shield
		fadeShield.setNode(shield);
		fadeShield.setDuration(Duration.millis(500));
		fadeShield.setCycleCount(2);
		fadeShield.setInterpolator(Interpolator.EASE_OUT); //Causes the animation to slow down near the end of the sequence
		fadeShield.setAutoReverse(true);
		fadeShield.setFromValue(0); //original opacity value
		fadeShield.setToValue(1);	//target opacity value
		
		//Preparing fade animation for sword
		fadeSword1.setNode(sword);
		fadeSword1.setDuration(Duration.millis(400));
		fadeSword1.setCycleCount(2);
		fadeSword1.setInterpolator(Interpolator.EASE_OUT); //Causes the animation to slow down near the end of the sequence
		fadeSword1.setAutoReverse(true);
		fadeSword1.setFromValue(0); //original opacity value
		fadeSword1.setToValue(1);	//target opacity value
		
		//Preparing fade animation for sword
		fadeSword2.setNode(sword);
		fadeSword2.setDuration(Duration.millis(400));
		fadeSword2.setCycleCount(2);
		fadeSword2.setInterpolator(Interpolator.EASE_OUT); //Causes the animation to slow down near the end of the sequence
		fadeSword2.setAutoReverse(true);
		fadeSword2.setFromValue(0); //original opacity value
		fadeSword2.setToValue(1);	//target opacity value
    }

}
