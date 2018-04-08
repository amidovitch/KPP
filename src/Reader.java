
public class Reader extends Human {


    public Reader() {
        super();
    }

    public Reader(String nameReader) {
        super(nameReader);
    }

    public void readBook(Book book, String feedback) {
        this.giveFeedback(feedback, book);
    }

    public void giveFeedback(String Feedback, Book book) {
        book.getWriter().setFeedback(Feedback);
    }
}
