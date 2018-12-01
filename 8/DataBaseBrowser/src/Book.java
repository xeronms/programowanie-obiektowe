import java.io.Reader;
import java.util.Date;

public class Book {

    private char[] isbn = new char[13];
    private String title;
    private String author;
    private int year;

    public Book(String id, String t, String a, int y){
        isbn = id.toCharArray();
        title = t;
        author = a;
        year = y;
    }

    public char[] getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }
}
