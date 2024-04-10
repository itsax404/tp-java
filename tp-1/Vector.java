public class Vector extends Coordinate {
    
    public Vector(){
        super();
    }

    public Vector(double x, double y){
        super(x, y);
    }

    public Vector(Point source){
        super(source.getX(), source.getY());
    }

}
