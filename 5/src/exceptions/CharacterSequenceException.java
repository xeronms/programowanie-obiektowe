package exceptions;

public class CharacterSequenceException extends Exception {

    public CharacterSequenceException(int line){
        super("Wrong character sequence in line " + Integer.toString(line));
    }
}
