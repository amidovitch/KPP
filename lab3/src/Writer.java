public class Writer extends Human{

    private Book book;
    private String comment;
    public Writer() {
        super();
        book = null;
        comment = null;
    }

    public Writer(String nameWriter) {
        super(nameWriter);
        book = null;
        comment = null;
    }

    public Book writeBook(int typeBook, int amountPage){
        /*/11111111111111111111111111111111111111111111111111111*/
        return this.book;
    }
    public int readBook(Book book) {
        return book.amountPage;
    }
    public void setComment(String comment){
        this.comment = comment;
    }
}
