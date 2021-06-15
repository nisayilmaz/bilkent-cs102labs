public class Square extends Shape2D{
    
    private int sideLength;

    public Square(int x, int y, int sideLength) {
        super(x, y);
        this.sideLength = sideLength;
    }

    public double calculateArea() {
        return sideLength * sideLength;
    }

    public double calculatePerimeter() {
        return sideLength * 4;
    }

    @Override
    public String toString() {
        return getClass().getName() + " (" + super.toString() + ", side lenght: " + getSideLength() + ")";
    }

    @Override
    public boolean equals(Object anyShape) {
        boolean b = false;
        if (anyShape instanceof Square) {
            Square c = (Square) anyShape;
            if (super.equals(anyShape) && getSideLength() == c.getSideLength()) {
                b = true;
            }
            
        }
        return b;
    }

    public int getSideLength() {
        return sideLength;
    }

}
