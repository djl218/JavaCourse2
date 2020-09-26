import java.util.List;
import java.util.ArrayList;

public class Herd implements Movable {
    private List<Movable> herd;
    
    public Herd() {
        this.herd = new ArrayList<>();
    }
    
    public String toString() {
        String herdMembers = "";
        
        for (Movable movable : herd) {
            herdMembers = herdMembers + movable.toString() + "\n";
        }
        
        return herdMembers;
    }
    
    public void addToHerd(Movable movable) {
        herd.add(movable);
    }
    
    public void move(int dx, int dy) {
        for (Movable movable : herd) {
            movable.move(dx, dy);
        }
    }
}
