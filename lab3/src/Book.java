public abstract class Book {

    protected int amountPage;

    public Book(){
        amountPage = 0;
    }
    public Book(int amountPage){
        this.amountPage = amountPage;
    }
    public int getAmountPage(){
        return amountPage;
    }
}
