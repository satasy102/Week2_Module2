public class MovablePoint extends Point {
    private float xSpeed=0;
    private float ySpeed=0;

    public MovablePoint(){}

    public MovablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed){
        this.xSpeed=xSpeed;
        this.ySpeed=ySpeed;
    }

    public float[] getSpeed(){
        return new float[] {xSpeed,ySpeed};
    }

    @Override
    public String toString() {
        return "(" + super.getX() + "," + super.getY()+"),"+
                "Speed = (" + xSpeed +","+ ySpeed +")";
    }

    public MovablePoint move(){
        super.setX(super.getX() + xSpeed);
        super.setY(super.getY() + ySpeed);
        return this;
    }
}

class MovablePointTest{
    public static void main(String[] args) {
        MovablePoint mp=new MovablePoint(2,4,1,3);
        System.out.println(mp.toString());
        mp.move();
        System.out.println("move" + mp.toString());
    }
}