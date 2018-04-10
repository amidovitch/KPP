public class Reader extends Human {

    public Reader() {
        super();
    }

    public Reader(String nameReader) {
        super(nameReader);
    }

    public int readBook(Book book) {
        return book.amountPage;
    }

    protected void giveFeedback(Writer writer, String comment) {
        writer.setComment(comment);

    }
}
