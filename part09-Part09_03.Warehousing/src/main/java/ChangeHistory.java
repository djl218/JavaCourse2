import java.util.ArrayList;
import java.util.Collections;

public class ChangeHistory{
    private ArrayList<Double> changes;
    
    public ChangeHistory() {
        this.changes = new ArrayList<>();
    }
    
    public void add(double status) {
        this.changes.add(status);
    }
    
    public void clear() {
        this.changes.clear();
    }
    
    @Override
    public String toString() {
        return this.changes.toString();
    }
    
    public double maxValue() {
        if (this.changes.isEmpty()) {
            return 0.0;
        }
        
        return (double) Collections.max(this.changes);
    }
    
    public double minValue() {
        if (this.changes.isEmpty()) {
            return 0.0;
        }
        
        return (double) Collections.min(this.changes);
    }
    
    public double average() {
        double sum = 0.0;
        
        if (this.changes.isEmpty()) {
            return 0.0;
        }
        
        for (double change : this.changes) {
            sum += change;
        }
        
        return sum / this.changes.size();
    }
}
