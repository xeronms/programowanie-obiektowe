package cipher;

public interface Algorithm {

    String crypt( String in );

    String decrypt( String in );
}
