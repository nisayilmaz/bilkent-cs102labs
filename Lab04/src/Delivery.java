public abstract class Delivery {
    //properties
    int packageNo;
    Customer sender;
    Customer receiver;
    
    //constructors
    Delivery(Customer sender, Customer receiver, int packageNo) {
        this.sender = new Customer("");
        this.sender = sender;
        this.receiver = new Customer("");
        this.receiver = receiver;
        this.packageNo = packageNo;
    }

    public int getPackageNo() {
        return packageNo;
    }

    public Customer getSender() {
        return sender;
    }

    public Customer getreceiver() {
        return receiver;
    }

    public abstract double getWeight();
}
