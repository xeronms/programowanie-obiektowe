import cipher.Cryptographer;
import cipher.ROT11;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main( String args[]){
        final File in = new File(args[0]);
        final File out= new File(args[1]);

        ROT11 cipher = new ROT11();

        System.out.print(cipher.crypt("abcxyz")  + cipher.decrypt( cipher.crypt("abcxyz a")));


        try {
            Cryptographer.cryptfile(in, out, cipher);
        }
        catch (IOException e){System.out.print("INVALID PATH");}

    }
}
