/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab07b;

import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author 6324569
 */
public class Lab07B extends Application {
    Image[] images = new Image[20];
    ImageView imageView = null;
    int idx = 0;
    boolean paused = false;
    double speed = 1000;
    
    /**
     * GitHub: https://github.com/QuentinProulx/Lab07B
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        for (int i = 0; i < 20; i++) {
            images[i] = new Image("file:images/" + (101 + i) + ".jpg");
        }
        
        imageView = new ImageView(images[idx++]);
        
        Button play = new Button("Play");
        Button pause = new Button("Pause");
        Button speed1 = new Button("Speed+");
        Button speed2 = new Button("Speed-");
        
        GridPane gridPane = new GridPane();
        gridPane.add(play, 0, 0);
        gridPane.add(pause, 1, 0);
        gridPane.add(speed1, 2, 0);
        gridPane.add(speed2, 3, 0);
        
        gridPane.setHgap(10);
        gridPane.setTranslateY(-20);
        
        gridPane.setAlignment(Pos.CENTER);
        
        FadeTransition trans = new FadeTransition(Duration.millis(1000), imageView);
        trans.setFromValue(1);
        trans.setToValue(0);
        
        FadeTransition trans2 = new FadeTransition(Duration.millis(1000), imageView);
        trans2.setFromValue(0);
        trans2.setToValue(1);
        
        trans2.setOnFinished(e -> {
            if (paused == false) {
                trans.play();
            }
        });
        
        play.setOnMouseClicked(e -> {
            paused = false;
            trans.play();
        });
        
        pause.setOnMouseClicked(e -> {
            if (paused == true) {
                paused = false;
            } else {
                paused = true;
            }
        });
        
        speed1.setOnMouseClicked(e -> {
            speed /= 1.5;
            trans.setDuration(Duration.millis(speed));
        });
        
        speed2.setOnMouseClicked(e -> {
            speed += 250;
            trans.setDuration(Duration.millis(speed));
        });
        
        trans.setOnFinished(e -> {
            System.out.println(images[idx].getUrl());
            imageView.setImage(images[idx++]);
            
            trans.setNode(imageView);
            trans2.play();
        });
        
        BorderPane root = new BorderPane(imageView, null, null, gridPane, null);
        Scene scene = new Scene(root, 500, 500);
        
        stage.setScene(scene);
        stage.setTitle("Image Slideshow");
        stage.setResizable(false);
        stage.show();
    }
    
}
