import java.util.Random;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random ladyLuck = new Random();
        
        System.out.println("How many random numbers should be printed?");
        Integer number = scanner.nextInt();
        
        for (int i = 0; i < number; i++) {
            int randomNumber = ladyLuck.nextInt(11);
            System.out.println(randomNumber);
        }
    }

}