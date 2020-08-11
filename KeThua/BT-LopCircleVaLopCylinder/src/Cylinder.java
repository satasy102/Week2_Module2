public class Cylinder extends Circle {
    private double height=1;

    Cylinder(){
    }

    Cylinder(double height, double radius, String color){
        super(radius, color);
        this.height=height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        return super.getArea()*2+super.getPerimeter()*height;
    }

    public double getVolume(){
        return  super.getArea()*height;
    }

    @Override
    public String toString() {
        return "A Cylinder with height= "
                + getHeight() +
                ", which is a subclass of "
                + super.toString();
    }
}

class CylinderTest {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder();
        System.out.println(cylinder);

        cylinder = new Cylinder(3,3.5, "indigo");
        System.out.println(cylinder);

        System.out.println("Area of Cylinder: "+cylinder.getArea());
        System.out.println("Volume of Cylinder: "+cylinder.getVolume());
    }
}
