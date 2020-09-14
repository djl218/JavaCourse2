import java.util.Scanner;

public class AverageOfPositiveNumbers {

    public static void main(String[] args) {
        int sum = 0;
        int count = 0;
        double average = 0;
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            int input = Integer.valueOf(scanner.nextLine());
        
            if (input == 0) {
                if (count == 0) {
                    System.out.println("Cannot calculate the average");
                    break;
                }
                System.out.println(average);
                break;
            }
            
            if (input > 0) {
                count++;
                sum = sum + input;
                average = (double) sum / count;
            }
        }
    }
}
