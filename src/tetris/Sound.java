package tetris;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import static javax.sound.sampled.Clip.LOOP_CONTINUOUSLY;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class Sound {
    
    private String soundsFile = "tetrissounds" + File.separator;
    
    private String themePath = soundsFile + "tetris.wav";
    private String hitBottomPath = soundsFile + "fall.wav";
    private String startGamePath = soundsFile + "success.wav";
    private String  clearLinePath = soundsFile + "line.wav";
    private String gameOverPath = soundsFile + "finish.wav";

    private Clip clearLineSound, gameOverSound, hitBottomSound, startGameSound, themeSound;
    
    public Sound(){
        
        try {
            themeSound = AudioSystem.getClip();
            startGameSound = AudioSystem.getClip();
            hitBottomSound = AudioSystem.getClip();
            clearLineSound = AudioSystem.getClip();
            gameOverSound = AudioSystem.getClip();
            
            themeSound.open(AudioSystem.getAudioInputStream(new File(themePath).getAbsoluteFile()));  
            startGameSound.open(AudioSystem.getAudioInputStream(new File(startGamePath).getAbsoluteFile()));  
            hitBottomSound.open(AudioSystem.getAudioInputStream(new File(hitBottomPath).getAbsoluteFile()));  
            clearLineSound.open(AudioSystem.getAudioInputStream(new File(clearLinePath).getAbsoluteFile()));  
            gameOverSound.open(AudioSystem.getAudioInputStream(new File(gameOverPath).getAbsoluteFile()));
            
            FloatControl gainControl = (FloatControl) themeSound.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-25.0f); 
            
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void stopTheme(){
        themeSound.stop();
    }
    public void playTheme(){
        
        themeSound.setFramePosition(0);
        themeSound.start();
        themeSound.loop(LOOP_CONTINUOUSLY);
    }
    public void playStartGame(){
        
        startGameSound.setFramePosition(0);
        startGameSound.start();
    }
    public void playHitBottom(){
        
        hitBottomSound.setFramePosition(0);
        hitBottomSound.start();
    }
    public void playClearLine(){
        
        clearLineSound.setFramePosition(0);
        clearLineSound.start();
    }
    public void playGameOver(){
        
        gameOverSound.setFramePosition(0);
        gameOverSound.start();
    }
}
