import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private TodoList list;
    private Scanner scanner;
    
    public UserInterface(TodoList list, Scanner scanner) {
        this.list = list;
        this.scanner = scanner;
    }
    
    public void start() {
        while (true) {
            System.out.print("Command: ");
            String input = scanner.nextLine();
            
            if (input.equals("stop")) {
                break;
            } else if (input.equals("add")) {
                System.out.print("To add: ");
                input = scanner.nextLine();
                this.list.add(input);
            } else if (input.equals("list")) {
                this.list.print();
            } else if (input.equals("remove")) {
                System.out.print("Which one is removed? ");
                input = scanner.nextLine();
                int number = Integer.valueOf(input);
                this.list.remove(number);
            }
        }
    }
}
