package application.controller;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

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
    private Label enemyHpL;
	
	@FXML
    private Label manaL;
	
	@FXML
    private Label healthL;
	
	@FXML
    private Label shieldL;
	
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
    private Label BattleText;
    
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
    private TranslateTransition translateEnemy1 = new TranslateTransition();
    private TranslateTransition translateEnemy2 = new TranslateTransition();
    private TranslateTransition translatePlayer1 = new TranslateTransition();
    private TranslateTransition translatePlayer2 = new TranslateTransition();

    private FadeTransition fadeHeal = new FadeTransition();
    private TranslateTransition translateShield = new TranslateTransition();
    private FadeTransition fadeSword = new FadeTransition();
    private FadeTransition fadeShield = new FadeTransition();

    Random random = new Random();
    
    @FXML private URL location;
    @FXML private ResourceBundle resources;
    
    //ARNOLD PART //This is where I will put the players name but it is set at the moment
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
        
        
		Monster gremlin;
		String MonsterName="Monster";
		if(DiceHero.getBattlesWon()>=1)
		{
			MonsterName="Dragon";
			File file = new File("/../../images/dragon3333.png");
            System.out.print(dice.getDie1() + " ");
            goomba.setImage(new Image(file.toURI().toString()));
		}
		gremlin = new Monster(MonsterName+" " + "LV "+Integer.toString(DiceHero.getBattlesWon() + 1), 10 + DiceHero.getBattlesWon() * 5, 3 + DiceHero.getBattlesWon());
		list.add(gremlin);
	

		
		playerName.setText(DiceHero.retName());
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

		//Preparing fade animation for shield
		fadeShield.setNode(shield);
		fadeShield.setDuration(Duration.millis(550));
		fadeShield.setCycleCount(2);
		fadeShield.setInterpolator(Interpolator.EASE_OUT); //Causes the animation to slow down near the end of the sequence
		fadeShield.setAutoReverse(true);
		fadeShield.setFromValue(0); //original opacity value
		fadeShield.setToValue(1);	//target opacity value

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
    	BattleText.setText(DiceHero.retName() + " has used basic strike! \n" + list.get(0).takeDamage(DiceHero.basicStrike(rollingFunction()))+".");
        System.out.println("The monster's hp is now = " + Integer.toString(list.get(0).getHealth()) + "\n");
        DiceHero.subMana(1);
        update();
        
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
    		BattleText.setText(DiceHero.retName() + " has used multi-strike! " + list.get(0).takeDamage(DiceHero.multistrike((rollingFunction()))) + ".");
    		DiceHero.subMana(4);
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
    	else
    	{
    		BattleText.setText("You do not have enough mana");
    	}
    	update();
    }
    
    @FXML
    void healButton(ActionEvent event) {
    	Person DiceHero = new Person();
    	
    	if(DiceHero.getMana() >= 3)
    	{
    	int d=rollingFunction();	
    	DiceHero.healing(d);
        DiceHero.subMana(3);
        update();
        BattleText.setText(DiceHero.retName() + " has used heal! " + DiceHero.retName()+" has recovered "+d+" hp.");

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
    	
    	//please help God");
        DiceHero.subMana(2);
        update();
        BattleText.setText(DiceHero.retName() + " defends for " + DiceHero.defending(rollingFunction()) + ".");

        //Animations
    	sword.setVisible(false);
    	heal.setVisible(false);
    	shield.setVisible(true);
    	translateShield.play();
    	fadeShield.play();
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
    	if(endTurn.getText().equals("End Turn"))
    	{
    	Thread.sleep(50); //small delay 
    	BattleText.setText(list.get(0).getName() + " attacks " +DiceHero.retName()+ " for " + list.get(0).getAttackPower());
    	DiceHero.takeDamage(list.get(0).getAttackPower());
    	endTurn.setText("Start turn");
    	DiceHero.resetShield(); //shield goes to zero after enemy attacks
    	basicAttackButton.setDisable(true);
    	multiAttackButton.setDisable(true);
    	healButton.setDisable(true);
    	defendButton.setDisable(true);
    	translateEnemy2.play();
    	translatePlayer2.play();
    	}
    	else
    	{
    		BattleText.setText(DiceHero.retName() + " turn! "+DiceHero.retName()+" gains " + DiceHero.addMana(rollingFunction()) + " mana!");
    		endTurn.setText("End Turn");
        	basicAttackButton.setDisable(false);
        	multiAttackButton.setDisable(false);
        	healButton.setDisable(false);
        	defendButton.setDisable(false);
    	}
    	update();
    }
    
    @FXML
    void battleWonScene(ActionEvent event) {
    	mp.stop();
    	Person DiceHero = new Person();
    	DiceHero.setBattlesWon();
    	DiceHero.setScore();
    	if(DiceHero.getHealth() <= 0)
    	{
    		mp.stop();
	    	DiceHero.reset();
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
	    	update();
		}
    	
    	else if(DiceHero.getBattlesWon() < 2)
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
    	playerHealth.setText(DiceHero.getHealthRatio());
    	playerMana.setText(Integer.toString(DiceHero.getMana())+"/"+DiceHero.getMaxMana());
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
    		BattleText.setText("You won! Click next scene.");
    	}
    	else if(DiceHero.getHealth()<= 0)
    	{
        	basicAttackButton.setDisable(true);
        	multiAttackButton.setDisable(true);
        	healButton.setDisable(true);
        	defendButton.setDisable(true);
        	endTurn.setDisable(true);
    		battleWonScene.setVisible(true);
    		BattleText.setText(DiceHero.retName()+" has been defeated!Click for next scene");
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