import java.util.Map;
import java.util.HashMap;

public class ShoppingCart {
    private Map<String, Item> cart;
    
    public ShoppingCart() {
        this.cart = new HashMap<>();
    }
    
    public void add(String product, int price) {
        if (!(cart.containsKey(product))) {
            Item newItem = new Item(product, 1, price);
            cart.put(product, newItem);
        } else {
            Item item = cart.get(product);
            item.increaseQuantity();
        }
    }
    
    public int price() {
        int totPrice = 0;
        
        for (Item item : cart.values()) {
            totPrice += item.price();
        }
        
        return totPrice;
    }
    
    public void print() {
        int i = 0;
        for (String key : cart.keySet()) {
            System.out.println(cart.get(key));
        }
    }
}
