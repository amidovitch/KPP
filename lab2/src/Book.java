public class Book {

    private int numberOfPages;

    private Writer writer;

    public Book() {
        this.numberOfPages = 0;
        this.writer = null;
    }

    public Book(int numberOfPages, Writer writer) {
        this.numberOfPages = numberOfPages;
        this.writer = writer;
    }

    public int getPages() {
        return this.numberOfPages;
    }

    public Writer getWriter() {
           return this.writer;
    }

}
