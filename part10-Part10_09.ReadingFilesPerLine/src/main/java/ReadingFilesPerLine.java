import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReadingFilesPerLine {

    public static void main(String[] args) {
        // Just used tests to make sure it worked.
    }
    
    public static List<String> read(String file) {
        List<String> rows = new ArrayList<>();

        try {
        Files.lines(Paths.get(file)).forEach(row -> rows.add(row));
        } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
        }

        return rows;
    }
}
