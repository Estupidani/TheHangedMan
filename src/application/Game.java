package application;

/**
 * Created by estupidani on 27/12/16.
 */
public class Game {
    public static void main(String[] args){
        int vidas = 10, palabras = 9;
        HangedMan hangedMan = new HangedMan(vidas, palabras);
        hangedMan.play();
    }
}
