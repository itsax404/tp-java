import java.util.ArrayList;
import java.util.Scanner;

public class Application{

    public static void main(String[] args){
        /* 
        System.out.println("On fait du Java à Polytech Dijon !");
        Coordinate coords = new Coordinate(1, 9);
        Point point = new Point(1, 9);
        System.out.println(point);
        Vector vector = new Vector(1, 1);
        point.move(vector);
        System.out.println(point);
        */

        /* 
        ScannerTools entree = new ScannerTools(); 
        print("Veuillez saisir une chaîne de caractères : ");
        */

        /*
        String stringEntree = entree.nextLine();
        print("Veuillez saisir un entier : ");
        int integerEntree = entree.nextInt();
        print("Veuillez saisir un double : ");
        double doubleEntree = entree.nextDouble();

        print("La chaine de caractère entréé : " + stringEntree);
        print("L'entier entrée : " + integerEntree);
        print("le double entrée : " + doubleEntree);
         */

        ScannerTools entree = new ScannerTools(); 
        print("Veuillez saisir le nombre de points que vous voulez crée : ");
        int nbPoints = entree.nextInt();
        ArrayList<Point> points = new ArrayList<>();

        for(int i = 0; i < nbPoints; i++ ){
            print("Veuillez entrer la composante x du point "+(i+1) + " :");
            double x = entree.nextDouble();
            print("Veuillez entrer la composante y du point "+(i+1) + " :");
            double y = entree.nextDouble();

            points.add(new Point(x, y));
        }
        
        print((points.size()) + " points entrées : ");
        for(int i = 0; i < points.size(); i++){
            print("Point " + (i+1) + " : " + points.get(i));
        }

    }

    private static void print(String message){
        System.out.println(message);
    }

}