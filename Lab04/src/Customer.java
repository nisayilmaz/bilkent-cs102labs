public class Customer extends Person {
    //properties
    Item currentItem;

    //constructors
    public Customer(String name) {
        super(name);
        currentItem = new Item(0, "");
        
    }

    public Item getCurrentItem() {
        return currentItem;
    }

    public void setCurrentItem(Item currentItem) {
        this.currentItem = currentItem;
    }

    public boolean sendItem(Company company, Item item, Customer receiver) {
        if (currentItem.getWeight() != 0 ) {
            company.createDeliverable(item, this, receiver, 1);
        }
        else {
            company.createDeliverable(currentItem, this, receiver, 1);
        }
        return true;
    }

    public String toString() {
        return name;
    }
    
}
