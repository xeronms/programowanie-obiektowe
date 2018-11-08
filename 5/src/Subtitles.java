import exceptions.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class Subtitles {

    public static void delay (File in, File out,int delay, int fps)
            throws CharacterSequenceException, PatternMatchingException, IOException {

        List<String> lines = Files.readAllLines(in.toPath());
        //BufferedWriter writer = new BufferedWriter(new FileWriter(out));
        StringBuilder sb = new StringBuilder();
        int i=0;

        String pattern = "^\\{\\d+}\\{\\d+}.*";

        for ( String line : lines ){
            ++i;

            if ( ! line.matches(pattern))
                throw new PatternMatchingException(i);

            // here i check if there is not such situation as {2323}{11}, where 2323>11
            String Numbers[] = line.split("}", 3);
            Numbers[0] = Numbers[0].replaceAll("\\D+","");
            Numbers[1] = Numbers[1].replaceAll("\\D+","");

            if ( Integer.parseInt( Numbers[0]) >= Integer.parseInt( Numbers[1]) )
                throw new CharacterSequenceException(i);
        }
    }
}
