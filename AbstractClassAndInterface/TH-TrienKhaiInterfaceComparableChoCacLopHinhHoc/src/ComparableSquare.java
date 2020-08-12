import java.util.Arrays;

public class ComparableSquare extends Square implements Comparable<ComparableSquare>{

    ComparableSquare(){}

    ComparableSquare(double side){
        super(side);
    }

    ComparableSquare(double side, String color, boolean filled) {
        super(side,"black",true);
    }


    @Override
    public int compareTo(ComparableSquare o) {
        if (super.getArea() > o.getArea()) return 1;
        else if (super.getArea() < o.getArea()) return -1;
        else return 0;
    }
}

class ComparableSquareTest {
    public static void main(String[] args) {
        ComparableSquare[] squares = new ComparableSquare[3];
        squares[0] = new ComparableSquare(7.2);
        squares[1] = new ComparableSquare();
        squares[2] = new ComparableSquare(6.3, "indigo", false);

        System.out.println("Pre-sorted:");
        for (ComparableSquare square : squares) {
            System.out.println(square);
        }

        Arrays.sort(squares);

        System.out.println("After-sorted:");
        for (ComparableSquare square : squares) {
            System.out.println(square);
        }
    }
}
