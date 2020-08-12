import java.util.Comparator;
import java.util.Arrays;

public class SquareComparator implements Comparator<Square> {
    @Override
    public int compare(Square s1, Square s2) {
        if (s1.getArea() > s2.getArea()) return 1;
        else if (s1.getArea() < s2.getArea()) return -1;
        else return 0;
    }
}

class SquareComparatorTest {
    public static void main(String[] args) {
        Square[] squares = new Square[3];
        squares[0] = new Square(7.2);
        squares[1] = new Square();
        squares[2] = new Square(6.3, "indigo", false);

        System.out.println("Pre-sorted:");
        for (Square square : squares) {
            System.out.println(square);
        }

        SquareComparator rectangleComparator=new SquareComparator();
        Arrays.sort(squares,rectangleComparator);

        System.out.println("After-sorted:");
        for (Square square : squares) {
            System.out.println(square);
        }
    }
}
