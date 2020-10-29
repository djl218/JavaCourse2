package ticTacToe;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TicTacToeApplication extends Application {
    private boolean turn;
    private int[][] locations;
    
    public TicTacToeApplication() {
        turn = true;
        locations = new int[3][3];
    }
    
    @Override
    public void start(Stage window) throws Exception {
        
        BorderPane layout = new BorderPane();
        
        Label text = new Label("Turn: X");
        text.setFont(Font.font("Monospaced", 40));
        layout.setTop(text);
        
        GridPane array = new GridPane();
        
        Button btn00 = new Button(" ");
        Button btn10 = new Button(" ");
        Button btn20 = new Button(" ");
        Button btn01 = new Button(" ");
        Button btn11 = new Button(" ");
        Button btn21 = new Button(" ");
        Button btn02 = new Button(" ");
        Button btn12 = new Button(" ");
        Button btn22 = new Button(" ");
        
        btn00.setFont(Font.font("Monospaced", 40));
        btn10.setFont(Font.font("Monospaced", 40));
        btn20.setFont(Font.font("Monospaced", 40));
        btn01.setFont(Font.font("Monospaced", 40));
        btn11.setFont(Font.font("Monospaced", 40));
        btn21.setFont(Font.font("Monospaced", 40));
        btn02.setFont(Font.font("Monospaced", 40));
        btn12.setFont(Font.font("Monospaced", 40));
        btn22.setFont(Font.font("Monospaced", 40));
        
        array.add(btn00, 0, 0);
        array.add(btn10, 1, 0);
        array.add(btn20, 2, 0);
        array.add(btn01, 0, 1);
        array.add(btn11, 1, 1);
        array.add(btn21, 2, 1);
        array.add(btn02, 0, 2);
        array.add(btn12, 1, 2);
        array.add(btn22, 2, 2);
        
        ArrayList<Button> buttons = new ArrayList<>();
        
        buttons.add(btn00);
        buttons.add(btn10);
        buttons.add(btn20);
        buttons.add(btn01);
        buttons.add(btn11);
        buttons.add(btn21);
        buttons.add(btn02);
        buttons.add(btn12);
        buttons.add(btn22);
        
        btn00.setOnAction((event) -> {
            if (btn00.getText().equals(" ")) {
                if (turn) {
                    locations[0][0] = 1;
                    btn00.setText("X");
                    text.setText("Turn: O");
                    turn = false;
                } else if (!turn) {
                    locations[0][0] = 10;
                    btn00.setText("O");
                    text.setText("Turn: X");
                    turn = true;
                }
            }
            
            ArrayList<Integer> rowSums = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                int sum = 0;
                for (int j = 0; j < 3; j++) {
                    sum += locations[i][j];
                }
                rowSums.add(sum);
                if (rowSums.contains(3) || rowSums.contains(30)) {
                    text.setText("The end!");
                }
            }
            
            ArrayList<Integer> colSums = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                int sum = 0;
                for (int j = 0; j < 3; j++) {
                    sum += locations[j][i];
                }
                colSums.add(sum);
                if (colSums.contains(3) || colSums.contains(30)) {
                    text.setText("The end!");;
                }
            }
            
            ArrayList<Integer> diagSums = new ArrayList<>();
            int sum1 = 0;
            int sum2 = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == j) {
                        sum1 += locations[i][j];
                    }
                    if ((i + j) == 2) {
                        sum2 += locations[i][j];
                    }     
                }
            } 
            diagSums.add(sum1);
            diagSums.add(sum2);
            if (diagSums.contains(3) || diagSums.contains(30)) {
                    text.setText("The end!");
            }
        });
        
        btn10.setOnAction((event) -> {
            if (btn10.getText().equals(" ")) {
                if (turn) {
                    locations[1][0] = 1;
                    btn10.setText("X");
                    text.setText("Turn: O");
                    turn = false;
                } else if (!turn) {
                    locations[1][0] = 10;
                    btn10.setText("O");
                    text.setText("Turn: X");
                    turn = true;
                }
            }
            
            ArrayList<Integer> rowSums = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                int sum = 0;
                for (int j = 0; j < 3; j++) {
                    sum += locations[i][j];
                }
                rowSums.add(sum);
                if (rowSums.contains(3) || rowSums.contains(30)) {
                    text.setText("The end!");
                }
            }
            
            ArrayList<Integer> colSums = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                int sum = 0;
                for (int j = 0; j < 3; j++) {
                    sum += locations[j][i];
                }
                colSums.add(sum);
                if (colSums.contains(3) || colSums.contains(30)) {
                    text.setText("The end!");
                }
            }
            
            ArrayList<Integer> diagSums = new ArrayList<>();
            int sum1 = 0;
            int sum2 = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == j) {
                        sum1 += locations[i][j];
                    }
                    if ((i + j) == 2) {
                        sum2 += locations[i][j];
                    }     
                }
            } 
            diagSums.add(sum1);
            diagSums.add(sum2);
            if (diagSums.contains(3) || diagSums.contains(30)) {
                    text.setText("The end!");
            }
        });
        
        btn20.setOnAction((event) -> {
            if (btn20.getText().equals(" ")) {
                if (turn) {
                    locations[2][0] = 1;
                    btn20.setText("X");
                    text.setText("Turn: O");
                    turn = false;
                } else if (!turn) {
                    locations[2][0] = 10;
                    btn20.setText("O");
                    text.setText("Turn: X");
                    turn = true;
                }
            }
            
            ArrayList<Integer> rowSums = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                int sum = 0;
                for (int j = 0; j < 3; j++) {
                    sum += locations[i][j];
                }
                rowSums.add(sum);
                if (rowSums.contains(3) || rowSums.contains(30)) {
                    text.setText("The end!");
                }
            }
            
            ArrayList<Integer> colSums = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                int sum = 0;
                for (int j = 0; j < 3; j++) {
                    sum += locations[j][i];
                }
                colSums.add(sum);
                if (colSums.contains(3) || colSums.contains(30)) {
                    text.setText("The end!");
                }
            }
            
            ArrayList<Integer> diagSums = new ArrayList<>();
            int sum1 = 0;
            int sum2 = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == j) {
                        sum1 += locations[i][j];
                    }
                    if ((i + j) == 2) {
                        sum2 += locations[i][j];
                    }     
                }
            } 
            diagSums.add(sum1);
            diagSums.add(sum2);
            if (diagSums.contains(3) || diagSums.contains(30)) {
                    text.setText("The end!");
            }
        });
        
        btn01.setOnAction((event) -> {
            if (btn01.getText().equals(" ")) {
                if (turn) {
                    locations[0][1] = 1;
                    btn01.setText("X");
                    text.setText("Turn: O");
                    turn = false;
                } else if (!turn) {
                    locations[0][1] = 10;
                    btn01.setText("O");
                    text.setText("Turn: X");
                    turn = true;
                }
            }
            
            ArrayList<Integer> rowSums = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                int sum = 0;
                for (int j = 0; j < 3; j++) {
                    sum += locations[i][j];
                }
                rowSums.add(sum);
                if (rowSums.contains(3) || rowSums.contains(30)) {
                    text.setText("The end!");;
                }
            }
            
            ArrayList<Integer> colSums = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                int sum = 0;
                for (int j = 0; j < 3; j++) {
                    sum += locations[j][i];
                }
                colSums.add(sum);
                if (colSums.contains(3) || colSums.contains(30)) {
                    text.setText("The end!");
                }
            }
            
            ArrayList<Integer> diagSums = new ArrayList<>();
            int sum1 = 0;
            int sum2 = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == j) {
                        sum1 += locations[i][j];
                    }
                    if ((i + j) == 2) {
                        sum2 += locations[i][j];
                    }     
                }
            } 
            diagSums.add(sum1);
            diagSums.add(sum2);
            if (diagSums.contains(3) || diagSums.contains(30)) {
                    text.setText("The end!");
            }
        });
        
        btn11.setOnAction((event) -> {
            if (btn11.getText().equals(" ")) {
                if (turn) {
                    locations[1][1] = 1;
                    btn11.setText("X");
                    text.setText("Turn: O");
                    turn = false;
                } else if (!turn) {
                    locations[1][1] = 10;
                    btn11.setText("O");
                    text.setText("Turn: X");
                    turn = true;
                }
            }
            
            ArrayList<Integer> rowSums = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                int sum = 0;
                for (int j = 0; j < 3; j++) {
                    sum += locations[i][j];
                }
                rowSums.add(sum);
                if (rowSums.contains(3) || rowSums.contains(30)) {
                    text.setText("The end!");
                }
            }
            
            ArrayList<Integer> colSums = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                int sum = 0;
                for (int j = 0; j < 3; j++) {
                    sum += locations[j][i];
                }
                colSums.add(sum);
                if (colSums.contains(3) || colSums.contains(30)) {
                    text.setText("The end!");
                }
            }
            
            ArrayList<Integer> diagSums = new ArrayList<>();
            int sum1 = 0;
            int sum2 = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == j) {
                        sum1 += locations[i][j];
                    }
                    if ((i + j) == 2) {
                        sum2 += locations[i][j];
                    }     
                }
            } 
            diagSums.add(sum1);
            diagSums.add(sum2);
            if (diagSums.contains(3) || diagSums.contains(30)) {
                    text.setText("The end!");
            }
        });
        
        btn21.setOnAction((event) -> {
            if (btn21.getText().equals(" ")) {
                if (turn) {
                    locations[2][1] = 1;
                    btn21.setText("X");
                    text.setText("Turn: O");
                    turn = false;
                } else if (!turn) {
                    locations[2][1] = 10;
                    btn21.setText("O");
                    text.setText("Turn: X");
                    turn = true;
                }
            }
            
            ArrayList<Integer> rowSums = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                int sum = 0;
                for (int j = 0; j < 3; j++) {
                    sum += locations[i][j];
                }
                rowSums.add(sum);
                if (rowSums.contains(3) || rowSums.contains(30)) {
                    text.setText("The end!");
                }
            }
            
            ArrayList<Integer> colSums = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                int sum = 0;
                for (int j = 0; j < 3; j++) {
                    sum += locations[j][i];
                }
                colSums.add(sum);
                if (colSums.contains(3) || colSums.contains(30)) {
                    text.setText("The end!");
                }
            }
            
            ArrayList<Integer> diagSums = new ArrayList<>();
            int sum1 = 0;
            int sum2 = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == j) {
                        sum1 += locations[i][j];
                    }
                    if ((i + j) == 2) {
                        sum2 += locations[i][j];
                    }     
                }
            } 
            diagSums.add(sum1);
            diagSums.add(sum2);
            if (diagSums.contains(3) || diagSums.contains(30)) {
                    text.setText("The end!");
            }
        });
        
        btn02.setOnAction((event) -> {
            if (btn02.getText().equals(" ")) {
                if (turn) {
                    locations[0][2] = 1;
                    btn02.setText("X");
                    text.setText("Turn: O");
                    turn = false;
                } else if (!turn) {
                    locations[0][2] = 10;
                    btn02.setText("O");
                    text.setText("Turn: X");
                    turn = true;
                }
            }
            
            ArrayList<Integer> rowSums = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                int sum = 0;
                for (int j = 0; j < 3; j++) {
                    sum += locations[i][j];
                }
                rowSums.add(sum);
                if (rowSums.contains(3) || rowSums.contains(30)) {
                    text.setText("The end!");
                }
            }
            
            ArrayList<Integer> colSums = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                int sum = 0;
                for (int j = 0; j < 3; j++) {
                    sum += locations[j][i];
                }
                colSums.add(sum);
                if (colSums.contains(3) || colSums.contains(30)) {
                    text.setText("The end!");
                }
            }
            
            ArrayList<Integer> diagSums = new ArrayList<>();
            int sum1 = 0;
            int sum2 = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == j) {
                        sum1 += locations[i][j];
                    }
                    if ((i + j) == 2) {
                        sum2 += locations[i][j];
                    }     
                }
            } 
            diagSums.add(sum1);
            diagSums.add(sum2);
            if (diagSums.contains(3) || diagSums.contains(30)) {
                    text.setText("The end!");
            }
        });
        
        btn12.setOnAction((event) -> {
            if (btn12.getText().equals(" ")) {
                if (turn) {
                    locations[1][2] = 1;
                    btn12.setText("X");
                    text.setText("Turn: O");
                    turn = false;
                } else if (!turn) {
                    locations[1][0] = 10;
                    btn12.setText("O");
                    text.setText("Turn: X");
                    turn = true;
                }
            }
            
            ArrayList<Integer> rowSums = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                int sum = 0;
                for (int j = 0; j < 3; j++) {
                    sum += locations[i][j];
                }
                rowSums.add(sum);
                if (rowSums.contains(3) || rowSums.contains(30)) {
                    text.setText("The end!");
                }
            }
            
            ArrayList<Integer> colSums = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                int sum = 0;
                for (int j = 0; j < 3; j++) {
                    sum += locations[j][i];
                }
                colSums.add(sum);
                if (colSums.contains(3) || colSums.contains(30)) {
                    text.setText("The end!");

                }
            }
            
            ArrayList<Integer> diagSums = new ArrayList<>();
            int sum1 = 0;
            int sum2 = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == j) {
                        sum1 += locations[i][j];
                    }
                    if ((i + j) == 2) {
                        sum2 += locations[i][j];
                    }     
                }
            } 
            diagSums.add(sum1);
            diagSums.add(sum2);
            if (diagSums.contains(3) || diagSums.contains(30)) {
                    text.setText("The end!");
            }
        });
        
        btn22.setOnAction((event) -> {
            if (btn22.getText().equals(" ")) {
                if (turn) {
                    locations[2][2] = 1;
                    btn22.setText("X");
                    text.setText("Turn: O");
                    turn = false;
                } else if (!turn) {
                    locations[2][2] = 10;
                    btn22.setText("O");
                    text.setText("Turn: X");
                    turn = true;
                }
            }
            
            ArrayList<Integer> rowSums = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                int sum = 0;
                for (int j = 0; j < 3; j++) {
                    sum += locations[i][j];
                }
                rowSums.add(sum);
                if (rowSums.contains(3) || rowSums.contains(30)) {
                    text.setText("The end!");
                }
            }
            
            ArrayList<Integer> colSums = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                int sum = 0;
                for (int j = 0; j < 3; j++) {
                    sum += locations[j][i];
                }
                colSums.add(sum);
                if (colSums.contains(3) || colSums.contains(30)) {
                    text.setText("The end!");
                }
            }
            
            ArrayList<Integer> diagSums = new ArrayList<>();
            int sum1 = 0;
            int sum2 = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == j) {
                        sum1 += locations[i][j];
                    }
                    if ((i + j) == 2) {
                        sum2 += locations[i][j];
                    }     
                }
            }
            diagSums.add(sum1);
            diagSums.add(sum2);
            if (diagSums.contains(3) || diagSums.contains(30)) {
                    text.setText("The end!");
            }
        });
        
        layout.setCenter(array);
        
        Scene showing = new Scene(layout);
        
        window.setScene(showing);
        window.show();
    }

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }

}