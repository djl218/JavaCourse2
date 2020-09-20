import java.util.Objects;

public class LicensePlate {
    private final String liNumber;
    private final String country;

    public LicensePlate(String country, String liNumber) {
        this.liNumber = liNumber;
        this.country = country;
    }

    @Override
    public String toString() {
        return country + " " + liNumber;
    }
    
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        
        if (!(object instanceof LicensePlate)) {
            return false;
        }
        
        LicensePlate licensePlateObject = (LicensePlate) object;
        
        if (this.liNumber.equals(licensePlateObject.liNumber) &&
            this.country.equals(licensePlateObject.country)) {
            return true;
        }
        
        return false;
    }
    
    public int hashCode() {
        if (this.country == null) {
            return this.liNumber.hashCode();
        }
        if (this.liNumber == null) {
            return this.country.hashCode();
        }
        
        return this.liNumber.hashCode() + this.country.hashCode();
    }

}
