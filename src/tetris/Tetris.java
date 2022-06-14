package tetris;

import javax.swing.JOptionPane;

/**
 *
 * @author aaqib
 */
public class Tetris {
    
    private static GameForm gf;
    private static StartUpForm sf;
    private static LeaderboardForm lf;
    
    private static Sound sound = new Sound();
    
    public static void start(){
        
        gf.setVisible(true);
        gf.startGame();
    }
    
    public static void showStartUp(){
        sf.setVisible(true);
    }
    
    public static void showLeaderboard(){
        lf.setVisible(true);
    }
    public static void gameOver(int score){
        
        playGameover();
        Tetris.stopThemeMusic();
        String playerName = JOptionPane.showInputDialog("Game Over! \nEnter your name in the leaderboard.");
        
        gf.setVisible(false);
        lf.addPlayer(playerName, score);
    }
    public static void stopThemeMusic(){
        sound.stopTheme();
    }
    public static void playThemeMusic(){
        sound.playTheme();
    }
    public static void playStart(){
        sound.playStartGame();
    }
    public static void playHitbottom(){
        sound.playHitBottom();
    }
    public static void playClear(){
        sound.playClearLine();
    }
    public static void playGameover(){
        sound.playGameOver();
    }
    
    public static void main(String[] args) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                gf = new GameForm();
                sf = new StartUpForm();
                lf = new LeaderboardForm();

                sf.setVisible(true);
            }
        });
    }
    
}
