package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class MainController implements Initializable{

	@FXML
	private ImageView pika, sanic, monke, ant;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//Translate (move) the pika image
		TranslateTransition translatePika = new TranslateTransition();
		translatePika.setNode(pika);
		translatePika.setDuration(Duration.millis(1000)); //sets the duration of the entire animation, so in this instance it would take 1000 milliseconds or a second
		//translate.setCycleCount(2); //repeats the animation two times
		translatePika.setCycleCount(TranslateTransition.INDEFINITE); //used to cause an animation to go on forever
		//The two setBy methods used together causes the image to move in a diagonal
		translatePika.setByX(500); //moves the image to the right by 500 pixels
		translatePika.setByY(-200); //moves the image up by 200 pixels
		translatePika.setAutoReverse(true); //causes the image to reverse automatically at the end of our translation
		translatePika.play();
		
		//Rotate the sanic image
		RotateTransition rotateSanic = new RotateTransition();
		rotateSanic.setNode(sanic);
		rotateSanic.setDuration(Duration.millis(1000)); //sets the duration of the entire animation, so in this instance it would take 1000 milliseconds or a second
		//translate.setCycleCount(2); //repeats the animation two times
		rotateSanic.setCycleCount(TranslateTransition.INDEFINITE); //used to cause an animation to go on forever
		//The two setBy methods used together causes the image to move in a diagonal
		rotateSanic.setInterpolator(Interpolator.LINEAR);
		rotateSanic.setAxis(Rotate.Z_AXIS); //Rotate. also has the X_AXIS and Y_AXIS options
		rotateSanic.setByAngle(360);
		rotateSanic.play();
		
		//Fade away the monke image
		FadeTransition fade = new FadeTransition();
		fade.setNode(monke);
		fade.setDuration(Duration.millis(2000)); //sets the duration of the entire animation, so in this instance it would take 1000 milliseconds or a second
		//translate.setCycleCount(2); //repeats the animation two times
		fade.setCycleCount(TranslateTransition.INDEFINITE); //used to cause an animation to go on forever
		fade.setInterpolator(Interpolator.LINEAR);
		//If you want an image to fade in, you can set the two following as setFromValue(0) and setToValue(1)
		fade.setFromValue(1); //original opacity value
		fade.setToValue(0);	//target opacity value
		fade.play();
		
		//Scale the antman image
		ScaleTransition scale = new ScaleTransition();
		scale.setNode(ant);
		scale.setDuration(Duration.millis(2000)); //sets the duration of the entire animation, so in this instance it would take 1000 milliseconds or a second
		//translate.setCycleCount(2); //repeats the animation two times
		scale.setCycleCount(TranslateTransition.INDEFINITE); //used to cause an animation to go on forever
		scale.setInterpolator(Interpolator.LINEAR);
		scale.setByX(2.0); //Stretches to twice the size of the original image on the X axis
		scale.setByY(2.0); //Stretches to twice the size of the original image on the Y axis
		scale.setAutoReverse(true);
		scale.play();
	}

}
