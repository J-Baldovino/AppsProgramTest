package application.controller;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import application.model.Champions;
import application.model.Monster;
import application.model.Person;
import application.model.TwoDice;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class BattleController {
	
	MediaPlayer mp;
	
	@FXML
	private AnchorPane lC;
	
	@FXML
	private AnchorPane wC;
	
    @FXML
    private Button defendButton;

    @FXML
    private Button burstButton;

    @FXML
    private Button attackButton;

    @FXML
    private ImageView enemy;

    @FXML
    private ImageView player;
    
    @FXML
    private Button sceneAction1;
    
    @FXML
    private Button sceneAction2;
    
    @FXML
    private Button sceneAction3;
    
    @FXML
    private Button endTurn;
    
    @FXML
    private TextField dice1;
    
    @FXML
    private TextField dice2;
    
    @FXML
    private TextField BattleText;
    
    @FXML
    private ImageView diceImage;
    
    @FXML
    private Label playerName;
    
    @FXML
    private Label playerHealth;
    
    Random random = new Random();

    @FXML
    private Label EnemyName;
    
    @FXML
    private Label EnemyHealth;
    
    //ARNOLD PART //This is where I will put the players name but it is set at the moment
	Person DiceHero = new Person(10, 10, 0, 10); //Person is different from 
	TwoDice dice = new TwoDice();
	ArrayList<Monster> list = new ArrayList<>();
    
    @FXML
    private void initialize() throws MalformedURLException
    {
    	File media = new File("music/battle.mp3");
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
        
		dice.roll();
		Monster gremlin;
		gremlin = new Monster("Gremlin", 10, 3);
		list.add(gremlin);
		Monster gremlin2;
		gremlin2 = new Monster("Gremlin2", 10, 7);
		list.add(gremlin2);
		
		//playerName.setText(DiceHero.getName());
//		playerHealth.setText(DiceHero.getHealthRatio());
		EnemyName.setText(list.get(0).getName());
		EnemyHealth.setText(Integer.toString(list.get(0).getHealth()));
		
		
		
//		if(DiceHero.getMana() + dice.getDie1() > DiceHero.getMaxMana())
//		{
//			DiceHero.setMana(10);
//		}
//		else
//		{
//			DiceHero.setMana(DiceHero.getMana() + dice.getDie1());
//		}
	}

    @FXML
    void sceneWin(ActionEvent event) {
    	mp.stop();
    	try {
    		URL url = new File("Victory.fxml").toURI().toURL();
    		URL styleUrl = new File("src/application/application.css").toURI().toURL();
			wC = FXMLLoader.load(url);
			Stage classifieds= (Stage) ((Node)event.getSource()).getScene().getWindow();
			Scene scene = new Scene(wC);
			scene.getStylesheets().add(styleUrl.toString());
			classifieds.setScene(scene);
			classifieds.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void sceneLose(ActionEvent event) {
    	mp.stop();
    	try {
    		URL url = new File("Game_Over.fxml").toURI().toURL();
    		URL styleUrl = new File("src/application/application.css").toURI().toURL();
			lC = FXMLLoader.load(url);
			Stage classifieds= (Stage) ((Node)event.getSource()).getScene().getWindow();
			Scene scene = new Scene(lC);
			scene.getStylesheets().add(styleUrl.toString());
			classifieds.setScene(scene);
			classifieds.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void sceneAction1(ActionEvent event) {
    	dice.roll();
		System.out.println("Dice one: " + dice.getDie1() + " Dice two: " + dice.getDie2());
		System.out.println(list.get(0).takeDamage( DiceHero.basicStrike(dice.getDie1())) );
		
		//System.out.println(DiceHero.takeDamage(list.get(0).getAttackPower()));
		System.out.println();
		
		if(DiceHero.getHealth() <= 0)
		{
			System.out.println( "NAME has died has died"); //DiceHero.getName() was removed
		}
		if(list.get(0).getHealth() <= 0)
		{
			System.out.println(list.get(0).getName() + " has died" );
		}
		
		//System.out.println(DiceHero.getName() + " has " + DiceHero.getHealth() + " hp");
		System.out.println(list.get(0).getName() + " has " + list.get(0).getHealth() + " hp");
    	
		
		playerHealth.setText(DiceHero.getHealthRatio());
		
    }
    
    @FXML
    void sceneAction2(ActionEvent event) {

    	//dice1.setText(Integer.toString(dice.getDie1()));
//    	BattleText.setText(list.get(0).takeDamage( DiceHero.basicStrike(dice.getDie1())) );
//    	
//        File file = new File("/../../dice" + dice.getDie1() + ".png");
//        Image image = new Image(file.toURI().toString());
//        diceImage.setImage(image);
    	

    	
    	defendButton.setDisable(true);

        Thread thread = new Thread(){
            public void run(){
                System.out.println("Thread Running");
                try {
                    for (int i = 0; i < 15; i++) {
                    	dice.rollOneDice();
                    	dice1.setText( Integer.toString(dice.getDie1()) );
                        File file = new File("/../../dice" + dice.getDie1() +".png");
                        diceImage.setImage(new Image(file.toURI().toString()));
                        Thread.sleep(50);
                    }
                    defendButton.setDisable(false);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        thread.start();
    }
    
    @FXML
    void sceneAction3(ActionEvent event) {
    	
    	
    }
    
    @FXML
    void endTurn(ActionEvent event) {
//    	try {
//    		URL url = new File("Title.fxml").toURI().toURL();
//    		URL styleUrl = new File("src/application/application.css").toURI().toURL();
//			wC = FXMLLoader.load(url);
//			Stage classifieds= (Stage) ((Node)event.getSource()).getScene().getWindow();
//			Scene scene = new Scene(wC);
//			scene.getStylesheets().add(styleUrl.toString());
//			classifieds.setScene(scene);
//			classifieds.show();
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
    	
    }

}

