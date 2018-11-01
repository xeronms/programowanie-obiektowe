package cipher;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Cryptographer {

    public static void cryptfile(String directory, String file, Algorithm cipher ){

        Path path = FileSystems.getDefault().getPath( directory, file);

        String text = path.toString();

        System.out.print(text);
    }

}
