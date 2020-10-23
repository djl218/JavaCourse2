public class HideOut<T> {
    private T hideOut;
    
    public void putIntoHideout(T toHide) {
        this.hideOut = toHide;
    }
    
    public T takeFromHideout() {
        if (this.hideOut == null) {
            return null;
        }

        T out = this.hideOut;
        this.hideOut = null;
        return out;
    }
    
    public boolean isInHideout() {
        if (this.hideOut == null) {
            return false;
        }
        
        return true;
    }
}
