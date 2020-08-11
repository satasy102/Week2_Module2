public class Shape {
    private String color = "green";

    Shape() {
    }

    Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return " color = " + getColor();
    }

}

class ShapeTest {
    public static void main(String[] args) {
        Shape shape = new Shape();
        System.out.println(shape);

        shape = new Shape("red");
        System.out.println(shape);
    }
}

