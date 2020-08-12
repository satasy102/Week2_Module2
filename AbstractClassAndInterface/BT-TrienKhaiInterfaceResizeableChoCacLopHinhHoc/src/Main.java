public class Main {
    public static void main(String[] args) {
        Shape[] shapes=new Shape[3];
        shapes[0]=new Circle(1.5);
        shapes[1]=new Rectangle(1.7,2.5);
        shapes[2]=new Square(2.2);

        Circle c=(Circle)shapes[0];
        Rectangle r=(Rectangle)shapes[1];
        Square s=(Square)shapes[2];

        System.out.println("Chua resize:");
        System.out.println(c);
        System.out.println(r);
        System.out.println(s);

        double persent= Math.random()*99+1;

        System.out.println("Da resize:"+persent+"%");
        c.resize(persent);
        r.resize(persent);
        s.resize(persent);

    }
}
