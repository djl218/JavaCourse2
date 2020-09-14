import java.util.Scanner;

public class LiquidContainers2 {

    public static void main(String[] args) {
        
        Container first = new Container();
        Container second = new Container();
        Scanner scan = new Scanner(System.in);
        
        UserInterface ui = new UserInterface(first, second, scan);
        ui.start();
    }
}
