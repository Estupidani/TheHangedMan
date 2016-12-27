package application;

/**
 * Created by estupidani on 27/12/16.
 */
public class Word {
    private Letter[] letters;

    private Letter[] getLetters() {
        return letters;
    }

    private Letter getLetters(int index){
        return this.letters[index];
    }

    private void setLetters(Letter[] letters) {
        this.letters = letters;
    }

    private void setLetters(int index, Letter letter){
        this.letters[index] = letter;
    }

    public Word(String word){
        Letter[] letters = new Letter[word.length()];
        for ( int i = 0; i < word.length() ; i++ )
            letters[i] = new Letter(word.charAt(i));
        this.setLetters(letters);
    }

    public int length(){
        return this.getLetters().length;
    }

    public boolean solved(){ //Returns true in case all letters have been discovered
        boolean solved = true;
        int i = 0;
        while( i < this.length() && solved ){
            solved = this.getLetters(i).isDiscovered();
            i++;
        }
        return solved;
    }

    public boolean showDiscovered(char letter){ //Changes the selected letters to discovered and returns false if there weren't any
        boolean anyDiscovered = false;
        for( int i = 0; i < this.length() ; i++ )
            if( this.getLetters(i).getCharacter() == letter ){
                if (!anyDiscovered)
                    anyDiscovered = true;
                this.setLetters(i, new Letter(letter, true));
            }
        return anyDiscovered;
    }

    @Override
    public String toString() {
        String string = "";
        for ( int i = 0; i < this.length() ; i++ ){
            Letter letter = this.getLetters(i);
            if(letter.isDiscovered())
                string+=letter.getCharacter();
            else string+='*';
        }
        return string;
    }
}
