import java.util.ArrayList;
import java.util.List;

public class Writer extends Human{

    private String feedback;

    private List<Book> books;


    public Writer() {
        super();
        this.feedback = null;
        this.books = new ArrayList<Book>();
    }

    public Writer(String nameWriter) {
        super(nameWriter);
        this.feedback = null;
        this.books = new ArrayList<Book>();
    }

    public boolean writeBook(Book book) {
        if (this.books == null || book == null) return false;
        book.setWriter(this);
        return this.books.add(book);
    }

    public List<Book> getBook() {
        return this.books;
    }

    public void setFeedback(String Feedback) {
        this.feedback = Feedback;
    }

}
