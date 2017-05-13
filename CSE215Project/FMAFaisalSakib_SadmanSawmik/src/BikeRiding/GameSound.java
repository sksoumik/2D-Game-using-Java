package BikeRiding;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class GameSound 
{
	public static void music()
	{
		
		try
		{			
			File coinSound = new File("coinSound.wav");
			AudioInputStream ais =AudioSystem.getAudioInputStream(coinSound);
			Clip clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();
		}
		catch(Exception e){}
	}
}