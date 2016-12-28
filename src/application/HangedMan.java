package application;

import java.util.ArrayList;
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

    public Word getWords(int index){
        return this.words.get(index);
    }

    public void setWords(Words words) {
        this.words = words;
    }

    public void setWords(int index, Word word){
        this.words.set(index,word);
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
        if( numberOfWords < lives )
            lives = numberOfWords - 1; //If there are more lives than words it's impossible to lose. There's no need to trigger an exception
        this.setLives(lives);
        this.setWords(new Words(numberOfWords));
        this.setIoManager(new IOManager());
        this.setMessages(new GameMessages());
    }

    @Override
    public boolean winState() {
        return this.getWords().size() == 0 && this.getLives() >= 0;
    }

    @Override
    public boolean failState() {
        return this.getLives() == -1;
    }

    private Word selectWord(){//Selects a random word from words and deletes it right after
        Word newWord = this.getWords(ThreadLocalRandom.current().nextInt(0, this.getWords().size()));
        Words auxiliarWords = this.getWords();
        auxiliarWords.remove(newWord);
        this.setWords(auxiliarWords);
        return newWord;
    }

    private int wordGuess(Word word){
        int errors = word.length();
        ArrayList<Character> usedCharacters = new ArrayList<Character>();
        while( errors > 0 && !word.solved() ){
            this.getMessages().showCurrentState(word, errors, this.getLives(), usedCharacters);
            char letter = this.ioManager.getChar();
            if (!usedCharacters.contains(letter)){
                usedCharacters.add(letter);
                if (!word.showDiscovered(letter))
                    errors--;
            }
            else this.getMessages().repeatedLetter();
        }
        return errors;
    }

    private void failedWord(Word word){
        this.setLives(this.getLives() - 1);
        this.getMessages().failMessage(word, this.getWords().size(), this.getLives());
    }
    public void play(){
        this.getMessages().welcomeMessage(this.getLives());
        do{
            Word word = this.selectWord();
            int errors = this.wordGuess(word);
            if ( errors == 0 )
                this.failedWord(word);
            else this.getMessages().congratulationsMessage(this.getWords().size(), this.getLives());
        } while(!failState() && !winState());
        this.getMessages().goodByeMessage(this.winState());
    }

}
