import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class LiteracyComparison {
    
    public static void main(String[] args) {
        /*ArrayList<String> countries = new ArrayList<>();
        ArrayList<String[]> splitCountries = new ArrayList<>();
        
        try (Scanner scanner = new Scanner(Paths.get("literacy.csv"))) {
            while (scanner.hasNextLine()) {
                String row = scanner.nextLine();
                countries.add(row);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        for (String country : countries) {
            String[] split = country.split(",");
            splitCountries.add(split);
        }
        
        // Use Collections
        Collections.sort(splitCountries, (c1, c2) -> c1[5].compareTo(c2[5]));
        
        splitCountries.stream()
            .forEach((part -> System.out.println(part[3] + " (" + part[4] + "), " + part[2].replace("(%)", "").trim() + ", " + part[5])));
        
        // Use stream instead of Collections
        splitCountries.stream()
            .sorted((c1, c2) -> c1[5].compareTo(c2[5]))
            .forEach((part -> System.out.println(part[3] + " (" + part[4] + "), " + part[2].replace("(%)", "").trim() + ", " + part[5])));*/
        
        // Or use Files
        try {
            Files.lines(Paths.get("literacy.csv"))
                .map(row -> row.split(","))
                .sorted((c1, c2) -> c1[5].compareTo(c2[5]))
                .forEach((part -> System.out.println(part[3] + " (" + part[4] + "), " + part[2].replace("(%)", "").trim() + ", " + part[5])));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
