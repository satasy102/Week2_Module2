public class Rectangle extends Shape{
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
                ", length= " + getLength() +
                ", area= " + getArea();
    }

}

class RectangleTest {
    public static void main(String[] args) {
        Rectangle r1= new Rectangle();
        Rectangle r2= new Rectangle(4.5,6.2);

        System.out.println(r1);
        System.out.println(r2);

    }

}
