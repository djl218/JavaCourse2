import java.util.HashMap;
import java.util.ArrayList;

public class VehicleRegistry {
    private HashMap<LicensePlate, String> registry;
    
    public VehicleRegistry() {
        this.registry = new HashMap<>();
    }
    
    public boolean add(LicensePlate licensePlate, String owner) {
        if (this.registry.get(licensePlate) == null) {
            this.registry.put(licensePlate, owner);
            return true;
        }
        
        return false;
    }
    
    public String get(LicensePlate licensePlate) {
        return this.registry.get(licensePlate);
    }
    
    public boolean remove(LicensePlate licensePlate) {
        if (this.registry.get(licensePlate) == null) {
            return false;
        }
        
        this.registry.remove(licensePlate);
        return true;
    }
    
    public void printLicensePlates() {
        for (LicensePlate registeredPlate : this.registry.keySet()) {
            System.out.println(registeredPlate);
        }
    }
    
    public void printOwners() {
        ArrayList<String> owners = new ArrayList<>();
        
        for (String registeredOwner : this.registry.values()) {
            if (!owners.contains(registeredOwner)) {
                owners.add(registeredOwner);
            }
        }
        
        for (String registeredOwner : owners) {
            System.out.println(registeredOwner);
        }
    }
}
