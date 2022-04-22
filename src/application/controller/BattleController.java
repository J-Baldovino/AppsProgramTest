package application.controller;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

import application.model.Champions;
import application.model.Monster;
import application.model.Person;
import application.model.TwoDice;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BattleController{
	
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
    private Button battleWonScene;
    
    @FXML
    private TextField dice1;
    
    @FXML
    private TextField dice2;
    
    @FXML
    private TextField BattleText;
    
    @FXML
    private ImageView diceImage;
    
    @FXML
    private ImageView diceImage2;
    
    @FXML
    private Label playerName;
    
    @FXML
    private Label playerHealth;
    
    @FXML
    private Label playerMana;

    @FXML
    private Label EnemyName;
    
    @FXML
    private Label EnemyHealth;
    
    @FXML
    private Label shieldValue;
    
    @FXML
    private Button basicAttackButton;

    @FXML
    private Button defendBtn;

    @FXML
    private Button healButton;

    @FXML
    private Button multiAttackButton;
    
    @FXML
    private ImageView sanic, goomba, sword, heal, shield;
    private TranslateTransition translateSword1 = new TranslateTransition();
    private TranslateTransition translateSword2 = new TranslateTransition();
    private RotateTransition rotateSword1 = new RotateTransition();
    private RotateTransition rotateSword2 = new RotateTransition();
    private TranslateTransition translateGoomba = new TranslateTransition();
    private TranslateTransition translateSanic = new TranslateTransition();
    //private FadeTransition fadeGoomba = new FadeTransition();
    private FadeTransition fadeHeal = new FadeTransition();
    private TranslateTransition translateShield = new TranslateTransition();

    Random random = new Random();
    
    @FXML private URL location;
    @FXML private ResourceBundle resources;
    
    //ARNOLD PART //This is where I will put the players name but it is set at the moment
	//Person DiceHero = new Person(10, 10, 0, 10); //Person is different from 
    
//	TwoDice dice = new TwoDice();
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
        
        Person DiceHero = new Person(); //initalally get mana
        TwoDice dice = new TwoDice();
        dice.rollOneDice(); //dont use rolling function here
        System.out.println(dice.getDie1());
        DiceHero.addMana(dice.getDie1());
        
//		dice.roll();
		Monster gremlin;
		gremlin = new Monster("Gremlin " + Integer.toString(DiceHero.getBattlesWon() + 1), 10 + DiceHero.getBattlesWon() * 5, 3 + DiceHero.getBattlesWon());
		list.add(gremlin);
//		Monster gremlin2;
//		gremlin2 = new Monster("Goblin", 11, 7);
//		list.add(gremlin2);
		
		playerName.setText("Change");
		//playerHealth.setText(DiceHero.getHealthRatio());
//		EnemyName.setText(list.get(0).getName());
//		EnemyHealth.setText(Integer.toString(list.get(0).getHealth()));
		update();
		sword.setVisible(false); //start the sword as not visible
    	heal.setVisible(false);
    	shield.setVisible(false);
    	
    	//Preparing rotation movement for basic sword
    	rotateSword1.setNode(sword);
    	rotateSword1.setDuration(Duration.millis(100));
    	rotateSword1.setCycleCount(4);
    	rotateSword1.setInterpolator(Interpolator.LINEAR);
		rotateSword1.setAxis(Rotate.Z_AXIS); 
		rotateSword1.setByAngle(360);
		
		//Preparing translation movement for basic sword
		translateSword1.setNode(sword);
		translateSword1.setDuration(Duration.millis(200));
		translateSword1.setCycleCount(2);
		translateSword1.setByX(350); //moves the image to the right by 500 pixels
		translateSword1.setByY(-120); //moves the image up by 200 pixels
		translateSword1.setAutoReverse(true);
		
		//Preparing rotation movement for multi sword
    	rotateSword2.setNode(sword);
    	rotateSword2.setDuration(Duration.millis(100));
    	rotateSword2.setCycleCount(12);
    	rotateSword2.setInterpolator(Interpolator.LINEAR);
		rotateSword2.setAxis(Rotate.Z_AXIS); 
		rotateSword2.setByAngle(360);
		
		//Preparing translation movement for multi sword
		translateSword2.setNode(sword);
		translateSword2.setDuration(Duration.millis(200));
		translateSword2.setCycleCount(6);
		translateSword2.setByX(350); //moves the image to the right by 500 pixels
		translateSword2.setByY(-120); //moves the image up by 200 pixels
		translateSword2.setAutoReverse(true);

		//preparing translation movement for shield
		translateShield.setNode(shield);
		translateShield.setDuration(Duration.millis(200));
		translateShield.setCycleCount(2);
		translateShield.setByY(-40);
		translateShield.setAutoReverse(true);
    	
		//Preparing translation movement for enemy
		translateGoomba.setNode(goomba);
		translateGoomba.setDuration(Duration.millis(200));
		translateGoomba.setCycleCount(4);
		translateGoomba.setByX(35); 
		translateGoomba.setAutoReverse(true);
		
		//Preparing translation movement for player
		translateSanic.setNode(sanic);
		translateSanic.setDuration(Duration.millis(200));
		translateSanic.setCycleCount(2);
		translateSanic.setByY(-35); 
		translateSanic.setAutoReverse(true);
		
		//Preparing fade animation for the enemy
//		fadeGoomba.setNode(goomba);
//		fadeGoomba.setDuration(Duration.millis(1000));
//		fadeGoomba.setCycleCount(1);
//		fadeGoomba.setInterpolator(Interpolator.EASE_OUT); //Causes the animation to slow down near the end of the sequence
//		fadeGoomba.setFromValue(1); //original opacity value
//		fadeGoomba.setToValue(0);	//target opacity value
		
		//Preparing fade animation for healing
		fadeHeal.setNode(heal);
		fadeHeal.setDuration(Duration.millis(1000));
		fadeHeal.setCycleCount(2);
		fadeHeal.setInterpolator(Interpolator.EASE_OUT); //Causes the animation to slow down near the end of the sequence
		fadeHeal.setAutoReverse(true);
		fadeHeal.setFromValue(0); //original opacity value
		fadeHeal.setToValue(1);	//target opacity value

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
    void basicAttackButton(ActionEvent event) { //1 mana
    	Person DiceHero = new Person();
    	
    	if(DiceHero.getMana() >= 1)
    	{
    	
        System.out.println( list.get(0).takeDamage(DiceHero.basicStrike(rollingFunction())));
        System.out.println("The monster's hp is now = " + Integer.toString(list.get(0).getHealth()) + "\n");// + " the thread is fucking me here please help God");
        DiceHero.subMana(1);
        update();
        BattleText.setText("Name here your hero will be named at the start " + " has used basic strike! \n" + list.get(0).getName() + " has " +  list.get(0).getHealth() + ".");
    	//Animation
    	sword.setVisible(true);
    	heal.setVisible(false);
    	shield.setVisible(false);
    	translateSword1.play();
    	rotateSword1.play();
    	translateGoomba.play();
    	translateSanic.play();
    	}
    	else
    	{
    		BattleText.setText("You do not have enough mana");
    	}
    }
    
    @FXML
    void multiStrikeButton(ActionEvent event) {
    	Person DiceHero = new Person();

    	if(DiceHero.getMana() >= 4)
    	{
    		//4 mana to dice1 * dice1
    		System.out.println( list.get(0).takeDamage(DiceHero.multistrike((rollingFunction()))));
    		BattleText.setText("Name here your hero will be named at the start " + " has used multi-strike! " + list.get(0).getName() + " has " +  list.get(0).getHealth() + ".");
    		DiceHero.subMana(4);
    		//Animation
        	sword.setVisible(true);
        	heal.setVisible(false);
        	shield.setVisible(false);
        	translateSword2.play();
        	rotateSword2.play();
        	translateGoomba.play();
        	translateSanic.play();
    	}
    	else
    	{
    		BattleText.setText("You do not have enough mana");
    	}
//    	System.out.println(DiceHero.getHealth());
//    	DiceHero.takeDamage(1);
    	update();
    }
    
    @FXML
    void healButton(ActionEvent event) {
    	Person DiceHero = new Person();
    	
    	if(DiceHero.getMana() >= 3)
    	{
    	
        //System.out.println( list.get(0).takeDamage(DiceHero.basicStrike(rollingFunction())));
        //System.out.println("The monster's hp is now = " + Integer.toString(list.get(0).getHealth()) + "\n");// + " the thread is fucking me here please help God");
    	DiceHero.healing(rollingFunction());
        DiceHero.subMana(3);
        update();
        BattleText.setText("Name here your hero will be named at the start " + " has used heal! \n" + ".");

    	//Animations 
    	sword.setVisible(false);
    	heal.setVisible(true);
    	shield.setVisible(false);
    	fadeHeal.play();
    	}
    	else
    	{
    		BattleText.setText("You do not have enough mana");
    	}
    	update();
    }
    
    @FXML
    void defendButton(ActionEvent event) {
    	Person DiceHero = new Person();
    	
    	if(DiceHero.getMana() >= 2)
    	{
    	
        //System.out.println( list.get(0).takeDamage(DiceHero.basicStrike(rollingFunction())));
        //System.out.println("The monster's hp is now = " + Integer.toString(list.get(0).getHealth()) + "\n");// + " the thread is fucking me here please help God");
    		//System.out.println("`Hero's name` defends for " + DiceHero.defending(rollingFunction()));
        DiceHero.subMana(2);
        update();
        BattleText.setText("`Hero's name` defends for " + DiceHero.defending(rollingFunction()) + ".");

    	//Animations
    	sword.setVisible(false);
    	heal.setVisible(false);
    	shield.setVisible(true);
    	translateShield.play();
    	}
    	else
    	{
    		BattleText.setText("You do not have enough mana");
    	}
    	update();

    }
    
    
    @FXML
    void endTurn(ActionEvent event) throws InterruptedException {
    	Person DiceHero = new Person();
    	TwoDice dice = new TwoDice();
    	if(endTurn.getText().equals("End Turn"))
    	{
//    	BattleText.setText(list.get(0).getName() + "'s turn" );
    	Thread.sleep(1000); //small delay 
    	//System.out.println(list.get(0).getName() + " attacks " + "`Add hero's name later` " + "for " + list.get(0).getAttackPower());
    	BattleText.setText(list.get(0).getName() + " attacks " + "`Add hero's name later` " + "for " + list.get(0).getAttackPower());
    	DiceHero.takeDamage(list.get(0).getAttackPower());
    	endTurn.setText("Start turn");
    	DiceHero.resetShield(); //shield goes to zero after enemy attacks
    	basicAttackButton.setDisable(true);
    	multiAttackButton.setDisable(true);
    	healButton.setDisable(true);
    	defendButton.setDisable(true);
    	//endTurn.setDisable(true);
    	}
    	else
    	{
    		DiceHero.addMana(rollingFunction());
    		BattleText.setText("Hero's name turn! Hero's name gains " + dice.getDie1() + " mana!");
    		endTurn.setText("End Turn");
        	basicAttackButton.setDisable(false);
        	multiAttackButton.setDisable(false);
        	healButton.setDisable(false);
        	defendButton.setDisable(false);
        	//endTurn.setDisable(true);
    	}
		if(DiceHero.getHealth() <= 0)
		{
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
    	update();
    	
    }
    
    @FXML
    void battleWonScene(ActionEvent event) {
    	mp.stop();
    	Person DiceHero = new Person();
    	DiceHero.setBattlesWon();
    	if(DiceHero.getBattlesWon() < 2)
    	{
    	try {
    		URL url = new File("Stage.fxml").toURI().toURL();
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
    	else
    	{
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
    }
    
    public void update(){
    	Person DiceHero = new Person(); //have to do this to access stats
    	//playerName.setText("name here");
    	playerHealth.setText(DiceHero.getHealthRatio());
    	playerMana.setText(Integer.toString(DiceHero.getMana()));
    	EnemyName.setText(list.get(0).getName());
    	EnemyHealth.setText(Integer.toString(list.get(0).getHealth()));
    	shieldValue.setText(Integer.toString(DiceHero.getShield()));
    	
    	if(list.get(0).getHealth() <= 0)
    	{
        	basicAttackButton.setDisable(true);
        	multiAttackButton.setDisable(true);
        	healButton.setDisable(true);
        	defendButton.setDisable(true);
        	endTurn.setDisable(true);
    		battleWonScene.setVisible(true);
    	}
    }
    
    public int rollingFunction(){
    	basicAttackButton.setDisable(true);
    	multiAttackButton.setDisable(true);
    	healButton.setDisable(true);
    	defendButton.setDisable(true);
    	
    	TwoDice dice = new TwoDice();
        Thread thread = new Thread(){
            public void run(){
                //System.out.println("Thread Running");
                try {
                    for (int i = 0; i <= 15; i++) {
                    	dice.rollOneDice();
                    	dice1.setText( Integer.toString(dice.getDie1()) );
                        File file = new File("/../../images/dice" + dice.getDie1() +".png");
                        System.out.print(dice.getDie1() + " ");
                        diceImage.setImage(new Image(file.toURI().toString()));
                        Thread.sleep(20);
                    }
                    basicAttackButton.setDisable(false);
                	multiAttackButton.setDisable(false);
                	healButton.setDisable(false);
                	defendButton.setDisable(false);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();

        while(thread.isAlive())
        {	
        }
        
        return dice.getDie1();
   }
   
    public int rollingFunction2(){
    	basicAttackButton.setDisable(true);
    	multiAttackButton.setDisable(true);
    	healButton.setDisable(true);
    	defendButton.setDisable(true);
    	
    	TwoDice dice = new TwoDice();
        Thread thread = new Thread(){
            public void run(){
                //System.out.println("Thread Running");
                try {
                    for (int i = 0; i <= 15; i++) {
                    	dice.rollOneDice();
                    	dice2.setText( Integer.toString(dice.getDie1()) );
                        File file = new File("/../../images/dice" + dice.getDie1() +".png");
                        System.out.print(dice.getDie1() + " ");
                        diceImage2.setImage(new Image(file.toURI().toString()));
                        Thread.sleep(50);
                    }
                    basicAttackButton.setDisable(false);
                	multiAttackButton.setDisable(false);
                	healButton.setDisable(false);
                	defendButton.setDisable(false);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();

        while(thread.isAlive())
        {	
        }
        
        return dice.getDie1();
   }
}



