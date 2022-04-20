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
import javafx.animation.PauseTransition;
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
    private TranslateTransition translateEnemy1 = new TranslateTransition();
    private TranslateTransition translateEnemy2 = new TranslateTransition();
    private TranslateTransition translatePlayer1 = new TranslateTransition();
    private TranslateTransition translatePlayer2 = new TranslateTransition();
    //private FadeTransition fadeGoomba = new FadeTransition();
    private FadeTransition fadeHeal = new FadeTransition();
    private TranslateTransition translateShield = new TranslateTransition();
    private FadeTransition fadeSword = new FadeTransition();

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
        diceImage.setVisible(true);
        
//		dice.roll();
		Monster gremlin;
		gremlin = new Monster("Gremlin", 10, 3);
		list.add(gremlin);
		Monster gremlin2;
		gremlin2 = new Monster("Goblin", 11, 7);
		list.add(gremlin2);
		
		playerName.setText("Change");
		//playerHealth.setText(DiceHero.getHealthRatio());
//		EnemyName.setText(list.get(DiceHero.getBattlesWon()).getName());
//		EnemyHealth.setText(Integer.toString(list.get(DiceHero.getBattlesWon()).getHealth()));
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
    	
		//Preparing translation movement for enemy1
		translateEnemy1.setNode(goomba);
		translateEnemy1.setDuration(Duration.millis(200));
		translateEnemy1.setCycleCount(4);
		translateEnemy1.setByX(35); 
		translateEnemy1.setAutoReverse(true);
		
		//Preparing translation movement for player1
		translatePlayer1.setNode(sanic);
		translatePlayer1.setDuration(Duration.millis(200));
		translatePlayer1.setCycleCount(2);
		translatePlayer1.setByY(-35); 
		translatePlayer1.setAutoReverse(true);
		
		//Preparing translation movement for enemy2
		translateEnemy2.setNode(goomba);
		translateEnemy2.setDuration(Duration.millis(200));
		translateEnemy2.setCycleCount(2);
		translateEnemy2.setByX(-350);
		translateEnemy2.setByY(120);
		translateEnemy2.setAutoReverse(true);
				
		//Preparing translation movement for player2
		translatePlayer2.setNode(sanic);
		translatePlayer2.setDuration(Duration.millis(200));
		translatePlayer2.setCycleCount(2);
		translatePlayer2.setByY(-35); 
		translatePlayer2.setAutoReverse(true);
		
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
		
		//Preparing fade animation for sword
		fadeSword.setNode(sword);
		fadeSword.setDuration(Duration.millis(2000));
		fadeSword.setCycleCount(1);
		fadeSword.setInterpolator(Interpolator.EASE_OUT); //Causes the animation to slow down near the end of the sequence
		fadeSword.setFromValue(1); //original opacity value
		fadeSword.setToValue(0);	//target opacity value

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
    		int d=rollingFunction();
    	
        System.out.println( list.get(DiceHero.getBattlesWon()).takeDamage(DiceHero.basicStrike(d)));
        System.out.println("The monster's hp is now = " + Integer.toString(list.get(DiceHero.getBattlesWon()).getHealth()) + "\n");// + " the thread is fucking me here please help God");
        DiceHero.subMana(1);
        update();
        BattleText.setText("Name here your hero will be named at the start " + " has used basic strike! \n" + list.get(DiceHero.getBattlesWon()).getName() + " has " +  list.get(DiceHero.getBattlesWon()).getHealth() + ".");
        
    	}
    	else
    	{
    		BattleText.setText("You do not have enough mana");
    	}
    	
    	//Animation
    	sword.setVisible(true);
    	heal.setVisible(false);
    	shield.setVisible(false);
    	translateSword1.play();
    	rotateSword1.play();
    	translateEnemy1.play();
    	translatePlayer1.play();
    	fadeSword.play();

    }
    
    @FXML
    void multiStrikeButton(ActionEvent event) {
    	Person DiceHero = new Person();

    	if(DiceHero.getMana() >= 4)
    	{
    		//4 mana to dice1 * dice1
    		System.out.println( list.get(DiceHero.getBattlesWon()).takeDamage(DiceHero.multistrike((rollingFunction()))));
    		BattleText.setText("Name here your hero will be named at the start " + " has used multi-strike! " + list.get(DiceHero.getBattlesWon()).getName() + " has " +  list.get(DiceHero.getBattlesWon()).getHealth() + ".");
    	}
    	else
    	{
    		BattleText.setText("You do not have enough mana");
    	}
//    	System.out.println(DiceHero.getHealth());
//    	DiceHero.takeDamage(1);
    	update();
		
    	//Animation
    	sword.setVisible(true);
    	heal.setVisible(false);
    	shield.setVisible(false);
    	translateSword2.play();
    	rotateSword2.play();
    	translateEnemy1.play();
    	translatePlayer1.play();
    	fadeSword.play();
    }
    
    @FXML
    void healButton(ActionEvent event) {
    	rollingFunction();
//    	dice.roll();
//		System.out.println("Dice one: " + dice.getDie1() + " Dice two: " + dice.getDie2());
//		System.out.println(list.get(DiceHero.getBattlesWon()).takeDamage( DiceHero.basicStrike(dice.getDie1())) );
//		
//		//System.out.println(DiceHero.takeDamage(list.get(DiceHero.getBattlesWon()).getAttackPower()));
//		System.out.println();
//		
//		if(DiceHero.getHealth() <= 0)
//		{
//			System.out.println( "NAME has died has died"); //DiceHero.getName() was removed
//		}
//		if(list.get(DiceHero.getBattlesWon()).getHealth() <= 0)
//		{
//			System.out.println(list.get(DiceHero.getBattlesWon()).getName() + " has died" );
//		}
//		
//		//System.out.println(DiceHero.getName() + " has " + DiceHero.getHealth() + " hp");
//		System.out.println(list.get(DiceHero.getBattlesWon()).getName() + " has " + list.get(DiceHero.getBattlesWon()).getHealth() + " hp");
//    	
//		
//		playerHealth.setText(DiceHero.getHealthRatio());
    	
    	//Animations 
    	sword.setVisible(false);
    	heal.setVisible(true);
    	shield.setVisible(false);
    	fadeHeal.play();

    }
    
    @FXML
    void defendButton(ActionEvent event) {
    	//Animations
//    	sword.setVisible(false);
//    	heal.setVisible(false);
//    	shield.setVisible(true);
//    	translateShield.play();
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
                        Thread.sleep(100);
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
        
        System.out.print(dice.getDie1());

    }
    
    
    
    
    @FXML
    void endTurn(ActionEvent event) throws InterruptedException {
    	Person DiceHero = new Person();
    	TwoDice dice = new TwoDice();
    	if(endTurn.getText().equals("End Turn"))
    	{
//    	BattleText.setText(list.get(DiceHero.getBattlesWon()).getName() + "'s turn" );
    	Thread.sleep(1000); //small delay 
    	//System.out.println(list.get(DiceHero.getBattlesWon()).getName() + " attacks " + "`Add hero's name later` " + "for " + list.get(DiceHero.getBattlesWon()).getAttackPower());
    	BattleText.setText(list.get(DiceHero.getBattlesWon()).getName() + " attacks " + "`Add hero's name later` " + "for " + list.get(DiceHero.getBattlesWon()).getAttackPower());
    	DiceHero.takeDamage(list.get(DiceHero.getBattlesWon()).getAttackPower());
    	endTurn.setText("Start turn");
    	}
    	else
    	{
    		DiceHero.addMana(rollingFunction());
    		BattleText.setText("Hero's name turn! Hero's name gains " + dice.getDie1() + " mana!");
    		endTurn.setText("End Turn");
    		
    	}
    	update();
    	
    	//TwoDice dice = new TwoDice();
    	if(endTurn.getText().equals("End Turn"))
    	{
//    	BattleText.setText(list.get(DiceHero.getBattlesWon()).getName() + "'s turn" );
    	Thread.sleep(1000); //small delay 
    	//System.out.println(list.get(DiceHero.getBattlesWon()).getName() + " attacks " + "`Add hero's name later` " + "for " + list.get(DiceHero.getBattlesWon()).getAttackPower());
    	BattleText.setText(list.get(DiceHero.getBattlesWon()).getName() + " attacks " + "`Add hero's name later` " + "for " + list.get(DiceHero.getBattlesWon()).getAttackPower());
    	DiceHero.takeDamage(list.get(DiceHero.getBattlesWon()).getAttackPower());
    	endTurn.setText("Start turn");
    	}
    	else
    	{
    		//DiceHero.addMana(rollingFunction());
    		BattleText.setText("Hero's name turn! Hero's name gains " + DiceHero.addMana(rollingFunction()) + " mana!");
    		endTurn.setText("End Turn");
    		
    	}
    	translateEnemy2.play();
    	translatePlayer2.play();
    	update();	
    }
    
    @FXML
    void battleWonScene(ActionEvent event) throws InterruptedException {
    	Person DiceHero = new Person();
    	//TwoDice dice = new TwoDice();
    	if(endTurn.getText().equals("End Turn"))
    	{
//    	BattleText.setText(list.get(DiceHero.getBattlesWon()).getName() + "'s turn" );
    	Thread.sleep(1000); //small delay 
    	//System.out.println(list.get(DiceHero.getBattlesWon()).getName() + " attacks " + "`Add hero's name later` " + "for " + list.get(DiceHero.getBattlesWon()).getAttackPower());
    	BattleText.setText(list.get(DiceHero.getBattlesWon()).getName() + " attacks " + "`Add hero's name later` " + "for " + list.get(DiceHero.getBattlesWon()).getAttackPower());
    	DiceHero.takeDamage(list.get(DiceHero.getBattlesWon()).getAttackPower());
    	endTurn.setText("Start turn");
    	}
    	else
    	{
    		//DiceHero.addMana(rollingFunction());
    		BattleText.setText("Hero's name turn! Hero's name gains " + DiceHero.addMana(rollingFunction()) + " mana!");
    		endTurn.setText("End Turn");
    		
    	}
    	update();	
    }
    @FXML
    void wonBattleNextScene(ActionEvent event) {
	Person DiceHero = new Person();
	DiceHero.setBattlesWon();
	
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
	
    public void update(){
    	Person DiceHero = new Person(); //have to do this to access stats
    	//playerName.setText("name here");
    	playerHealth.setText(DiceHero.getHealthRatio());
    	playerMana.setText(Integer.toString(DiceHero.getMana()));
    	EnemyName.setText(list.get(DiceHero.getBattlesWon()).getName());
    	EnemyHealth.setText(Integer.toString(list.get(DiceHero.getBattlesWon()).getHealth()));
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
                        Thread.sleep(100);
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

