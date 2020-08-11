public class Rectangle extends Shape {
    private double width=1;
    private double length=1;

    Rectangle(){
    }

    Rectangle(double width, double length){
        this.width=width;
        this.length=length;
    }

    Rectangle(double width, double length, String color, boolean filled){
        super(color, filled);
        this.width=width;
        this.length=length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea(){
        return 2*(getLength()+getWidth());
    }

    public double getPerimeter(){
        return getLength()*getWidth();
    }

    @Override
    public String toString() {
        return "A Rectangle with " +
                "width= " + getWidth() +
                ", length=" + getLength() +
                ", which is a subclass of " + super.toString();
    }
}

class RectangleTest {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle);

        rectangle = new Rectangle(2.3, 5.8);
        System.out.println(rectangle);

        rectangle = new Rectangle(2.5, 3.8, "orange", true);
        System.out.println(rectangle);
    }
}
