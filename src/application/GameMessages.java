package application;

import utilities.IOManager;

import java.util.ArrayList;

/**
 * Created by estupidani on 27/12/16.
 */
public class GameMessages {
    private IOManager ioManager;

    public void setIoManager(IOManager ioManager) {
        this.ioManager = ioManager;
    }

    public GameMessages(){
        this.setIoManager(new IOManager());
    }
    public void welcomeMessage(int lives){
        String message = "Welcome to the Hanged Man Game by Daniel Rubio\n";
        message += "You start with "+lives+" lives. Every time you fail a word, you lose one.\n";
        message += "For each word you get to make as many mistakes as characters in said word. You should know the rest of" +
                "the rules, and if you don't just google them.\n";
        this.ioManager.outln(message);
    }
    private String stringUsedCharacters(ArrayList<Character> usedCharacters){
        String characters = "";
        for(int i = 0; i < usedCharacters.size() ; i++ )
            characters += usedCharacters.get(i)+", ";
        characters += "\n";
        return characters;
    }

    public void showCurrentState(Word word, int error, int lives, ArrayList<Character> usedCharacters){
        String message = "---Current State---\n";
        message += "Your word looks like this: " + word.toString()+"\n";
        if(usedCharacters.size() > 0 )
            message += this.stringUsedCharacters(usedCharacters);
        message += "You have "+error+ " mistake(s) left\n";
        message += "You have "+lives+" live(s) left\n";
        this.ioManager.out(message);
    }

    public void failMessage(Word word,int size, int lives){
        String message = "Ouch! You didn't guess that one!\n";
        message += "The word you were trying to guess was '"+word.toStringCharacters()+"'\n";
        message += "You still have "+size+" word(s) to go and "+lives+" live(s) to succeed!\n";
        this.ioManager.outln(message);

    }
    public void congratulationsMessage(int size, int lives){
        String message = "Congratulations! You guessed this word. Just "+ size+ " to go!\n";
        message += "You have "+lives+" lives to achieve it\n";
        this.ioManager.outln(message);
    }

    public void goodByeMessage(boolean wins){
        String message = "Thanks for playing!\n";
        if ( wins )
            message += "You showed who's boss!\n";
        else message+= "Better luck next time!\n";
        this.ioManager.out(message);
    }
}
