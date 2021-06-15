abstract class Shape2D {
    //properties
    private int x;
    private int y;

    public Shape2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract double calculatePerimeter();

    public abstract double calculateArea();

    public double calculateDistance(Object anyShape) {
        if (anyShape instanceof Shape2D) {
            Shape2D anyShape2 = (Shape2D) anyShape;
            double x = Math.pow((this.getX() - anyShape2.getX()), 2);
            double y = Math.pow((this.getY() - anyShape2.getY()), 2);
            double distance = Math.sqrt(x + y);
            return distance;
        }
        else {
            return -1;
        }
    }

    public String toString() {
        String coordinates = "x: " + x + " , " + "y: " +  y;
        return coordinates;

    }
    @Override
    public boolean equals(Object o) {
        boolean b = false;
        if (o instanceof Shape2D) {
            Shape2D shape = (Shape2D) o;
            if (shape.getX() == getX() && shape.getY() == getY()) {
                b = true;
            }
            else
            b = false;
        }
        return b;
        
    }

    public int getX () {
        return x;
    }

    public int getY() {
        return y;
    }

}