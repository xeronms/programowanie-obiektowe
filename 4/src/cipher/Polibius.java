package cipher;

public class Polibius implements Algorithm {
    private final char[][] alphabet = {{'A','B','C','D','E'},
            {'F','G','H','I','K'}, {'L','M','N','O','P'},
            {'Q','R','S','T','U'}, {'V','W','X','Y','Z'}};

    public String crypt( String in ){
        StringBuilder out = new StringBuilder();

        for ( char letter : in.toCharArray() ){
            if ( Character.toUpperCase(letter) == 'J') {
                out.append(2);
                out.append(4);
            }
            for ( int i = 1; i<6; ++i){
                for ( int j = 1; j<6; ++j){
                    if ( Character.toUpperCase(letter) == alphabet[i-1][j-1]) {
                        out.append(i);
                        out.append(j);
                    } } }
        }

        return out.toString();
    }


    public String decrypt( String in ) {
        StringBuilder out = new StringBuilder();
        int i,j;

        for ( int it = 0; it < in.length(); it++) {
            i = in.charAt(it)-48;
            j = in.charAt(++it)-48;
            out.append( alphabet[i-1][j-1]);
        }

        return out.toString();
    }

}
