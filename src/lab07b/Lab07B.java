/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab07b;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 *
 * @author 6324569
 */
public class Lab07B extends Application {

    Image[] images = new Image[]();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        
        ImageView imageView = new ImageView();
        
        Pane root = new Pane();
        Scene scene = new Scene(root, 500, 500);
        
        stage.setScene(scene);
        stage.setTitle("Image Slideshow");
        stage.setResizable(false);
        stage.show();
    }
    
}
