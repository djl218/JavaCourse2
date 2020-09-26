import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class Warehouse {
    private Map<String, Integer> productPrice;
    private Map<String, Integer> productStock;
    
    public Warehouse() {
        this.productPrice = new HashMap<>();
        this.productStock = new HashMap<>();
    }
    
    public void addProduct(String product, int price, int stock) {
        productPrice.put(product, price);
        productStock.put(product, stock);
    }
    
    public int price(String product) {
       if (productPrice.get(product) == null) {
           return -99;
       }
       
       return productPrice.get(product);
    }
    
    public int stock(String product) {
        if (!productStock.containsKey(product)) {
            return 0;
        }
        if (productStock.get(product) == null) {
            return -99;
        }
        
        return productStock.get(product);
    }
    
    public boolean take(String product) {
        if (productStock.containsKey(product)) {
            if (productStock.get(product) > 0) {
                productStock.put(product, productStock.get(product) - 1);
                return true;
            }
            if ((productStock.put(product, productStock.get(product) - 1) <= 0)) {
                productStock.replace(product, 0);
                return false;
            }
        }
        
        return false;
    }
    
    public Set<String> products() {
        return productPrice.keySet();
    }
}
