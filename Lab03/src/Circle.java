public class Circle extends Shape2D {
    //properties
    private int radius;

    public Circle(int x, int y, int radius) {
        super(x , y);
        this.radius = radius;

    }

    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    
    @Override
    public String toString() {
        return getClass().getName() + " (" + super.toString() + ", radius: " + getRadius() + ")";
    }

    @Override
    public boolean equals(Object anyShape) {
        boolean b = false;
        if (anyShape instanceof Circle) {
            Circle c = (Circle) anyShape;
            if (super.equals(anyShape) && getRadius() == c.getRadius()) {
                b = true;
            }
            
        }
        return b;
    }
    public int getRadius() {
        return radius;
    }
}
