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
        System.out.println(pattern);
        for ( String line : lines ){
            ++i;

           // String firstNumber =
            System.out.println(Integer.parseInt(line));

            if ( ! line.matches(pattern))
                throw new PatternMatchingException(i);
        }
    }
}
