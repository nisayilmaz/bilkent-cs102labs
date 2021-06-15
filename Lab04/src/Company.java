import java.util.ArrayList;

public class Company implements Locatable{
    final int EMPLOYEE_CAPACITY = 15;
    Employee[] employees;
    ArrayList<Customer> customers;
    int numOfEmployees;
    int packageNo;
    int employeeNo;
    int posX;
    int posY;
    

    //constructors
    public Company(int x, int y) {
        posX = x;
        posY = y;
        numOfEmployees = 0;
        employees = new Employee[EMPLOYEE_CAPACITY];
        customers = new ArrayList<Customer>();
        
    }
    @Override
    public int getX() {
        return posX;
    }

    @Override
    public int getY() {
        return posY;
    }

    @Override
    public void setPos(int x, int y) {
        posX = x;
        posY = y;
    }

    public boolean addEmployee(Employee candidate) {
        boolean isHired = false;
        int place = 0;
        while (place < employees.length) {
            if (employees[place] == null && numOfEmployees < 15) {
                isHired = true;
                numOfEmployees++;
                employees[place] = candidate;
                break;
            }
            else {
                isHired = false;
                place++;
            }
        }
        
        return isHired;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public boolean terminateContract( int employeeIndex ) {
        boolean isTerminated = false;
        
        if ( employees[employeeIndex] != null ) {
            employees[employeeIndex] = null;
            isTerminated = true;
        } else {
            isTerminated = false;
        }
        
        return isTerminated;
    }
    
    public boolean createDeliverable(Item sendItem, Customer sender, Customer receiver, int packageNo) {
        int i = 0;
        boolean isCreated = false;
        while (i < employees.length) {
            if (employees[i] != null && employees[i].getAvailability()) {
                employees[i].addJob(sendItem, sender, receiver, packageNo);
                isCreated = true;
                break;
            } else {
                isCreated = false;
                i++;
            }
        }
        return isCreated;
    }
    
    public void deliverPackages() {
        for (int i = 0; i < EMPLOYEE_CAPACITY; i++)
        {
            if (employees[i] != null)
            {
                System.out.println( "Employee " + (i + 1));
                employees[i].deliverPackages();
                
            }
        }
    }

    public String toString() {
        String employeesString = "";
        String deliveries = "";
        String allCustomers = "";
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                employeesString += "+" + employees[i].toString() + "\n";  
                for (int j = 0; j < employees[i].deliveries.length; j++) {
                    if (employees[i].deliveries[j] != null) {
                        deliveries += "-" + employees[i].deliveries[j] + "\n";
                    }
                   
                }
        
            }
        }
        for (int k = 0; k < customers.size(); k++) {
            allCustomers += "*" + customers.get(k) + "\n";
        } 
        return "Employees are: \n" + employeesString
                + "Deliveries are: \n" + deliveries
                + "Customers are: \n" + allCustomers ; 
    }
}

