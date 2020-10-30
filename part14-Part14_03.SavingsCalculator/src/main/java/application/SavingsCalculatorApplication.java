package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class SavingsCalculatorApplication extends Application {
    private boolean running;
    
    public SavingsCalculatorApplication() {
        this.running = true;
    }
    
    @Override
    public void start(Stage stage) {
        BorderPane layout = new BorderPane();
        
        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis();
        
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Savings Calculator");
        
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(40));
        vbox.setSpacing(40);
        
        BorderPane topBorderPane = new BorderPane();
        Label monthlySavings = new Label("Monthly Savings");
        Slider topSlider = new Slider(25, 250, 25);
        topSlider.setShowTickMarks(true);
        topSlider.setShowTickLabels(true);
        topSlider.setMajorTickUnit(25);
        topSlider.setBlockIncrement(1);
        Label topSliderReading = new Label(Double.toString(topSlider.getValue()));
        topSlider.valueProperty().addListener(
            new ChangeListener<Number>() {
                public void changed(ObservableValue <? extends Number >
                        observable, Number oldValue, Number newValue)
                {
                    topSliderReading.setText(String.valueOf(newValue.intValue()));
                }
            });
        topBorderPane.setLeft(monthlySavings);
        topBorderPane.setCenter(topSlider);
        topBorderPane.setRight(topSliderReading);
                
        BorderPane bottomBorderPane = new BorderPane();
        Label yearlyInterestRate = new Label("Yearly Interest Rate");
        Slider bottomSlider = new Slider(0, 10, 0);
        bottomSlider.setShowTickLabels(true);
        bottomSlider.setBlockIncrement(1);
        Label bottomSliderReading = new Label(Double.toString(bottomSlider.getValue()));
        bottomSlider.valueProperty().addListener(
            new ChangeListener<Number>() {
                public void changed(ObservableValue <? extends Number >
                    observable, Number oldValue, Number newValue)
                {
                    bottomSliderReading.setText(String.valueOf(newValue.intValue()));
                }
            });
        bottomBorderPane.setLeft(yearlyInterestRate);
        bottomBorderPane.setCenter(bottomSlider);
        bottomBorderPane.setRight(bottomSliderReading);
        
        vbox.getChildren().add(topBorderPane);
        vbox.getChildren().add(bottomBorderPane);
        
        XYChart.Series savings = new XYChart.Series();
        savings.setName("Savings");
        for (int i = 0; i < 31; i++) {
            XYChart.Data<Number, Number> data = new XYChart.Data(i, Double.valueOf(topSliderReading.getText()) * 12.0 * i);
            savings.getData().add(data);
        }
        lineChart.getData().add(savings);
        /*for (int i = 0; i < 31; i++) {
            savings.getData().add(new XYChart.Data(i, Double.valueOf(topSliderReading.getText()) * 12.0 * i));
        }*/
        for (int i = 0; i < 31; i++) {
            savings.getData().get(i).setYValue((Number)(Double.valueOf(topSliderReading.getText()) * 12 * i));
        }
        /*for (XYChart.Data data : (XYChart.Series(savings.getData())) {
            data.setYValue(Double.valueOf(data.getXValue()) * 12.0 * Double.valueOf(topSliderReading.getText()));
        }*/

        
        layout.setCenter(lineChart);
        layout.setTop(vbox);
        
        Scene view = new Scene(layout, 640, 480);
        stage.setScene(view);
        stage.show();
    }

    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
    }

}
