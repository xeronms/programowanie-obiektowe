import exceptions.*;

import java.io.File;
import java.io.IOException;


public class Main {

    public static void main(String args[]) {
        final File in = new File(args[0]);
        final File out = new File(args[1]);

        try {

            Subtitles.delay(in, out, Integer.parseInt(args[2]), Integer.parseInt(args[3]));

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}