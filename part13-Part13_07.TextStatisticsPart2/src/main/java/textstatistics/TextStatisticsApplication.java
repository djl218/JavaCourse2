package textstatistics;

import java.util.Arrays;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextStatisticsApplication extends Application {

    @Override
    public void start(Stage window) {
        BorderPane layout = new BorderPane();
        Label leftLabel = new Label("Letters: ");
        Label middleLabel = new Label("Words: ");
        Label rightLabel = new Label("The longest word is: ");

        HBox textComponents = new HBox();
        textComponents.setSpacing(10);
        textComponents.getChildren().add(leftLabel);
        textComponents.getChildren().add(middleLabel);
        textComponents.getChildren().add(rightLabel);

        layout.setBottom(textComponents);
        
        TextArea textArea = new TextArea("");
        layout.setCenter(textArea);
        
        textArea.textProperty().addListener((change, oldValue, newValue) -> {
            int characters = newValue.length();
            String[] parts = newValue.split(" ");
            int words = parts.length;
            String longest = Arrays.stream(parts)
                    .sorted((s1, s2) -> s2.length() - s1.length())
                    .findFirst()
                    .get();
            leftLabel.setText("Letters: " + characters);
            middleLabel.setText("Words: " + words);
            rightLabel.setText("The longest word is: " + longest);
        });

        Scene view = new Scene(layout);

        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

}
