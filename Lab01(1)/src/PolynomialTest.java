import java.util.Scanner;
/**
 * This is a test class for the Polynomial class where all of its methods are demonstrated.
 * @author Nisa Yılmaz
 * @version 1
 */
public class PolynomialTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Variables
        double[] coef = {3, 4, 1};
        double[] coef2 = {2, 1};
        Polynomial polynomial = new Polynomial(coef);
        Polynomial polynomial2 = new Polynomial(coef2);
   
        /**
        System.out.print("To find the coefficiant of the nth term please enter a n value: ");
        term = scan.nextInt();

        System.out.print("Enter the number x to find the result of the polynımial at x: ");
        x = scan.nextInt();
        

        System.out.println("........................................................");
        System.out.println("P(x) = " + polynomial.toString()); 
        System.out.println("Coefficiant of the " + term + "th term is: " + polynomial.getCoef(term));
        System.out.println("Degree of the polynomial is: " + polynomial.getDegree());
        System.out.println("The sum is " + polynomial.eval(x) + " calculated by replacing x with input value.");
        System.out.println("The sum evaluated by using the Horner's method is " + polynomial.eval2(x));
        */

        System.out.println(polynomial);
        System.out.println(polynomial2);
        System.out.println(polynomial.sub(polynomial2));
        System.out.println(polynomial.add(polynomial2));
        System.out.println(polynomial.div(polynomial2));
        System.out.println(polynomial.compose(polynomial2));
              
        
        scan.close();
    }
}
