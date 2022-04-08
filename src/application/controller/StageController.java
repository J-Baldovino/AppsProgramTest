package application.controller;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import application.model.StageCounter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

public class StageController {
	
	MediaPlayer mp;
	MediaPlayer smp;
	
    @FXML
    private Label sT;
	
	@FXML
	private AnchorPane bC;

    @FXML
    private ImageView handB;

    @FXML
    private Button battleB;
    
    @FXML
    void bS(ActionEvent event) throws MalformedURLException {
    	StageCounter.incrementStage();
    	File media = new File("music/select.mp3");
    	Media effect = new Media(media.toURI().toURL().toString());
    	smp= new MediaPlayer(effect);
    	smp.setStartTime(new Duration(600));
    	smp.setVolume(0.3);
    	smp.play();
    	try {
    		URL url = new File("Battle.fxml").toURI().toURL();
    		URL styleUrl = new File("src/application/application.css").toURI().toURL();
			bC = FXMLLoader.load(url);
			Stage bt= (Stage) ((Node)event.getSource()).getScene().getWindow();
			Scene scene = new Scene(bC);
			scene.getStylesheets().add(styleUrl.toString());
			bt.setScene(scene);
			bt.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    private void initialize() throws MalformedURLException
    {
    	
    	handB.setVisible(false);
    	
    	sT.setText("Stage "+StageCounter.getStagec());
    	
    	File media = new File("music/boom.mp3");
        Media song = new Media(media.toURI().toURL().toString());
        mp= new MediaPlayer(song);
        mp.setVolume(0.1);
        mp.play();
    	
    }

    @FXML
    void bSelect(MouseEvent event) throws MalformedURLException {
    	handB.setVisible(true);
    	File media = new File("music/select.mp3");
    	Media effect = new Media(media.toURI().toURL().toString());
    	smp= new MediaPlayer(effect);
    	smp.setStartTime(new Duration(600));
    	smp.setVolume(0.3);
    	smp.play();
    }

    @FXML
    void bDeselect(MouseEvent event) {
    	handB.setVisible(false);
    	smp.stop();
    }

}

