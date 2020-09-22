public class Student extends Person {
    private int numOfCredits;
    
    public Student(String name, String address) {
        super(name, address);
        this.numOfCredits = 0;
    }
    
    public int credits() {
        return this.numOfCredits;
    }
       
    public void study() {
        this.numOfCredits++;
    }
    
    public String toString() {
        return getName() +"\n" + "  " + getAddress() + "\n" + "  " + "Study credits " + credits();
    }
}
