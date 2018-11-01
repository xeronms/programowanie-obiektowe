import cipher.Cryptographer;
import cipher.Polibius;
import cipher.ROT11;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main( String args[]){
        final File in = new File(args[0]);
        final File out= new File(args[1]);

        ROT11 cipher = new ROT11();
        Polibius cipher2 = new Polibius();

        char c1='4',c2;
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print(" Choose to:\n" +
                    "1. Crypt\n" +
                    "2. Decrypt\n");
            c1 = scanner.nextLine().charAt(0);

            System.out.print(" Choose algorithm:\n" +
                    "1. ROT11\n" +
                    "2. Polibius\n");
            c2 = scanner.nextLine().charAt(0);

            if ( c1 == '1' && c2 == '1'){
                Cryptographer.cryptfile(in,out,cipher);
                System.out.println("done\n");}
            if ( c1 == '1' && c2 == '2'){
                Cryptographer.cryptfile(in,out,cipher2);
                System.out.println("done\n");}
            if ( c1 == '2' && c2 == '1'){
                Cryptographer.decryptfile(in,out,cipher);
                System.out.println("done\n");}
            if ( c1 == '2' && c2 == '2'){
                Cryptographer.decryptfile(in,out,cipher2);
                System.out.println("done\n");}
        }
        catch (IOException e){System.out.print("INVALID PATH");}

    }
}
