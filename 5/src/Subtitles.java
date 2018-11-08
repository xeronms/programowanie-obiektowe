import exceptions.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class Subtitles {

    public static void delay (File in, File out,int delay, int fps)
            throws PatternMatchingException, CharacterSequenceException, IOException, Exception{

        List<String> lines = Files.readAllLines(in.toPath());
        BufferedWriter writer = new BufferedWriter(new FileWriter(out));
        StringBuilder sb = new StringBuilder();

        int start,end, change;
        int i=0;

        String pattern = "^\\{\\d+}\\{\\d+}.*";

        for ( String line : lines ) {
            ++i;

            try {
                if (!line.matches(pattern))
                    throw new PatternMatchingException(i, line);

                String Numbers[] = line.split("}");
                Numbers[0] = Numbers[0].replaceAll("\\D+", "");
                Numbers[1] = Numbers[1].replaceAll("\\D+", "");
                start = Integer.parseInt(Numbers[0]);
                end = Integer.parseInt(Numbers[1]);

                if (start >= end)
                    throw new CharacterSequenceException(i, line);

                change = delay * fps;

                start += change;
                end += change;

                sb.append("{");
                sb.append(start);
                sb.append("}{");
                sb.append(end);

                for (int j = 2; j < Numbers.length; ++j) {
                    sb.append("}");
                    sb.append(Numbers[j]);
                    sb.append("\n");
                }
            }

            catch (CharacterSequenceException|PatternMatchingException e){
                throw e;
            }
            catch (Exception e){
                throw new Exception("Unknown exception in line" + Integer.toString(i) +
                        ":\n" + line );
            }
        }
        writer.write( sb.toString() );
        writer.close();
    }
}
