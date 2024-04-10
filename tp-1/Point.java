public class Point extends Coordinate {

    public Point(){
        super();
    }

    public Point(double x, double y){
        super(x, y);
    }

    public Point(Point source){
        super(source.getX(), source.getY());
    }

    public void move(Vector vector){
        this.set(this.getX() + vector.getX(), this.getY() + vector.getY());        
    }
    
}
