import java.util.ArrayList;

public class CompanyTester {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        Item apples = new Item(3, "Apples");
        Item feathers = new Item(0.05, "Feathers");
        Item bananas = new Item(1, "Bananas");
        Item oranges = new Item(6, "Oranges");
        Company company = new Company(10, 20);
        Customer cust1, cust2, cust3, cust4;
        
        cust1 = new Customer("Nisa");
        cust2 = new Customer("Dila");
        cust3 = new Customer("Ayten");
        cust4 = new Customer("Birol");
        
        Employee emp1, emp2;
        
        emp1 = new Employee(1, "Emp1");
        emp2 = new Employee(2, "Emp2");
        company.addCustomer(cust1);
        company.addCustomer(cust2);
        company.addCustomer(cust3);
        company.addCustomer(cust4);
        
        company.addEmployee(emp1);
        company.addEmployee(emp2);
        employees.add(emp1);
        employees.add(emp2);
        emp1.adjustSalary(2000);
        emp2.adjustSalary(3000);
        cust1.setCurrentItem(apples);
        cust1.sendItem(company, apples, cust2);
        cust2.setCurrentItem(bananas);
        cust2.sendItem(company, bananas, cust3);
        cust3.setCurrentItem(feathers);
        cust3.sendItem(company, feathers, cust2);
        cust4.setCurrentItem(oranges);
        cust4.sendItem(company, oranges, cust2);
        cust4.setCurrentItem(oranges);
        cust4.sendItem(company, oranges, cust2);


        
        System.out.println("---------------------------------------");
        System.out.println("Availability of the employees are:");
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getAvailability()) {
                System.out.println(employees.get(i).getName() + " is available");
            }
            else {
                System.out.println(employees.get(i).getName() + " is not available");
            }
        }

        
        System.out.println("--------------------------------------- \nAbout the company");
        System.out.println(company.toString());

        company.deliverPackages();
       
    }
}
