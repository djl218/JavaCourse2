package application;

import java.nio.file.Paths;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class PartiesApplication extends Application {
    
    @Override
    public void start(Stage stage) {
        ArrayList<String> partiesName = new ArrayList<>();
        HashMap<String, String[]> parties = new HashMap<>();
        
        try (Scanner scan = new Scanner(Paths.get("partiesdata.tsv"))) {
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                
                String[] parts = line.split("\t");
                String name = parts[0];
                
                partiesName.add(name);
                parties.put(name, parts);
            }    
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        NumberAxis xAxis = new NumberAxis(1966, 2010, 4);
        NumberAxis yAxis = new NumberAxis(0, 30, 5);
        
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Relative Support of the Parties");
            
        for (int i = 1; i < partiesName.size(); i++) {
            XYChart.Series data = new XYChart.Series();
            String[] arr = parties.get(partiesName.get(i));
            data.setName(partiesName.get(i));
            for (int j = 1; j < parties.get("Party").length; j++) {
                if (arr[j].equals("-")) {
                    data.getData().add(new XYChart.Data((Integer.valueOf(parties.get("Party")[j])), 0));
                } else {
                    data.getData().add(new XYChart.Data((Integer.valueOf(parties.get("Party")[j])), Double.valueOf(arr[j])));
                }   
            }
            lineChart.getData().add(data);
            }
            
        Scene view = new Scene(lineChart, 640, 480);
        stage.setScene(view);
        stage.show();
    }

    public static void main(String[] args) {
        launch(PartiesApplication.class);
    }

}
