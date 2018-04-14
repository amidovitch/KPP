public class Writer extends Human{

    private Book book[] = {null, null};
    private String comment;
    public Writer() {
        super();
        comment = null;
    }

    public Writer(String nameWriter) {
        super(nameWriter);
        comment = null;
    }

    public Book writeBook(int amountPage, String genreBook){
        if(genreBook.equals("Роман")) {
            this.book[0] = new Novel(amountPage);
            return this.book[0];
        }
        else
            if (genreBook.equals( "Рассказ")) {
                this.book[1] = new Tale(amountPage);
                return this.book[1];
            }
            return null;
    }

    public String setComment(String comment){
        this.comment = comment;
        return "Спасибо за отзыв, бро";
    }
}
