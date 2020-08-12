public class ComparableSquare extends ComparableRectangle{

    ComparableSquare(){}

    ComparableSquare(double side){
        super(side, side);
    }

    ComparableSquare(double side, String color, boolean filled) {
        super(side,side,"black",true);
    }

    @Override
    public int compareTo(ComparableRectangle o) {
        return super.compareTo(o);
    }
}
