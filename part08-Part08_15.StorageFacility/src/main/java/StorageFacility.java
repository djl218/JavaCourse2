import java.util.HashMap;
import java.util.ArrayList;

public class StorageFacility {
    private HashMap<String, ArrayList<String>> units;
    
    public StorageFacility() {
        this.units = new HashMap<>();
    }
    
    public void add(String unit, String item) {
        this.units.putIfAbsent(unit, new ArrayList<>());
        
        this.units.get(unit).add(item);
    }
    
    public ArrayList<String> contents(String storageUnit) {
        ArrayList<String> contentsList = new ArrayList<>();
        ArrayList<String> emptyList = new ArrayList<>();
        
        contentsList = this.units.get(storageUnit);
        
        if (contentsList == null) {
            return emptyList;
        } else {
            return contentsList;
        }
        
        // or this
        // return this.units.getOrDefault(storageUnit, new ArrayList());
    }
    
    public void remove(String storageUnit, String item) {
        ArrayList<String> contentsList = new ArrayList<>();
        
        this.units.putIfAbsent(storageUnit, new ArrayList<>());
                
        contentsList = this.units.get(storageUnit);
        
        if (contentsList.isEmpty()) {
            this.units.remove(storageUnit);
        } else {
            if (contentsList.contains(item)) {
                contentsList.remove(item);
                if (contentsList.isEmpty()) {
                    this.units.remove(storageUnit);
                } else {
                    this.units.put(storageUnit, contentsList);
                }
            }
        }
        
        //or this
        /* 
        if (!this.units.containsKey(storageUnit)) {
            return;
        }
        
        this.units.get(storageUnit).remove(item);
        
        if (this.units.get(storageUnit).isEmpty()) {
            this.units.remove(storageUnit);
        }
        */
    }
    
    public ArrayList<String> storageUnits() {
        ArrayList<String> itemsInUnit = new ArrayList<>();
        ArrayList<String> listOfUnits = new ArrayList<>();
        
        for (String unit : this.units.keySet()) {
            this.units.putIfAbsent(unit, new ArrayList<>());
            itemsInUnit = this.units.get(unit);
            
            if ((itemsInUnit.isEmpty())) {
                continue;
            } else {
                listOfUnits.add(unit);
            }
        }
        
        return listOfUnits;
        
        //or this
        /*
        ArrayList<String> units = new ArrayList<>();
        for (String unit : this.units.keySet()) {
            units.add(unit);
        }
        
        return units;
        */
    }
}
