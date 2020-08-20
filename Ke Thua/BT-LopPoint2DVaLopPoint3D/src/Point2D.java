import java.util.Arrays;

public class Point2D {
    private float x=0;
    private float y=0;

    Point2D(){}

    Point2D(float x, float y){
        this.x=x;
        this.y=y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setXY(float x, float y){
        this.x=x;
        this.y=y;
    }

    public float[] getXY(){
        return new float[]{x,y};
    }

    @Override
    public String toString() {
        return "Point2D " +
                "x=" + x +
                ", y=" + y ;
    }
}

class Point2DTest{
    public static void main(String[] args) {
        Point2D point2DTest = new Point2D();
        System.out.println(point2DTest.toString());

        point2DTest = new Point2D(2, 1);
        System.out.println(point2DTest.toString());

        System.out.println(Arrays.toString(point2DTest.getXY()));
    }
}
