package exceptions;

public class CharacterSequenceException extends Exception {

    public CharacterSequenceException(int line, String content){
        super("Wrong character sequence in line " + Integer.toString(line) + ":\n"
                + content);
    }
}
