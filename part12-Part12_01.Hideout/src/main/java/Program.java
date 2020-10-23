import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        HideOut<String> den = new HideOut<>();
        System.out.println(den.isInHideout());
        den.putIntoHideout("peekaboo");
        System.out.println(den.isInHideout());
        System.out.println(den.takeFromHideout());
        System.out.println(den.isInHideout());
        den.putIntoHideout("toodaloo");
        den.putIntoHideout("heelloo");
        System.out.println(den.isInHideout());
        System.out.println(den.takeFromHideout());
        System.out.println(den.isInHideout());
    }
}
