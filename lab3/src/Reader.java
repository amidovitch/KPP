public class Reader extends Human {

    public Reader() {
        super();
    }

    public Reader(String nameReader) {
        super(nameReader);
    }

    protected String giveFeedback(Writer writer, String comment) {
        return writer.setComment(comment);
    }
}
