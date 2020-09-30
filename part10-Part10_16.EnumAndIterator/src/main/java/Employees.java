import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Employees {
    private ArrayList<Person> employees;
    
    public Employees() {
        this.employees = new ArrayList<>();
    }
    
    public void add(Person personToAdd) {
        employees.add(personToAdd);
    }
    
    public void add(List<Person> peopleToAdd) {
        peopleToAdd.stream().forEach(person ->
            employees.add(person));
    }
    
    public void print() {
        employees.stream().forEach(employee ->
            System.out.println(employee.toString()));
    }
    
    public void print(Education education) {
        Iterator<Person> iterator = employees.iterator();
        
        while (iterator.hasNext()) {
           Person nextInLine = iterator.next();
           if (nextInLine.getEducation() == education) {
               System.out.println(nextInLine);
           }            
        }
    }
    
    public void fire(Education education) {
        Iterator<Person> iterator = employees.iterator();
        
        while (iterator.hasNext()) {
            if (iterator.next().getEducation() == education) {
                iterator.remove();
            }
        }
    }
}
