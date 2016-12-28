package application;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by estupidani on 27/12/16.
 */
public class Words extends ArrayList<Word> {
    private Word[] wordArray = {new Word("farfullar"), new Word("rododendro"), new Word("chipiriflautico"), new Word("helicoptero"),
                            new Word("concupiscencia"), new Word("berenjena"), new Word("ñandu"),new Word("dingolondango"),
                            new Word("espeleologia"), new Word("saltimbanquismo"), new Word("tiquismiquis"), new Word("desentenebrecerse"),
                            new Word("tragaldabas"), new Word("monocromo"), new Word("quid"), new Word("xenon"), new Word("zoo"),
                            new Word("botarate"), new Word("alfeñique"), new Word("petimetre"), new Word("dodecaedro"),
                            new Word("palindromo"), new Word("retruecano"), new Word("paparrucha"), new Word("cojondongo"),
                            new Word("frontispicio"), new Word("alcahueta"), new Word("rimbombante"), new Word("percal"),
                            new Word("empantanar"), new Word("sirimiri"), new Word("altramuz"), new Word("pimpollo"),
                            new Word("alcaparra"), new Word("zarangollo"), new Word("fanfoscas")};

    private Word[] getWordArray() {
        return wordArray;
    }

    private Word getWordArray(int index){
        return this.wordArray[index];
    }

    public Words(int numberOfWords){
        ArrayList<Word> auxiliarWordArray = new ArrayList<Word>();
        for(int i = 0; i < this.getWordArray().length ; i++ )
            auxiliarWordArray.add(this.getWordArray(i));
        for( int i = 0; i < numberOfWords ; i++ )
            this.add(auxiliarWordArray.remove(ThreadLocalRandom.current().nextInt(0, auxiliarWordArray.size())));
    }
}
