package application.controller;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import application.model.MusicManager;
import application.model.Person;
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
    	if(!firstStart)
    	{
    		MusicManager.loadSong("music/title.mp3");
        	MusicManager.playS();
        	StageCounter.setStagec(1);
    	}
    	Person DiceHero = new Person();
    	DiceHero.reset();
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
    		firstStart=false;
    		URL url = new File("ChooseName.fxml").toURI().toURL();
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
    void showCredits(ActionEvent event) throws MalformedURLException {
    	StageCounter.setStagec(1);
    	File media = new File("music/select.mp3");
    	Media effect = new Media(media.toURI().toURL().toString());
    	smp= new MediaPlayer(effect);
    	smp.setStartTime(new Duration(600));
    	smp.setVolume(0.3);
    	smp.play();
    	try {
    		firstStart=true;
    		URL url = new File("Credits.fxml").toURI().toURL();
    		URL styleUrl = new File("src/application/application.css").toURI().toURL();
			cC = FXMLLoader.load(url);
			Stage credits= (Stage) ((Node)event.getSource()).getScene().getWindow();
			Scene scene = new Scene(cC);
			scene.getStylesheets().add(styleUrl.toString());
			credits.setScene(scene);
			credits.show();
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