/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package Controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Loyola01
 */
public class Main extends Application {
    double x,y=0;
    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/View/Principal.fxml"));
            Scene scene = new Scene(root);
            scene.setFill(Color.TRANSPARENT);
            scene.setOnMousePressed(mouseEvent -> {
                x = mouseEvent.getX();
                y = mouseEvent.getY();
            });            
            scene.setOnMouseDragged(mouseEvent -> {
                primaryStage.setX(mouseEvent.getScreenX() - x);
                primaryStage.setY(mouseEvent.getScreenY() - y);
            });
            primaryStage.setScene(scene);
            primaryStage.initStyle(StageStyle.TRANSPARENT);
            primaryStage.getIcons().add(new Image("/sourc/img/calculadora.png"));
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}