import java.util.Scanner;

public class Application{

    public static void main(String[] args){
        // System.out.println("On fait du Java à Polytech Dijon !");
        // Coordinate coords = new Coordinate(1, 9);
        // Point point = new Point(1, 9);
        // System.out.println(point);
        // Vector vector = new Vector(1, 1);
        // point.move(vector);
        // System.out.println(point);

        ScannerTools entree = new ScannerTools(); 
        print("Veuillez saisir une chaîne de caractères : ");
        String stringEntree = entree.nextLine();
        print("Veuillez saisir un entier : ");
        int integerEntree = entree.nextInt();
        print("Veuillez saisir un double : ");
        double doubleEntree = entree.nextDouble();

        print("La chaine de caractère entréé : " + stringEntree);
        print("L'entier entrée : " + integerEntree);
        print("le double entrée : " + doubleEntree);
    }

    private static void print(String message){
        System.out.println(message);
    }

}