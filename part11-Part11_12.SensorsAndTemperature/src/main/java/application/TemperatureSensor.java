package application;

import java.util.Random;

public class TemperatureSensor implements Sensor {
    private boolean sensor;
    
    public TemperatureSensor() {
        this.sensor = false;
    }
    
    public boolean isOn() {
        if (sensor == false) {
            return false;
        }
        return true;
    }
    
    public void setOn() {
        sensor = true;
    }
    
    public void setOff() {
        sensor = false;
    }
    
    public int read() {
        if (sensor == false) {
            throw new IllegalStateException("The sensor is off.");
        }
        return new Random().nextInt(61) -30;
    }
    
}
