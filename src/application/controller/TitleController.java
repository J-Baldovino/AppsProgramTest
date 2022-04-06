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
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TitleController {
	
	MediaPlayer mp;
	MediaPlayer smp;
	MediaPlayer stmp;
	static boolean firstStart= false;

    @FXML
    private AnchorPane titlePane;
    
    @FXML
    private AnchorPane cC;
    
    @FXML
    private AnchorPane sB;
    
    @FXML
    private ImageView handC;

    @FXML
    private ImageView handP;

    @FXML
    private Label Title;

    @FXML
    private Button playButton;

    @FXML
    private Button creditButton;
    
    @FXML
    private void initialize() throws MalformedURLException
    {
    	
    	handP.setVisible(false);
    	handC.setVisible(false);
    	File media = new File("music/title.mp3");
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
    private void update()
    {
    	handP.setVisible(false);
    	handC.setVisible(false);
    }

    @FXML
    void startBattle(ActionEvent event) throws MalformedURLException {
    	File media = new File("music/select.mp3");
    	Media effect = new Media(media.toURI().toURL().toString());
    	smp= new MediaPlayer(effect);
    	smp.setStartTime(new Duration(600));
    	smp.setVolume(0.3);
    	smp.play();
    	try {
    		mp.stop();
    		firstStart=false;
    		URL url = new File("Stage.fxml").toURI().toURL();
    		URL styleUrl = new File("src/application/application.css").toURI().toURL();
			sB = FXMLLoader.load(url);
			Stage classifieds= (Stage) ((Node)event.getSource()).getScene().getWindow();
			Scene scene = new Scene(sB);
			scene.getStylesheets().add(styleUrl.toString());
			classifieds.setScene(scene);
			classifieds.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void showCredits(ActionEvent event) throws MalformedURLException {
    	File media = new File("music/select.mp3");
    	Media effect = new Media(media.toURI().toURL().toString());
    	smp= new MediaPlayer(effect);
    	smp.setStartTime(new Duration(600));
    	smp.setVolume(0.3);
    	smp.play();
    	try {
    		mp.stop();
    		URL url = new File("Credits.fxml").toURI().toURL();
    		URL styleUrl = new File("src/application/application.css").toURI().toURL();
			cC = FXMLLoader.load(url);
			Stage classifieds= (Stage) ((Node)event.getSource()).getScene().getWindow();
			Scene scene = new Scene(cC);
			scene.getStylesheets().add(styleUrl.toString());
			classifieds.setScene(scene);
			classifieds.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void selectSoundP(MouseEvent event) throws MalformedURLException {
    	handP.setVisible(true);
    	File media = new File("music/select.mp3");
    	Media effect = new Media(media.toURI().toURL().toString());
    	smp= new MediaPlayer(effect);
    	smp.setStartTime(new Duration(600));
    	smp.setVolume(0.3);
    	smp.play();
    	
    }
    
    @FXML
    void disP(MouseEvent event) {
    	handP.setVisible(false);
    	smp.stop();
    }
    
    @FXML
    void selectSoundC(MouseEvent event) throws MalformedURLException {
    	handC.setVisible(true);
    	File media = new File("music/select.mp3");
    	Media effect = new Media(media.toURI().toURL().toString());
    	smp= new MediaPlayer(effect);
    	smp.setStartTime(new Duration(600));
    	smp.setVolume(0.3);
    	smp.play();
    }
    
    @FXML
    void disC(MouseEvent event) {
    	handC.setVisible(false);
    	smp.stop();
    }

}

