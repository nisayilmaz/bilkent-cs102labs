public class Mail extends Delivery {
    //properties
    String content;

    //constructors
    public Mail(String content, Customer sender, Customer receiver, int packageNo) {
        super(sender, receiver, packageNo);
        this.content = content;
    }

    //methods
    public double getWeight() {
        return 0.1;
    }

    public String toString() {
        return " weight: " + getWeight() + " content: " + content;
    }
    
}
