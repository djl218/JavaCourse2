import java.util.ArrayList;

public class Box implements Packable {
    private ArrayList<Packable> packables;
    private double capacity;
    
    public Box(double capacity) {
        this.packables = new ArrayList<>();
        this.capacity = capacity;
    }
    
    public void add(Packable packable) {
        if (weight() + packable.weight() < this.capacity) {
            this.packables.add(packable);
        }
    }
    
    public int count() {
        return (int) this.packables.size();
    }
    
    public double weight() {
        double weight = 0;
        
        for (Packable item : this.packables) {
            weight += item.weight();
        }
        
        return weight;
    }
    
    @Override
    public String toString() {
        return "Box: " + count() + " items, total weight " + weight() + " kg";
    }
}
