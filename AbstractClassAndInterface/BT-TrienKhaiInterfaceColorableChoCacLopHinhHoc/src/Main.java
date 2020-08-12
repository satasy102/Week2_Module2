public class Main {
    public static void main(String[] args) {
        Shape[] shapes=new Shape[3];
        shapes[0]=new Circle(1.5);
        shapes[1]=new Rectangle(1.7,2.5);
        shapes[2]=new Square(2.2);

        for (Shape shape : shapes) {
            if (shape instanceof Circle) {
                Circle c = (Circle) shape;
                System.out.println("Dien tich hinh tron= " + c.getArea());
            }
            if (shape instanceof Rectangle && !(shape instanceof Square)) {
                Rectangle r = (Rectangle) shape;
                System.out.println("Dien tich hinh chu nhat= " + r.getArea());
            }
            if (shape instanceof Square) {
                Square s = (Square) shape;
                System.out.println("Dien tich hinh vuong= " + s.getArea());
                s.howToColor();
            }
        }
    }
}
