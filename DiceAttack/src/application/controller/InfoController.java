package application.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class InfoController {

    @FXML
    private ImageView backgroundPicture;

    @FXML
    private Button homebutton;

    @FXML
    private AnchorPane mainPane;

    @FXML
    public void homebutton(ActionEvent event) throws IOException {
		mainPane = FXMLLoader.load(getClass().getClassLoader().getResource("Main.fxml"));
		Scene scene = new Scene(mainPane);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene);
    }
	
    
    
    
//	@FXML
//    private void initialize() {
//		Classifieds classified = new Classifieds("Help Wanted");
//		try {
//			classified.loadAds("ads.csv");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		//System.out.println( classified );
//		//String job,jobType, phone, name, date;
//		Header.setText(classified.getName());
//		label1.setText(classified.getJob(0) + "\n\n\n\n(" + classified.getjobType(0) + ")\n" + classified.getPhone(0) + "\n\n\n\nPosted by " + classified.getName(0) + ", " + classified.getDate(0) );
//		label2.setText(classified.getJob(1) + "\n\n\n\n(" + classified.getjobType(1) + ")\n" + classified.getPhone(1) + "\n\n\n\nPosted by " + classified.getName(1) + ", " + classified.getDate(1) );
//		label3.setText(classified.getJob(2) + "\n\n\n\n(" + classified.getjobType(2) + ")\n" + classified.getPhone(2) + "\n\n\n\nPosted by " + classified.getName(2) + ", " + classified.getDate(2) );
//		label4.setText(classified.getJob(3) + "\n\n\n\n(" + classified.getjobType(3) + ")\n" + classified.getPhone(3) + "\n\n\n\nPosted by " + classified.getName(3) + ", " + classified.getDate(3) );
//
//		
//    }
}