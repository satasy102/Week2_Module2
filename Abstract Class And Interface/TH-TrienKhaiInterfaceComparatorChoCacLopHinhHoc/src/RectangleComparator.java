import java.util.Comparator;
import java.util.Arrays;

public class RectangleComparator implements Comparator<Rectangle> {
    @Override
    public int compare(Rectangle r1, Rectangle r2) {
        if (r1.getArea() > r2.getArea()) return 1;
        else if (r1.getArea() < r2.getArea()) return -1;
        else return 0;
    }
}

class RectangleComparatorTest {
    public static void main(String[] args) {
        Rectangle[] rectangles = new Rectangle[3];
        rectangles[0] = new Rectangle(7.2,3.5);
        rectangles[1] = new Rectangle();
        rectangles[2] = new Rectangle(6.3,5.2, "indigo", false);

        System.out.println("Pre-sorted:");
        for (Rectangle rectangle : rectangles) {
            System.out.println(rectangle);
        }

        RectangleComparator rectangleComparator=new RectangleComparator();
        Arrays.sort(rectangles,rectangleComparator);

        System.out.println("After-sorted:");
        for (Rectangle rectangle : rectangles) {
            System.out.println(rectangle);
        }
    }
}
