package application.model;

import java.io.File;
import java.net.MalformedURLException;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MusicManager {
	
	private static MediaPlayer mp;
	
	public static void loadSong(String fileName) throws MalformedURLException
	{
		File media = new File(fileName);
		Media song = new Media(media.toURI().toURL().toString());
		mp = new MediaPlayer(song);
		mp.setOnEndOfMedia(new Runnable() {
        	@Override
        	public void run()
        	{
        		mp.seek(mp.getStartTime());
        	}
        });
    	mp.setVolume(0.1);
	}
	
	public static void playS()
	{
		mp.play();
	}
	
	public static void pauseS()
	{
		mp.pause();
	}
	
	public static void stopS()
	{
		mp.stop();
	}
	


}