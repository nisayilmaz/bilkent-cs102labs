public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Item item1 = new Item(20, "book");
        Item item2 = new Item(12, "apples");
        Customer customer1 = new Customer("Furkan");
        Customer customer2 = new Customer("Nisa");
        Employee employee1 = new Employee(1, "emp1");
        Employee employee2 = new Employee(2, "emp2");
        employee1.addJob(item1, customer1, customer2, 1);
        employee1.addJob(item2, customer1, customer2, 2);
        employee1.addJob(item1, customer2, customer1, 3);
        employee1.addJob(item2, customer2, customer1, 4);
        employee1.addJob(item2, customer2, customer1, 5);
        employee1.addJob(item2, customer2, customer1, 6);
        employee1.addJob(item2, customer2, customer1, 7);


        employee1.deliverPackages();
        Company company = new Company(4, 7);

    }
}
