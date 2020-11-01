package asteroids;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;
import javafx.scene.input.KeyCode;
import javafx.animation.AnimationTimer;
import javafx.stage.Stage;

public class AsteroidsApplication extends Application {
    public static int WIDTH = 300;
    public static int HEIGHT = 200;
    
    @Override
    public void start(Stage stage) throws Exception {
        Pane pane = new Pane();
        pane.setPrefSize(WIDTH, HEIGHT);
        Text text = new Text(10, 20, "Points: 0");
        pane.getChildren().add(text);
        
        AtomicInteger points = new AtomicInteger();
        
        Ship ship = new Ship(WIDTH / 2, HEIGHT / 2);
        List<Asteroid> asteroids = new ArrayList<>();
        List<Projectile> projectiles = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Random rnd = new Random();
            Asteroid asteroid = new Asteroid(rnd.nextInt(WIDTH / 3), rnd.nextInt(HEIGHT));
            asteroids.add(asteroid);
        }
        
        pane.getChildren().add(ship.getCharacter());
        asteroids.forEach(asteroid -> pane.getChildren().add(asteroid.getCharacter()));
        projectiles.forEach(projectile -> {
            asteroids.forEach(asteroid -> {
                if(projectile.collide(asteroid)) {
                    projectile.setAlive(false);
                    asteroid.setAlive(false);
                }
            });
            
            if(!projectile.isAlive()) {
                text.setText("Points: " + points.addAndGet(1000));
            }
        });

        projectiles.stream()
            .filter(projectile -> !projectile.isAlive())
            .forEach(projectile -> pane.getChildren().remove(projectile.getCharacter()));
        projectiles.removeAll(projectiles.stream()
            .filter(projectile -> !projectile.isAlive())
            .collect(Collectors.toList()));

        asteroids.stream()
            .filter(asteroid -> !asteroid.isAlive())
            .forEach(asteroid -> pane.getChildren().remove(asteroid.getCharacter()));
        asteroids.removeAll(asteroids.stream()
            .filter(asteroid -> !asteroid.isAlive())
            .collect(Collectors.toList()));
        
        Scene scene = new Scene(pane);
        
        Map<KeyCode, Boolean> pressedKeys = new HashMap<>();

        scene.setOnKeyPressed(event -> {
            pressedKeys.put(event.getCode(), Boolean.TRUE);
        });

        scene.setOnKeyReleased(event -> {
            pressedKeys.put(event.getCode(), Boolean.FALSE);
        });

    new AnimationTimer() {

        @Override
        public void handle(long now) {
            if(pressedKeys.getOrDefault(KeyCode.LEFT, false)) {
                ship.turnLeft();
            }

            if(pressedKeys.getOrDefault(KeyCode.RIGHT, false)) {
                ship.turnRight();
            }
            
            if(pressedKeys.getOrDefault(KeyCode.UP, false)) {
                ship.accelerate();
            }
            
            if (pressedKeys.getOrDefault(KeyCode.SPACE, false) && projectiles.size() < 5) {
                // we shoot
                Projectile projectile = new Projectile((int) ship.getCharacter().getTranslateX(), (int) ship.getCharacter().getTranslateY());
                projectile.getCharacter().setRotate(ship.getCharacter().getRotate());
                projectiles.add(projectile);

                projectile.accelerate();
                projectile.setMovement(projectile.getMovement().normalize().multiply(5));

                pane.getChildren().add(projectile.getCharacter());
            }
            
            ship.move();
            asteroids.forEach(asteroid -> asteroid.move());
            projectiles.forEach(projectile -> projectile.move());

            asteroids.forEach(asteroid -> {
                if (ship.collide(asteroid)) {
                    stop();
                }
            });
            
            if(Math.random() < 0.005) {
                Asteroid asteroid = new Asteroid(WIDTH, HEIGHT);
                if(!asteroid.collide(ship)) {
                    asteroids.add(asteroid);
                    pane.getChildren().add(asteroid.getCharacter());
                }
            }
        }
    }.start();
        
        stage.setTitle("Asteroids!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(AsteroidsApplication.class);
    }

    public static int partsCompleted() {
        // State how many parts you have completed using the return value of this method
        return 4;
    }

}
