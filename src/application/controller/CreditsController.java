package application.controller;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

public class CreditsController {
	
	MediaPlayer smp;

    @FXML
    private Button returnButton;
    
    @FXML
    private AnchorPane titlePane;
    
    @FXML
    private ImageView retHand;
    
    @FXML
    private void initialize()
    {
    	retHand.setVisible(false);
    }

    @FXML
    void retTitle(ActionEvent event) throws MalformedURLException {
    	File media = new File("music/select.mp3");
    	Media effect = new Media(media.toURI().toURL().toString());
    	smp= new MediaPlayer(effect);
    	smp.setStartTime(new Duration(600));
    	smp.setVolume(0.3);
    	smp.play();
    	try {
    		URL url = new File("Title.fxml").toURI().toURL();
    		URL styleUrl = new File("src/application/application.css").toURI().toURL();
			titlePane = FXMLLoader.load(url);
			Stage title= (Stage) ((Node)event.getSource()).getScene().getWindow();
			Scene scene = new Scene(titlePane);
			scene.getStylesheets().add(styleUrl.toString());
			title.setScene(scene);
			title.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void retSelect(MouseEvent event) throws MalformedURLException {
    	retHand.setVisible(true);
    	File media = new File("music/select.mp3");
    	Media effect = new Media(media.toURI().toURL().toString());
    	smp= new MediaPlayer(effect);
    	smp.setStartTime(new Duration(600));
    	smp.setVolume(0.3);
    	smp.play();

    }

    @FXML
    void retClear(MouseEvent event) {
    	retHand.setVisible(false);
    	smp.stop();
    }

}