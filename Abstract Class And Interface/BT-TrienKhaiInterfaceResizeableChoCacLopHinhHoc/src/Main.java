public class Main {
    public static void main(String[] args) {
        Shape[] shapes=new Shape[3];
        shapes[0]=new Circle(1.5);
        shapes[1]=new Rectangle(1.7,2.5);
        shapes[2]=new Square(2.2);

        System.out.println("Chua resize:");
        for (Shape shape : shapes) {
            if (shape instanceof Circle) {
                Circle c = (Circle) shape;
                System.out.println(c);
            }
            if (shape instanceof Rectangle) {
                Rectangle r = (Rectangle) shape;
                System.out.println(r);
            }

        }

        double persent= Math.random()*99+1;

        System.out.println("Da resize:"+persent+"%");

        for (Shape shape : shapes) {
            if (shape instanceof Circle) {
                Circle c = (Circle) shape;
                c.resize(persent);
            }
            if (shape instanceof Rectangle) {
                Rectangle r = (Rectangle) shape;
                r.resize(persent);
            }
        }

    }
}
