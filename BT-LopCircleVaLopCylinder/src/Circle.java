public class Circle {
    private String color="red";
    private double radius=1;

    Circle(){
    }

    Circle(double radius,String color){
        this.radius=radius;
        this.color=color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public String toString() {
        return "A Shape with radius="
                + getRadius()
                +", color="
                + getColor();
    }
}

class CircleTest {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);

        circle = new Circle(3.5, "indigo");
        System.out.println(circle);
    }
}
