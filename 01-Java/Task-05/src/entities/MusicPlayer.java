package entities;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class MusicPlayer {

    private Clip clip;

    public void playerIntroMusic(){
        String filePathIntro = "src/resources/musicaintro.wav";
        playMusic(filePathIntro);}
    public void playerBattleMusic(){
        String filePathBattle = "src/resources/musicabatalha.wav";
        playMusic(filePathBattle);}
    public void playerGameOverMusic(){
        String filePathGameOver = "src/resources/gameover.wav";
        playMusic(filePathGameOver);}
    public void playerWinMusic(){
        String filePathWin = "src/resources/musicavitoria.wav";
        playMusic(filePathWin);}
    public void playerEscapeMusic(){
        String filePathEscape = "src/resources/musicaescapar.wav";
        playMusic(filePathEscape);}
    public void playerDodgeMusic(){
        String filePathDodge = "src/resources/musicaesquiva.wav";
        playMusic(filePathDodge);}
    public void playerAttackMusic(){
        String filePathAttack = "src/resources/musicaataque.wav";
        playMusic(filePathAttack);}

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
