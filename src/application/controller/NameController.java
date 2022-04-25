package application.controller;
import application.model.Person;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import application.model.MusicManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

public class NameController {
	
	MediaPlayer smp;
	
	@FXML
    private AnchorPane sB;

    @FXML
    private ImageView sHand;

    @FXML
    private Button sButton;

    @FXML
    private TextField nameText;
    
    @FXML
    private void initialize() throws MalformedURLException
    {
    	
    	sHand.setVisible(false);
    	
    }
    
    @FXML
    void putName(ActionEvent event) throws MalformedURLException {
    	File media = new File("music/select.mp3");
    	Media effect = new Media(media.toURI().toURL().toString());
    	smp= new MediaPlayer(effect);
    	smp.setStartTime(new Duration(600));
    	smp.setVolume(0.3);
    	smp.play();
    	Person.setName(nameText.getText());
    	try {
    		MusicManager.stopS();
    		URL url = new File("Stage.fxml").toURI().toURL();
    		URL styleUrl = new File("src/application/application.css").toURI().toURL();
			sB = FXMLLoader.load(url);
			Stage battle= (Stage) ((Node)event.getSource()).getScene().getWindow();
			Scene scene = new Scene(sB);
			scene.getStylesheets().add(styleUrl.toString());
			battle.setScene(scene);
			battle.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void showHand(MouseEvent event) throws MalformedURLException {
    	sHand.setVisible(true);
    	File media = new File("music/select.mp3");
    	Media effect = new Media(media.toURI().toURL().toString());
    	smp= new MediaPlayer(effect);
    	smp.setStartTime(new Duration(600));
    	smp.setVolume(0.3);
    	smp.play();
    }

    @FXML
    void deleteHand(MouseEvent event) {
    	sHand.setVisible(false);
    	smp.stop();
    }
}
