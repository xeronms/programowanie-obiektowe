package exceptions;

public class PatternMatchingException extends Exception {

    public PatternMatchingException(int line, String content){
        super("Pattern not matching in line " + Integer.toString(line) + ":\n"
        + content);
    }
}