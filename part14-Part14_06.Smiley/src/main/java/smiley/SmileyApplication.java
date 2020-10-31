package smiley;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SmileyApplication extends Application {
    
    @Override
    public void start(Stage window) {
        
        Canvas paintingCanvas = new Canvas(480, 480);
        GraphicsContext painter = paintingCanvas.getGraphicsContext2D();
        
        painter.setFill(Color.BLACK);
        painter.fillRect(50, 250, 50, 50);
        painter.fillRect(100, 300, 280, 50);
        painter.fillRect(380, 250, 50, 50);
        painter.fillRect(100, 100, 50, 50);
        painter.fillRect(330, 100, 50, 50);

        BorderPane paintingLayout = new BorderPane();
        paintingLayout.setCenter(paintingCanvas);
        
        Scene scene = new Scene(paintingLayout);
        window.setScene(scene);
        window.show();
    }


    public static void main(String[] args) {
        launch(SmileyApplication.class);
    }

}
