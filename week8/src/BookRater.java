import java.util.Comparator;

public class BookRater implements Comparator<Book> {

    public int compare(Book b1, Book b2){
        return b1.getRating().compareTo(b2.getRating());
    }
}
