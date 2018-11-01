import cipher.Cryptographer;
import cipher.Polibius;
import cipher.ROT11;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main( String args[]){
        final File in = new File(args[0]);
        final File out= new File(args[1]);

        ROT11 cipher = new ROT11();
        Polibius cipher2 = new Polibius();

        try {
            Cryptographer.decryptfile(in, out, cipher2);
        }
        catch (IOException e){System.out.print("INVALID PATH");}

    }
}
