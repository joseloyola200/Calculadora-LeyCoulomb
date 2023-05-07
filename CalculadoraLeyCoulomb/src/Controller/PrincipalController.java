/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Loyola01
 */
public class PrincipalController implements Initializable {

    @FXML
    private BorderPane bpBackground;
    @FXML
    private Button btnTeoria;
    @FXML
    private Button btnEjercicios;
    @FXML
    private Button btnCalculadora;
    int x,y=0;
    @FXML
    private ImageView minimizar;
    @FXML
    private ImageView cerrar;
    @FXML
    private HBox topB;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadPanel("Calculadora");
    }
    @FXML
    private void click_btnTeoria(ActionEvent event) {
        loadPanel("Teoria");
    }
    @FXML
    private void click_btnEjercicios(ActionEvent event) {
        loadPanel("Ejercicios");
    }
    @FXML
    private void click_btnCalculadora(ActionEvent event) {
        loadPanel("Calculadora");
    }
    private void loadPanel(String panel){
        Parent root = null;
        try{
            root=FXMLLoader.load(getClass().getResource("/View/"+panel+".fxml"));
            System.out.println("Hola mundo de mrd");
        }catch(IOException exception){
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, exception);
        }
        bpBackground.setCenter(root);
    }
    @FXML
    private void minimizar_click(MouseEvent event) {
        Stage stage = (Stage) minimizar.getScene().getWindow();
        stage.setIconified(true);
    }
    @FXML
    private void cerrar_click(MouseEvent event) {
        Platform.exit();
    }
}