import java.util.Arrays;

public class ComparableRectangle extends Rectangle implements Comparable<ComparableRectangle> {

    public ComparableRectangle() {
    }

    public ComparableRectangle(double width, double length){
        super(width,length);
    }

    public ComparableRectangle(double width, double length, String color, boolean filled){
        super(width,length,color,filled);

    }

    @Override
    public int compareTo(ComparableRectangle o) {
        if (super.getArea() > o.getArea()) return 1;
        else if (super.getArea() < o.getArea()) return -1;
        else return 0;
    }
}

class ComparableRectangleTest {
    public static void main(String[] args) {
        ComparableRectangle[] rectangles = new ComparableRectangle[3];
        rectangles[0] = new ComparableRectangle(7.2,3.5);
        rectangles[1] = new ComparableRectangle();
        rectangles[2] = new ComparableRectangle(6.3,5.2, "indigo", false);

        System.out.println("Pre-sorted:");
        for (ComparableRectangle rectangle : rectangles) {
            System.out.println(rectangle);
        }

        Arrays.sort(rectangles);

        System.out.println("After-sorted:");
        for (ComparableRectangle rectangle : rectangles) {
            System.out.println(rectangle);
        }
    }
}
