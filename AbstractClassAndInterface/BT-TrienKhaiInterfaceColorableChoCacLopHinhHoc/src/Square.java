public class Square extends Rectangle implements Colorable {
    Square(){
    }

    Square(double side){
        super(side,side);
    }

    Square(double side, String color, boolean filled){
        super(side,side,color,filled);
    }

    public double getSide() {
        return super.getWidth();
    }

    public void setSide(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    @Override
    public void setLength(double side) {
        super.setLength(side);
    }

    @Override
    public void setWidth(double side) {
        super.setWidth(side);
    }

    @Override
    public String toString() {
        return "A Square with side= "
                + getSide()
                + ", area "
                + getArea();
    }

    @Override
    public void howToColor(){
        System.out.println("Color all four sides of Square.");
    }
}

class SquareTest {
    public static void main(String[] args) {
        Square square1 = new Square();

        Square square2 = new Square(2.3);

        System.out.println("Truoc khi to mau: ");
        System.out.println(square1);
        System.out.println(square2);

        System.out.println("Sau khi to mau:");
        square1.howToColor();
        square2.howToColor();

    }
}
