
public class Writer extends Human{

    private String feedback;
    private Book book;

    public Writer() {
        super();
        this.feedback = null;
        book = new Book();
    }

    public Writer(String nameWriter) {
        super(nameWriter);
        this.feedback = null;
        book = new Book();
    }

    public Book writeBook(int amountPage) {
        this. book = new Book(amountPage);
        this.book.setWriter(this);
        return this.book;
    }

    public Book getBook() {
        return this.book;
    }

    public void setFeedback(String Feedback) {
        this.feedback = Feedback;
    }
}
