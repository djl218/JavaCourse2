import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        int first = 0;
        int second = 0;
        Scanner scan = new Scanner(System.in);


        while (true) {
            System.out.println("First: " + first + "/100");
            System.out.println("Second: " + second + "/100");

            String input = scan.nextLine();
            System.out.println("");
            if (input.equals("quit")) {
                break;
            }
                
            String[] parts = input.split(" ");
            String command = parts[0];
            int amount = Integer.valueOf(parts[1]);
            
            if (command.equals("add") && amount > 0) {
                first = first + amount;
                if (first > 100) {
                    first = 100;
                }
            } else if (command.equals("move") && amount > 0) {
                if (amount > first) {
                    second = second + first;
                } else {
                    second = second + amount;
                }
                
                first = first - amount;
                
                if (first < 0) {
                    first = 0;
                }
                if (second > 100) {
                    second = 100;
                }
            } else if (command.equals("remove") && amount > 0) {
                second = second - amount;
                if (second < 0) {
                    second = 0;
                }
            }
        }
    }
}
