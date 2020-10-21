package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {
    private ArrayList<Sensor> sensors;
    private ArrayList<Integer> readings;
    
    public AverageSensor() {
        this.sensors = new ArrayList<>();
        this.readings = new ArrayList<>();
    }
    
    public boolean isOn() {
        boolean onTest = true;
        
        for (Sensor sensor : sensors) {
            if (sensor.isOn() == false) {
                onTest = false;
            }
        }
        return onTest;
    }
    
    public void setOn() {
        for (Sensor sensor : sensors) {
            sensor.setOn();
        }
    }
    
    public void setOff() {
        for (Sensor sensor : sensors) {
            sensor.setOff();
        }
    }
    
    public int read() {
        if (sensors.size() == 0) {
            throw new IllegalStateException("No sensors have been added yet.");
        }
        
        int numberOfSensors = sensors.size();
        int sum = 0;
        int average = 0;
        
        for (Sensor sensor : sensors) {
            if (sensor.isOn() == false) {
                throw new IllegalStateException("The AverageSensor is off.");
            }
            sum += sensor.read();
        }
        
        average = sum / numberOfSensors;
        readings.add(average);
        return average;
    }
    
    public void addSensor(Sensor toAdd) {
        sensors.add(toAdd);
    }
    
    public List<Integer> readings() {
        return readings;
    }
}
