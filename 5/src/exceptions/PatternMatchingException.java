package exceptions;

public class PatternMatchingException extends Exception {

    public PatternMatchingException(int line){
        super("Pattern not matching in line " + Integer.toString(line));
    }
}