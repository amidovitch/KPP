
public class Reader extends Human {


    public Reader() {
        super();
    }

    public Reader(String nameReader) {
        super(nameReader);
    }

    public void readBook(Book book, String feedback) {
        this.giveFeedback(feedback, book.getWriter());
    }

    public void giveFeedback(String feedback, Writer writer) {
        writer.setFeedback(feedback);
    }
}
