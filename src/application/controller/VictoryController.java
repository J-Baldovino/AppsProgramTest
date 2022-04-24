package application.controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;




import application.model.Champions;
import application.model.Person;
import application.model.Victory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

public class VictoryController {
	
	MediaPlayer mp;
	MediaPlayer smp;
	
	@FXML
	private AnchorPane tC;
	
	@FXML
    private TableView<Champions> victoryTable;
	
	@FXML
    private TableColumn<Champions, String> cName;

	@FXML
    private TableColumn<Champions,String> cScore;
	
	@FXML
    private ImageView handS;

    @FXML
    private Button submitButton;

    @FXML
    private TextField winName;

    @FXML
    private TextField winScore;
    
    @FXML
    private void initialize() throws IOException
    {
    	handS.setVisible(false);
    	File media = new File("music/win.mp3");
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
      
        cName.setCellValueFactory(new PropertyValueFactory<Champions,String>("Name"));
        cScore.setCellValueFactory(new PropertyValueFactory<Champions,String>("Score"));
        
        Person DiceHero = new Person();
        winName.setText(DiceHero.retName());
        winScore.setText(Integer.toString(DiceHero.getScore()));
        Victory.addVictor(winName.getText(), winScore.getText());
        
        victoryTable.setItems(getChampions());
//        System.out.print(DiceHero.getScore());
    }

    @FXML
    void submit(ActionEvent event) throws IOException {
    	File media = new File("music/select.mp3");
    	Media effect = new Media(media.toURI().toURL().toString());
    	smp= new MediaPlayer(effect);
    	smp.setStartTime(new Duration(600));
    	smp.setVolume(0.3);
    	smp.play();
//    	Victory.addVictor(winName.getText(), winScore.getText());
    	try {
    		mp.stop();
    		URL url = new File("Title.fxml").toURI().toURL();
    		URL styleUrl = new File("src/application/application.css").toURI().toURL();
			tC = FXMLLoader.load(url);
			Stage title= (Stage) ((Node)event.getSource()).getScene().getWindow();
			Scene scene = new Scene(tC);
			scene.getStylesheets().add(styleUrl.toString());
			title.setScene(scene);
			title.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void sSelect(MouseEvent event) throws MalformedURLException {
    	handS.setVisible(true);
    	File media = new File("music/select.mp3");
    	Media effect = new Media(media.toURI().toURL().toString());
    	smp= new MediaPlayer(effect);
    	smp.setStartTime(new Duration(600));
    	smp.setVolume(0.3);
    	smp.play();
    }

    @FXML
    void sDeselect(MouseEvent event) {
    	handS.setVisible(false);
    	smp.stop();
    }
    
    public ObservableList<Champions> getChampions() throws IOException
    {
    	ObservableList<Champions> winList= FXCollections.observableArrayList();
    	ArrayList<Champions> winArray= new ArrayList<Champions>();
    	
    	winArray=Victory.sendVictors();
    	
    	for(int i=0;i<winArray.size();i++)
    	{
    		winList.add(winArray.get(i));
    	}
    	
		return winList;
    	
    }

}