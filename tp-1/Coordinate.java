public class Coordinate {
    
    private double x;
    private double y;

    public Coordinate(){
        this.x = 0;
        this.y = 0;
    }

    public Coordinate(double x, double y){
        this.x = x;
        this.y = y;
    }

    public Coordinate(Coordinate coordonnees){
        this.x = coordonnees.x;
        this.y = coordonnees.y;
    }

    public String toString(){
        return "( " + this.x + " ; " + this.y + " )";
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public void set(double x, double y){
        this.x = x;
        this.y = y;
    }

}
