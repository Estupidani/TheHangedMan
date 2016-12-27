package application;

import java.util.concurrent.ThreadLocalRandom;
import utilities.IOManager;
/**
 * Created by estupidani on 27/12/16.
 */
public class HangedMan implements WinFailGame {
    private Words words;
    private IOManager ioManager;
    private int lives;
    private GameMessages messages;

    public Words getWords() {
        return words;
    }

    public int getLives() {
        return lives;
    }

    public void setWords(Words words) {
        this.words = words;
    }

    public void setIoManager(IOManager ioManager) {
        this.ioManager = ioManager;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public GameMessages getMessages() {
        return messages;
    }

    public void setMessages(GameMessages messages) {
        this.messages = messages;
    }

    public HangedMan(int lives, int numberOfWords){
        this.setLives(lives);
        this.setWords(new Words(numberOfWords));
        this.setIoManager(new IOManager());
        this.setMessages(new GameMessages());
    }

    @Override
    public boolean winState() {
        return this.getWords().size() == 0 && this.getLives() > 0;
    }

    @Override
    public boolean failState() {
        return this.getLives() == 0;
    }

    public void play(){
        this.getMessages().welcomeMessage(this.getLives());
        do{
            Word word = this.getWords().get(ThreadLocalRandom.current().nextInt(0, this.getWords().size()));
            Words.remove(word);
            int error = word.length();
            while( error > 0 && !word.solved() ){
                char letter = this.ioManager.getChar();
                if (!word.showDiscovered(letter))
                    error--;
                this.getMessages().showCurrentState(word, error, this.getLives());
            }
            if ( error == 0 )
                this.setLives(this.getLives()-1);
            else messages.congratulationsMessage(this.getWords().size(), this.getLives());
        } while(!failState() && !winState());
        this.getMessages().goodByeMessage(this.winState());
    }

}
