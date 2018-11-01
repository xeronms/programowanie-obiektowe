import cipher.Cryptographer;
import cipher.ROT11;

public class Main {

    public static void main( String args[]){

        ROT11 cipher = new ROT11();

        System.out.print(cipher.crypt("abcxyz")  + cipher.decrypt( cipher.crypt("abcxyz a")));

        Cryptographer.cryptfile( ,args[0]);

    }
}
