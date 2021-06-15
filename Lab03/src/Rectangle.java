public class Rectangle extends Shape2D {
    private int height;
    private int width;

    public Rectangle(int x, int y, int height, int width) {
        super(x, y);
        this.height = height;
        this.width = width;
    }

    public double calculatePerimeter() {
        return 2 * (height + width);
    }

    public double calculateArea() {
        return height * width;
    }

    @Override
    public String toString() {
        return getClass().getName() + " (" + super.toString() + ", width: " + getWidth() + ", height: " + getHeight() + ")";
    }

    @Override
    public boolean equals(Object anyShape) {
        boolean b = false;
        if (anyShape instanceof Rectangle) {
            Rectangle c = (Rectangle) anyShape;
            if (super.equals(anyShape) && getHeight() == c.getHeight() && getWidth() == c.getWidth()) {
                b = true;
            }
            
        }
        return b;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


    
}
