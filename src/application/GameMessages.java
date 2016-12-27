package application;

import utilities.IOManager;
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
        this.ioManager.out(message);
    }

    public void showCurrentState(Word word, int error, int lives){
        String message = "---Current State---\n";
        message += "Your word looks like this: " + word.toString()+"\n";
        message += "You have "+error+ " mistake(s) left\n";
        message += "You have "+lives+" live(s) left\n";
        this.ioManager.out(message);
    }

    public void congratulationsMessage(int size, int lives){
        String message = "Congratulations! You guessed this word. Just "+ size+ " to go!\n";
        message += "You have "+lives+" lives to achieve it\n";
        this.ioManager.out(message);
    }

    public void goodByeMessage(boolean wins){
        String message = "Thanks for playing!\n";
        if ( wins )
            message += "You showed who's boss!\n";
        else message+= "Better luck next time!\n";
        this.ioManager.out(message);
    }
}
