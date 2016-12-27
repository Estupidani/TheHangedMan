package utilities;

import java.util.Scanner;
/**
 * Created by estupidani on 27/12/16.
 */
public class IOManager extends Scanner{

    public IOManager(){
        super(System.in);
    }

    public void out(String string){
        System.out.print(string);
    }

    public void outln(String string){
        System.out.println(string);
    }

    public char getChar(){
        String read = this.nextLine();
        return read.charAt(0);
    }
}
