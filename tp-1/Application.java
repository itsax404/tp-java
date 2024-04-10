public class Application{

    public static void main(String[] args){
        // System.out.println("On fait du Java à Polytech Dijon !");
        // Coordinate coords = new Coordinate(1, 9);
        Point point = new Point(1, 9);
        System.out.println(point);
        Vector vector = new Vector(1, 1);
        point.move(vector);
        System.out.println(point);
    }

}