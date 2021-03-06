package cipher;


import java.io.*;
import java.nio.file.Files;
import java.util.List;

public class Cryptographer {

    public static void cryptfile(File input, File output, Algorithm cipher ) throws IOException {

        List<String> lines  = Files.readAllLines(input.toPath());
        BufferedWriter out = new BufferedWriter(new FileWriter(output));
        StringBuilder sb = new StringBuilder();

        for( String line : lines){
            for ( String word : line.split(" ",0)){
                sb.append(cipher.crypt(word) + " ");
            }
            sb.append("\n");
        }
        out.write( sb.toString() );
        out.close();
    }

    public static void decryptfile(File input, File output, Algorithm cipher ) throws IOException {

        List<String> lines  = Files.readAllLines(input.toPath());
        BufferedWriter out = new BufferedWriter(new FileWriter(output));
        StringBuilder sb = new StringBuilder();

        for( String line : lines){
            for ( String word : line.split(" ")){
                sb.append(cipher.decrypt(word) + " ");
            }
            sb.append("\n");
        }
        out.write( sb.toString() );
        out.close();
    }
}
