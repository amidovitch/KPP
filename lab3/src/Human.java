public abstract class Human {
    protected String name;

    public Human(){
        this.name = null;
    }

    public Human(String name){
        this.name = name;
    }

    public int readBook(Book book) {
        return book.amountPage;
    }
}
