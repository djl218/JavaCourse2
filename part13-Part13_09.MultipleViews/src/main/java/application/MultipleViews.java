package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class MultipleViews extends Application {
    
    @Override
    public void start(Stage window) {
        BorderPane firstLayout = new BorderPane();         
        Label atFirst = new Label("First view!");
        Button toSecond = new Button("To the second view!");
        firstLayout.setTop(atFirst);
        firstLayout.setCenter(toSecond);
        Scene first = new Scene(firstLayout);
        
        VBox secondLayout = new VBox();
        secondLayout.setSpacing(10);
        Button toThird = new Button("To the third view!");
        Label atSecond = new Label("Second view!");
        secondLayout.getChildren().add(toThird);
        secondLayout.getChildren().add(atSecond);
        Scene second = new Scene(secondLayout);
        
        GridPane thirdLayout = new GridPane();
        Label atThird = new Label("Third view!");
        Button toFirst = new Button("To the first view!");
        thirdLayout.add(atThird, 0, 0);
        thirdLayout.add(toFirst, 1, 1);
        Scene third = new Scene(thirdLayout);
        
        toSecond.setOnAction((event) -> {
            window.setScene(second);
        });
        
        toThird.setOnAction((event) -> {
            window.setScene(third);
        });
        
        toFirst.setOnAction((event) -> {
            window.setScene(first);
        });    
        
        window.setScene(first);
        window.show();
    }

    public static void main(String[] args) {
        launch(MultipleViews.class);
    }

}
