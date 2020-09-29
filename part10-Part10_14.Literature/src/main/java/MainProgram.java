import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();

        while (true) {
            System.out.print("Input the name of the book, empty stops: ");
            String name = scanner.nextLine();
            if (name.equals("")) {
                break;
            }
            
            System.out.print("Input the age recommendaton: ");
            int age = Integer.valueOf(scanner.nextLine());
            Book book = new Book(name, age);
            books.add(book);
        }
        
        Comparator<Book> comparator = Comparator
                        .comparing(Book::getAge)
                        .thenComparing(Book::getName);
                        
        Collections.sort(books, comparator);
        
        System.out.println("");
        System.out.println(books.size() + " books in total.");
        System.out.println("");
        
        System.out.println("Books:");
        books.stream()
            .forEach(book -> System.out.println(book.getName() + " (recommended for " + book.getAge() + " year-olds or older)"));
        
    }

}
