package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class MainController implements Initializable{

	@FXML
	private ImageView pika, sanic, monke, ant;
	
	@FXML
	private Button startButton, pauseButton;
	
	private TranslateTransition translatePika = new TranslateTransition();
	
	private RotateTransition rotateSanic = new RotateTransition();
	
	private FadeTransition fade = new FadeTransition();
	
	private ScaleTransition scale = new ScaleTransition();
	
	@FXML
    void startMove(ActionEvent event) throws IOException{
		translatePika.play();
		rotateSanic.play();
		fade.play();
		scale.play();
    }

    @FXML
    void pauseMove(ActionEvent event) {
    	translatePika.pause();
    	rotateSanic.pause();
    	fade.pause();
    	scale.pause();
    }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//All of these commands can be changed and tweaked 
		
		//Translate (move) the pika image
		translatePika.setNode(pika);
		translatePika.setDuration(Duration.millis(100)); //sets the duration of the entire animation, so in this instance it would take 1000 milliseconds or a second
		//translate.setCycleCount(2); //repeats the animation two times
		translatePika.setCycleCount(TranslateTransition.INDEFINITE); //used to cause an animation to go on forever
		//The two setBy methods used together causes the image to move in a diagonal
		translatePika.setByX(500); //moves the image to the right by 500 pixels
		translatePika.setByY(-200); //moves the image up by 200 pixels
		translatePika.setAutoReverse(true); //causes the image to reverse automatically at the end of our translation
		
		//Rotate the sanic image
		rotateSanic.setNode(sanic);
		rotateSanic.setDuration(Duration.millis(10)); //sets the duration of the entire animation, so in this instance it would take 1000 milliseconds or a second
		//translate.setCycleCount(2); //repeats the animation two times
		rotateSanic.setCycleCount(TranslateTransition.INDEFINITE); //used to cause an animation to go on forever
		//The two setBy methods used together causes the image to move in a diagonal
		rotateSanic.setInterpolator(Interpolator.LINEAR);
		rotateSanic.setAxis(Rotate.Z_AXIS); //Rotate. also has the X_AXIS and Y_AXIS options
		rotateSanic.setByAngle(360);
		
		//Fade away the monke image
		fade.setNode(monke);
		fade.setDuration(Duration.millis(2000)); //sets the duration of the entire animation, so in this instance it would take 1000 milliseconds or a second
		//translate.setCycleCount(2); //repeats the animation two times
		fade.setCycleCount(TranslateTransition.INDEFINITE); //used to cause an animation to go on forever
		fade.setInterpolator(Interpolator.LINEAR);
		//If you want an image to fade in, you can set the two following as setFromValue(0) and setToValue(1)
		fade.setFromValue(1); //original opacity value
		fade.setToValue(0);	//target opacity value
		
		//Scale the antman image
		scale.setNode(ant);
		scale.setDuration(Duration.millis(1000)); //sets the duration of the entire animation, so in this instance it would take 1000 milliseconds or a second
		//translate.setCycleCount(2); //repeats the animation two times
		scale.setCycleCount(TranslateTransition.INDEFINITE); //used to cause an animation to go on forever
		scale.setInterpolator(Interpolator.LINEAR);
		scale.setByX(2.0); //Stretches to twice the size of the original image on the X axis
		scale.setByY(2.0); //Stretches to twice the size of the original image on the Y axis
		scale.setAutoReverse(true);
	}

}
