public class Book {

    int numberOfPages;

    private Writer writer;

    public Book() {
        this.numberOfPages = 0;
        this.writer = null;
    }

    public Book(int numberOfPages) {
        this.numberOfPages = numberOfPages;
        this.writer = null;
    }

    public int getPages() {
        return this.numberOfPages;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }
    public Writer getWriter() {
           return this.writer;
    }

}
