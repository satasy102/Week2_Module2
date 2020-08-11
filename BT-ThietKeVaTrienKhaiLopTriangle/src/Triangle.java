import java.util.Scanner;

public class Triangle extends Shape {
    private double side1 = 1;
    private double side2 = 1;
    private double side3 = 1;

    public Triangle() {
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public Triangle(String color, double side1, double side2, double side3) {
        super(color);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    public double getArea() {
        return Math.sqrt(this.getPerimeter() *
                (this.getPerimeter() - side1) * (this.getPerimeter() - side2) * (this.getPerimeter() - side3));
    }

    @Override
    public String toString() {
        return "Triangle with" +
                "side1= " + getSide1() +
                ", side2= " + getSide2() +
                ", side3= " + getSide3() +
                ", Area= " + getArea() +
                ", Perimeter= " + getPerimeter() +
                super.toString();
    }
}

class TriangleTest {
    public static void main(String[] args) {
        double side1= 0;
        double side2= 0;
        double side3= 0;

        Scanner sc=new Scanner(System.in);

        while (side1+side2<=side3||side1+side3<=side2||side2+side3<=side1){
            System.out.println("Do dai ban nhap khong phai la cua 1 tam giac. Moi nhap lai: ");
            System.out.println("Nhap do  dai side1: ");
            side1= 0;
            side1=checkNumber(side1);
            System.out.println("Nhap do  dai side2: ");
            side2= 0;
            side2=checkNumber(side2);
            System.out.println("Nhap do  dai side3: ");
            side3= 0;
            side3=checkNumber(side3);
        }

        System.out.println("Nhap mau sac cho tam giac");
        String color=sc.nextLine();

        Triangle triangle = new Triangle(color,side1,side2,side3);
        System.out.println(triangle.toString());


    }

    public static double checkNumber(double n){
        Scanner sc=new Scanner(System.in);
        String str=null;
        while (true){
            try{
                str=sc.nextLine();
                n=Double.parseDouble(str);
                break;
            }
            catch (Exception ex){
                System.out.println("Khong phai dang so. Moi nhap lai:");
            }
        }
        return n;
    }

}
