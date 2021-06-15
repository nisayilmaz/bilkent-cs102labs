public class Employee extends Person {
    //properties
    final int MAX_JOBS = 5;
    int currentJobs;
    Delivery[] deliveries;
    double salary;
    int employeeNo;
    boolean available;
    
    //constructors
    public Employee(int employeeNo, String name) {
        super(name);
        this.employeeNo = employeeNo;
        currentJobs = 0;
        deliveries = new Delivery[100];
        salary = 0;
        available = true;
    }

    public void adjustSalary(double value) {
        salary = value;
    }

    public boolean getAvailability() {
        if (currentJobs < 5) {
            return available;
        }
        else {
            return false;
        }
    }

    public void addJob(Item sendItem, Customer sender, Customer receiver, int packageNo) {
        int index = 0;
        
        while (index < deliveries.length) {
            if (deliveries[index] == null) {
                if (sendItem.getWeight() <= 0.1) {
                    Mail mail = new Mail(sendItem.getContent(), sender, receiver, packageNo);
                    deliveries[index] = mail;
                    currentJobs++;
                }
                else {
                    Package pack = new Package(sendItem, sender, receiver, packageNo);
                    deliveries[index] = pack;
                    currentJobs++;
                }
                break;
            } else {
                index ++;
            }
        } 
    }

    public void deliverPackages() {
        for (int i = 0; i < deliveries.length; i++) {
            if (deliveries[i] != null) {
                System.out.println("Sender: " + deliveries[i].sender + " receiver: " + deliveries[i].receiver +  deliveries[i].toString());
                deliveries[i] = null;
            }

        }
    }

    public String toString() {
        return "Name: " + name + " salary: " + salary + " employee no: " + employeeNo;
    }
    @Override
    public String getName() {

        return super.getName();
    }
}
