import java.util.ArrayList;

public class OneItemBox extends Box{
    private ArrayList<Item> possibleOneItem;
    
    public OneItemBox() {
        this.possibleOneItem = new ArrayList<>();
    }
    
    @Override
    public void add(Item item) {
        if (this.possibleOneItem.size() < 1) {
            this.possibleOneItem.add(item);
        }
    }
    
    @Override
    public boolean isInBox(Item item) {
        if (this.possibleOneItem.contains(item)) {
            return true;
        }
        return false;
    }
}
