import java.io.Reader;
import java.util.Date;

public class Book {

    public char[] isbn = new char[13];
    public String title;
    public String author;
    public int year;

    public Book(String id, String t, String a, int y){
        isbn = id.toCharArray();
        title = t;
        author = a;
        year = y;
    }
}
