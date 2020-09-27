import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputs = new ArrayList<>();

        System.out.println("Input numbers, type \"end\" to stop.");
        
        while (true) {
            String row = scanner.nextLine();
            if (row.equals("end")) {
                break;
            }
            
            inputs.add(row);
        }
        
        List<Integer> numbers = new ArrayList<>();
        int newInt = 0;
        
        for (String input : inputs) {
            newInt = Integer.valueOf(input);
            numbers.add(newInt);
        }
        
        List<Integer> onlyPositive = positive(numbers);
        for (int number : onlyPositive) {
            System.out.println(number);
        }        
    }
    
    public static List<Integer> positive(List<Integer> numbers) {
        ArrayList<Integer> values = numbers.stream()
            .filter(s -> s > 0)
            .collect(Collectors.toCollection(ArrayList::new));
        
        return values;
    }

}
