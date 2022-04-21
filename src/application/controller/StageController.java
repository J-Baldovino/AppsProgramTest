package application.controller;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import application.inter.Toutput;
import application.model.StageCounter;
import application.model.WriteOn;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
	
	WriteOn anim;
	
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
    private void initialize() throws MalformedURLException, InterruptedException
    {
    	handB.setVisible(false);
    	battleB.setVisible(false);
    	
    	textSet();
       
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
    
    void textSet() throws InterruptedException
    {
    	Task<Void> sleeper = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
                return null;
            }
        };
        
        Task<Void> bSleeper = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                }
                return null;
            }
        };
        sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) { 
		          String send="Stage "+StageCounter.getStagec();
		          textAnim(send);
		          Thread thread = new Thread(anim);
		          thread.start();
		        
				
             
            }
        });
        
        bSleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) { 
				try {
					File media = new File("music/boom.mp3");
					Media song;
					song = new Media(media.toURI().toURL().toString());
					mp= new MediaPlayer(song);
		            mp.setVolume(0.1);
		            mp.play();
		            battleB.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
             
            }
        });
        new Thread(sleeper).start();
        new Thread(bSleeper).start();
    }
    
    void textAnim(String txt)
    {
    	Toutput tOut = new Toutput() {
            @Override
            public void writeText(String textOut) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        sT.setText(textOut);
                    }
                });
            }
        };

         anim= new WriteOn(txt,60, tOut);
    }

}