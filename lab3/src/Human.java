public abstract class Human {
    protected String name;

    public Human(){
        this.name = null;
    }

    public Human(String name){
        this.name = name;
    }

    public abstract int readBook(Book book);
}
