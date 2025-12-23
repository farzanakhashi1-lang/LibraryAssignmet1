package Library1;

public class Rectangle1 {

    // Fields
    private double width;
    private double height;
    private int id;
    private static int idGen = 1;

    // Default constructor
    public Rectangle1() {
        this.width = 1.0;
        this.height = 1.0;
        this.id = idGen++;
    }

    // Constructor with parameters
    public Rectangle1(double width, double height) {
        this(); // call default constructor
        setWidth(width);
        setHeight(height);
    }

    // Getter and Setter for width
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width must be greater than 0");
        }
        this.width = width;
    }


    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be greater than 0");
        }
        this.height = height;
    }


    public double area() {
        return width * height;
    }


    public double perimeter() {
        return 2 * (width + height);
    }


    @Override
    public String toString() {
        return "Rectangle1{" +
                "id=" + id +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
