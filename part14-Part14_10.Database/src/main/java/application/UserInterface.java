package application;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.List;

public class UserInterface {

    private Scanner scanner;
    private TodoDao database;

    public UserInterface(Scanner scanner, TodoDao database) {
        this.scanner = scanner;
        this.database = database;
    }

    public void start() throws SQLException {
        while (true) {
            System.out.println("");
            System.out.println("Enter command:");
            System.out.println("1) list");
            System.out.println("2) add");
            System.out.println("3) mark as done");
            System.out.println("4) remove");
            System.out.println("x) quit");

            System.out.print("> ");
            String command = this.scanner.nextLine();
            if (command.equals("x")) {
                break;
            }

            if (command.equals("1")) {
                System.out.println("Listing the database contents");
                List<Todo> todoList = this.database.list();
                for (Todo todo : todoList) {
                    System.out.println(todo);
                }
            }
            
            if (command.equals("2")) {
                System.out.println("Adding a new todo");
                System.out.println("Enter name");
                String name = this.scanner.nextLine();
                System.out.println("Enter description");
                String description = this.scanner.nextLine();
                Todo todo = new Todo(name, description, Boolean.FALSE);
                this.database.add(todo);
            }
            
            if (command.equals("3")) {
                System.out.println("Which todo should be marked as done (give the id)?");
                int idToMarkAsDone = Integer.valueOf(this.scanner.nextLine());
                this.database.markAsDone(idToMarkAsDone);     
            }
            
            if (command.equals("4")) {
                System.out.println("Which todo should be removed (give the id)?");
                int idToBeRemoved = Integer.valueOf(this.scanner.nextLine());
                this.database.remove(idToBeRemoved);
            }
        }

        System.out.println("Thank you!");
    }

}
