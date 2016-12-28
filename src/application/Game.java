package application;

/**
 * Created by estupidani on 27/12/16.
 */
public class Game {
    public static void main(String[] args){
        int lives = 9, numberOfWords = 1;
        HangedMan hangedMan = new HangedMan(lives, numberOfWords);
        hangedMan.play();
    }
}
