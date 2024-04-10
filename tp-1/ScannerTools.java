import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerTools {

    private Scanner scanner;

    public ScannerTools(){
        this.scanner = new Scanner(System.in);
    }

    public int nextInt(){
        Integer integer = null;
        while(integer == null){
            try{
                integer = this.scanner.nextInt();
            }catch(InputMismatchException e){
                System.out.println("Vous avez entrer une valeur qui n'est pas un entier");
                System.out.println("Veuillez entrer un entier : ");
                this.scanner.nextLine();
                integer = null;
            }
        }
        return integer;
    }

    public String nextLine(){
        return this.scanner.nextLine();
    }

    public double nextDouble(){
        Double doubleValue = null;
        while(doubleValue == null){
            try{
                doubleValue = this.scanner.nextDouble();
            }catch(InputMismatchException e){
                System.out.println("Vous avez entrer une valeur qui n'est pas un double");
                System.out.println("Veuillez entrer un double : ");
                this.scanner.nextLine();
                doubleValue = null;
            }
        }
        return doubleValue;
    }
    
}
