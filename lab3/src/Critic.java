public class Critic extends Reader {

    private Review review;

    public Critic(){
        super();
        this.review = null;
    }

    public Critic(String nameCritic){
        super(nameCritic);
        this.review = null;
    }

    public Review writeReview(int amountPage){
        this.review = new Review(amountPage);
        return this.review;
    }
}
