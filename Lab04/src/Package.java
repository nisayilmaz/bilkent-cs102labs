public class Package extends Delivery {
    //properties
    Item packedItem;

    //constructors
    public Package(Item content, Customer sender, Customer receiver, int packageNo) {
        super(sender, receiver, packageNo);
        packedItem = content;

    }

    //methods
    public double getWeight() {
        return packedItem.getWeight();
    }
    public String toString() {
        return " weight: " + getWeight() + packedItem.toString();
    }
}
