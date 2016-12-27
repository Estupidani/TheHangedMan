package application;

/**
 * Created by estupidani on 27/12/16.
 */
public class Letter {
    private char character;
    private boolean discovered;

    public char getCharacter() {
        return character;
    }

    public boolean isDiscovered() {
        return discovered;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public void setDiscovered(boolean discovered) {
        this.discovered = discovered;
    }

    public Letter( char character ){
        this.setCharacter(character);
        this.setDiscovered(false);
    }

    public Letter(char character, boolean discovered){
        this.setCharacter(character);
        this.setDiscovered(discovered);
    }
}
