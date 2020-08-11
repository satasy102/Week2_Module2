import java.util.Arrays;

public class Point3D extends Point2D {
    private float z=0;

    Point3D(){}

    Point3D(float x, float y, float z){
        super(x,y);
        this.z=z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z){
        super.setXY(x,y);
        this.z=z;
    }

    public float[] getXYZ(){
        return new float[]{super.getX(), super.getY(), z};
    }

    @Override
    public String toString() {
        return "Point3D(" +
                super.toString()+
                " z=" + z +
                ')';
    }
}

class Point3DTest{
    public static void main(String[] args) {
        Point3D point3DTest= new Point3D();
        System.out.println(point3DTest.toString());

        point3DTest= new Point3D(2,1,3);
        System.out.println(point3DTest.toString());

        point3DTest.setXYZ(2,2,5);
        System.out.println(Arrays.toString(point3DTest.getXYZ()));
    }
}