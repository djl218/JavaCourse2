import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LimitedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputs = new ArrayList<>();
        
        System.out.println("Please enter some numbers.");
        System.out.println("Enter a negative number to have values bewteen 1 and 5 printed back.");

        while (true) {
            String row = scanner.nextLine();
            if (Integer.valueOf(row) < 0) {
                break;
            }
            
            inputs.add(row);
        }
        
        onlyOneToFive(inputs);
    }
    
    public static void onlyOneToFive(List<String> inputs) {
        inputs.stream()
            .mapToInt(s -> Integer.valueOf(s))
            .filter(s -> s > 0 && s < 6)
            .forEach(s -> System.out.println(s));
    }
}
