public class TestShape2D {
    public static void main(String[] args) {
    
        Shape2D arr[] = new Shape2D[3];
        arr[0] = new Rectangle(2, 3, 8, 15);
        arr[1] = new Circle(13, 15, 3);
        arr[2] = new Square(-2, -5, 5);

        Square sq1 = new Square(-2, -5, 5);
        Square sq2 = new Square(-2, -5, 5);
        Square sq3= new Square(-1, -5, 5);
        Square sq4 = null;
        Circle circle = new Circle(-2, -5, 5);
        
        System.out.println("Currently we have:");
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i].toString());
        }
        System.out.println("Shape with the largest area is " + findLargestArea(arr).toString());
        System.out.println("Shape with the longest perimeter is " + findLongestPerimeter(arr).toString());

        System.out.println(sq1.equals(sq2));
        System.out.println(sq1.equals(sq3));
        System.out.println(sq1.equals(sq4));
        System.out.println(sq1.equals(circle));

        System.out.println("The distance between shape 1 and shape 2 is :" + arr[0].calculateDistance(arr[1]));
        System.out.println("The distance between shape 1 and shape 3 is :" + arr[0].calculateDistance(arr[2]));
        System.out.println("The distance between shape 2 and shape 3 is :" + arr[1].calculateDistance(arr[2]));




    }
    public static Shape2D findLargestArea(Shape2D[] arr) {
        double maxArea = 0;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].calculateArea() > maxArea) {
                maxArea = arr[i].calculateArea();
                index = i;
            }
        }
        return arr[index];
    }

    public static Shape2D findLongestPerimeter(Shape2D[] arr) {
        double maxPerimeter = 0;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].calculatePerimeter() > maxPerimeter) {
                maxPerimeter = arr[i].calculatePerimeter();
                index = i;
            }
        }
        return arr[index];

    }
}


