package cipher;

public class ROT11 implements Algorithm {

    public String crypt( String in ){
        StringBuilder out = new StringBuilder();

        for ( char letter : in.toCharArray() ){
            if ( letter < 'a' || letter > 'z' )
                break;
            if ( letter <= 'o')
                letter += 11;
            else
                letter -= 15;

            out.append(letter);
        }


        return out.toString();
    }


    public String decrypt( String in ){
        StringBuilder out = new StringBuilder();

        for ( char letter : in.toCharArray() ){
            if ( letter < 'a' || letter > 'z' )
                break;
            if ( letter >= 'l')
                letter -= 11;
            else
                letter += 15;

            out.append(letter);
        }

        return out.toString();
    }
}
