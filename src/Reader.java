import java.util.ArrayList;
import java.util.List;

public class Reader extends Human {

    private List<Book> books;
    private Writer writer;

    public Reader() {
        super();
        writer = null;
        this.books = new ArrayList<Book>();
    }

    public Reader(String nameReader) {
        super(nameReader);
        writer = null;
        this.books = new ArrayList<Book>();
    }

    public void readBook(Book book, String feedback) {
        this.writer = book.getWriter();
        this.books.add(book);
        this.giveFeedback(feedback);
    }

    public void giveFeedback(String Feedback) {
        writer.setFeedback(Feedback);
    }
    public Writer getWriter() {
        return writer;
    }
}
