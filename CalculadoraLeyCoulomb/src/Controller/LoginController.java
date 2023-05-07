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
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Loyola01
 */
public class LoginController implements Initializable {

    @FXML
    private Button LogIn;
    @FXML
    private Button Clean;
    @FXML
    private TextField txfUsuario;
    @FXML
    private PasswordField txfPassword;
    @FXML
    private Label lblMensaje;
    @FXML
    private ImageView minimizar;
    @FXML
    private ImageView cerrar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void LogIn_click(ActionEvent event) {
        String user=txfUsuario.getText();
        String psw=txfPassword.getText();
        if (user.equals("root") && psw.equals("123")) {
            lblMensaje.setText("You are in");
            load("Principal", event);
            
        }else{
            lblMensaje.setText("Datos incorrectos");
        }
    }

    @FXML
    private void Clean_click(ActionEvent event) {
        txfUsuario.setText("");
        txfPassword.setText("");
        lblMensaje.setText("");
    }

    @FXML
    private void minimizar_click(MouseEvent event) {
        Stage stage = (Stage) minimizar.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    private void cerrar_click(MouseEvent event) {
        javafx.application.Platform.exit();
    }

    private void load(String panel, Event event){
        
        try {
            Object eventSource = event.getSource();
            Node sourceAsNode = (Node) eventSource;
            Scene oldScene = sourceAsNode.getScene();
            Window window = oldScene.getWindow();
            Stage stage=(Stage) window;
            stage.hide();
            
            Parent root = FXMLLoader.load(getClass().getResource("/View/"+panel+".fxml"));
            Scene scene = new Scene(root);
            Stage newStage = new Stage();
            newStage.setScene(scene);
            newStage.show();
            newStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    Platform.exit();
                }
            });
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
