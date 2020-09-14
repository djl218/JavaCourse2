public class Container {
    private int container;
    
    public Container() {
        this.container = container;
    }
    
    public int contains() {
        return this.container;
    }
    
    public void add(int amount) {
        if (amount > 0 && this.container + amount <= 100) {
            this.container = this.container + amount;
        } else if (amount > 0 && this.container + amount > 100) {
            this.container = 100;
        }
    }
    
    public void remove(int amount) {
        if (amount > 0 && this.container - amount > 0) {
            this.container = this.container - amount;
        } else if (amount > 0 && this.container - amount < 0) {
            this.container = 0;
        }
    }
    
    public String toString() {
        return this.container + "/100";
    }
}
