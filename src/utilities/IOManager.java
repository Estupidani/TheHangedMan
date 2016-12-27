package utilities;

import java.util.Scanner;
/**
 * Created by estupidani on 27/12/16.
 */
public class IOManager{
    private Scanner scanner;

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public IOManager(){
        this.setScanner(new Scanner(System.in));
    }

    public void out(String string){
        System.out.print(string);
    }

    public void outln(String string){
        System.out.println(string);
    }

    public char getChar(){
        String read = scanner.nextLine();
        return read.charAt(0);
    }
}
