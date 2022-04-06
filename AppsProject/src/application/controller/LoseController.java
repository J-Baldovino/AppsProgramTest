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

public class LoseController {
	
	MediaPlayer mp;
	MediaPlayer smp;
	
	@FXML
	private AnchorPane tC;

    @FXML
    private ImageView handT;
    
    @FXML
    private Button titleButton;
    
    @FXML
    private void initialize() throws MalformedURLException
    {
    	handT.setVisible(false);
    	File media = new File("music/lose.mp3");
        Media song = new Media(media.toURI().toURL().toString());
        mp= new MediaPlayer(song);
       	mp.setOnEndOfMedia(new Runnable() {
       		@Override
        	public void run()
        	{
        		mp.seek(mp.getStartTime());
        	}
       	});
        mp.setVolume(0.1);
        mp.play();
        
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
    		mp.stop();
    		URL url = new File("Title.fxml").toURI().toURL();
    		URL styleUrl = new File("src/application/application.css").toURI().toURL();
			tC = FXMLLoader.load(url);
			Stage classifieds= (Stage) ((Node)event.getSource()).getScene().getWindow();
			Scene scene = new Scene(tC);
			scene.getStylesheets().add(styleUrl.toString());
			classifieds.setScene(scene);
			classifieds.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void tSelect(MouseEvent event) throws MalformedURLException {
    	handT.setVisible(true);
    	File media = new File("music/select.mp3");
    	Media effect = new Media(media.toURI().toURL().toString());
    	smp= new MediaPlayer(effect);
    	smp.setStartTime(new Duration(600));
    	smp.setVolume(0.3);
    	smp.play();
    }

    @FXML
    void tDeselect(MouseEvent event) {
    	handT.setVisible(false);
    	smp.stop();
    }

}

