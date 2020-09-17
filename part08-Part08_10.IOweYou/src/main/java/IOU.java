import java.util.HashMap;

public class IOU {
    private HashMap<String, Double> iou;
    
    public IOU() {
        this.iou = new HashMap<>();
    }
    
    public void setSum(String toWhom, double amount) {
        this.iou.put(toWhom, amount);
    }
    
    public double howMuchDoIOweTo(String toWhom) {
        return this.iou.getOrDefault(toWhom, 0.0);
    }
}
