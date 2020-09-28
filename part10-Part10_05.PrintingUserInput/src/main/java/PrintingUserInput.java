import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class PrintingUserInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputs = new ArrayList<>();
        
        System.out.println("Type something and press enter.");
        System.out.println("Do this as much as you want.");
        System.out.println("When you have had your fill of entering input,");
        System.out.println("press enter without entering input to see all you have typed.");
        
        while (true) {
            String row = scanner.nextLine();
            if (row.equals("")) {
                break;
            }
            
            inputs.add(row);
        }
        
        printInputs(inputs);
    }
    
    public static void printInputs(List<String> inputs) {
        inputs.stream()
            .forEach(s -> System.out.println(s));
    }
}
