public class Circle extends Shape implements Resizeable{
    private double radius=1;

    Circle(){
    }

    Circle(double radius){
        this.radius=radius;
    }

    Circle(double radius, String color, boolean filled){
        super(color, filled);
        this.radius=radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
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
        return "A Circle with" +
                " radius= " + getRadius() +
                ", area= " + getArea();
    }

    @Override
    public void resize(double percent) {
        radius = radius+ radius*percent/100;
        System.out.println( "A Circle with " +
                "Radius= "+getRadius()+ ", Area= " + getArea());
    }
}

class CircleTest {
    public static void main(String[] args) {
        Circle circle1 = new Circle();

        Circle circle2  = new Circle(3.1);

        System.out.println("Truoc khi resize:");
        System.out.println(circle1);
        System.out.println(circle2);


        System.out.println("Sau khi resize:");
        circle1.resize(15);
        circle2.resize(15);
    }
}