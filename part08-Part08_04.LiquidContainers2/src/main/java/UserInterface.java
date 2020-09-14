import java.util.Scanner;

public class UserInterface {
    private Container first;
    private Container second;
    private Scanner scan;
    
    public UserInterface(Container first, Container second, Scanner scan) {
        this.first = first;
        this.second = second;
        this.scan = scan;
    }
    
    public void start() {
        while (true) {
            System.out.println("First: " + first);
            System.out.println("Second: " + second);
            String input = scan.nextLine();
            System.out.println("");
            if (input.equals("quit")) {
                break;
            }
            
            String[] parts = input.split(" ");
            String command = parts[0];
            int amount = Integer.valueOf(parts[1]);
            
            if (command.equals("add")) {
                first.add(amount);
            }
            
            if (command.equals("move")) {
                int firstValue = first.contains();
                if (firstValue - amount <= 0) {
                    second.add(firstValue);
                } else {
                    first.remove(amount);
                    second.add(amount);
                }
            }
            
            if (command.equals("remove")) {
                second.remove(amount);
            }
        }
    }
}
