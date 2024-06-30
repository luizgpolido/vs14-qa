package entities;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class MusicPlayer {

    String filePathIntro = "src/resources/musicaintro.wav";
    String filePathBattle = "src/resources/musicabatalha.wav";
    String filePathGameOver = "src/resources/gameover.wav";
    String filePathWin = "src/resources/musicavitoria.wav";



    private Clip clip;

    public void playerIntroMusic(){
        playMusic(filePathIntro);
    }
    public void playerBattleMusic(){
        playMusic(filePathBattle);
    }
    public void playerGameOverMusic(){
        playMusic(filePathGameOver);
    }
    public void playerWinMusic(){
        playMusic(filePathWin);
    }

    public void playMusic(String filePath){
        try{
            File audioFile = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

            clip = AudioSystem.getClip();
            clip.open(audioStream);

            clip.start();

        }catch (IOException | LineUnavailableException e){
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        }
    }

    public void stopMusic(){
        clip.stop();
        clip.close();
    }
}
