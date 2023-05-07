/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Model.Carga;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.scene.web.WebView;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Loyola01
 */
public class CalculadoraController implements Initializable {

    @FXML
    private TextField txfCoeficienteQ1;
    @FXML
    private TextField txfExponenteQ1;
    @FXML
    private TextField txfCoeficienteQ2;
    @FXML
    private TextField txfExponenteQ2;
    @FXML
    private TextField txfDistancia;
    @FXML
    private ChoiceBox<String> cbxMedida;
    private String[] medidas = {"mm", "cm", "dm", "m", "dam", "hm", "km"};
    @FXML
    private Button btnCalcular;
    @FXML
    private Button btnLimpiar;
    @FXML
    private Circle circleCarga1;
    @FXML
    private Circle circleCarga2;
    @FXML
    private Label lblCargaSimb1;
    @FXML
    private Label lblCargaSimb2;
    @FXML
    private Label lblCarga1;
    @FXML
    private Label lblCarga2;
    @FXML
    private Label lblDistancia;
    @FXML
    private WebView txaResultados;
    
    private final String positivo = "#4984eb";
    private final String negativo = "#dd6262";
    private final String blanco = "#ffffff";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cbxMedida.getItems().addAll(medidas);
        cbxMedida.setValue("m");        
    }    

    @FXML
    private void click_btnCalcular(ActionEvent event) {
        try{
            double coe1 = Double.parseDouble(txfCoeficienteQ1.getText());
            double exp1 = Double.parseDouble(txfExponenteQ1.getText());
            double coe2 = Double.parseDouble(txfCoeficienteQ2.getText());
            double exp2 = Double.parseDouble(txfExponenteQ2.getText());
            
            String medida = cbxMedida.getValue();
            double r = convertirDistancia(Double.parseDouble(txfDistancia.getText()), medida);
            lblDistancia.setText("r = " + r + " m");
            drawCarga(coe1, exp1, circleCarga1, lblCargaSimb1, lblCarga1);
            drawCarga(coe2, exp2, circleCarga2, lblCargaSimb2, lblCarga2);

            Carga q1 = new Carga(coe1, exp1);
            Carga q2 = new Carga(coe2, exp2);

            calcularFuerza(q1, q2, r);
        }catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Los datos deben de ser numeros", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void calcularFuerza(Carga q1, Carga q2, double r) {        
        StringBuilder sb = new StringBuilder();
        sb.append("<math display=\"block\">\n");
            sb.append("<mrow>");
                sb.append("<mo>(</mo>");
                    sb.append("<mn>9</mn>");
                    sb.append("<mo>x</mo>");
                    sb.append("<msup>");
                        sb.append("<mi>10</mi>");
                        sb.append("<mn>9</mn>");
                    sb.append("</msup>");
                sb.append("<mo>)</mo>");
                sb.append("<mfrac>");
                    sb.append("<mrow>");
                        sb.append("<mo>(</mo>");
                            sb.append("<mn>").append(q1.getCoe()).append("</mn>");
                            sb.append("<mo>x</mo>");
                            sb.append("<msup>");
                                sb.append("<mi>10</mi>");
                                sb.append("<mn>").append(q1.getExp()).append("</mn>");
                            sb.append("</msup>");
                        sb.append("<mo>)</mo>");
                        sb.append("<mo>*</mo>");
                        sb.append("<mo>(</mo>");
                            sb.append("<mn>").append(q2.getCoe()).append("</mn>");
                            sb.append("<mo>x</mo>");
                            sb.append("<msup>");
                                sb.append("<mi>10</mi>");
                                sb.append("<mn>").append(q2.getExp()).append("</mn>");
                            sb.append("</msup>");
                        sb.append("<mo>)</mo>");
                    sb.append("</mrow>");
                    sb.append("<mrow>");
                        sb.append("<msup>");
                            sb.append("<mi>").append(r).append("</mi>");
                            sb.append("<mn>2</mn>");
                        sb.append("</msup>");
                    sb.append("</mrow>");
                sb.append("</mfrac>");
            sb.append("</mrow>");
        sb.append("</math><br>");
        
        sb.append("<math display=\"block\">\n");
            sb.append("<mfrac>");
                sb.append("<mrow>");
                    sb.append("<mo>(</mo>");
                        sb.append("<mn>9</mn>");
                        sb.append("<mo>x</mo>");
                        sb.append("<msup>");
                            sb.append("<mi>10</mi>");
                            sb.append("<mn>9</mn>");
                        sb.append("</msup>");
                    sb.append("<mo>)</mo>");
                    sb.append("<mo>(</mo>");
                        sb.append("<mn>").append(q1.getCoe()).append("</mn>");
                        sb.append("<mo>x</mo>");
                        sb.append("<msup>");
                            sb.append("<mi>10</mi>");
                            sb.append("<mn>").append(q1.getExp()).append("</mn>");
                        sb.append("</msup>");
                    sb.append("<mo>)</mo>");
                    sb.append("<mo>*</mo>");
                    sb.append("<mo>(</mo>");
                        sb.append("<mn>").append(q2.getCoe()).append("</mn>");
                        sb.append("<mo>x</mo>");
                        sb.append("<msup>");
                            sb.append("<mi>10</mi>");
                            sb.append("<mn>").append(q2.getExp()).append("</mn>");
                        sb.append("</msup>");
                    sb.append("<mo>)</mo>");
                sb.append("</mrow>");
                sb.append("<mrow>");
                    sb.append("<mn>").append(Math.pow(r, 2)).append("</mn>");
                sb.append("</mrow>");
            sb.append("</mfrac>");
        sb.append("</math><br>");
        
        double coeficiente=9*q1.getCoe()* q2.getCoe();
        double exponente=9+q1.getExp()+q2.getExp();
        double distancia=Math.pow(r,2);
        
        sb.append("<math display=\"block\">\n");
            sb.append("<mfrac>");
                sb.append("<mrow>");                    
                    sb.append("<mo>(</mo>");
                        sb.append("<mn>").append(coeficiente).append("</mn>");
                        sb.append("<mo>x</mo>");
                        sb.append("<msup>");
                            sb.append("<mi>10</mi>");
                            sb.append("<mn>").append(exponente).append("</mn>");
                        sb.append("</msup>");
                    sb.append("<mo>)</mo>");                    
                sb.append("</mrow>");
                sb.append("<mrow>");
                    sb.append("<mn>").append(distancia).append("</mn>");
                sb.append("</mrow>");
            sb.append("</mfrac>");
        sb.append("</math><br>");
        
        coeficiente=coeficiente/distancia;
        sb.append("<math display=\"block\">\n");
            sb.append("<mrow>");
                sb.append("<mn>").append(coeficiente).append("</mn>");
                sb.append("<mo>x</mo>");
                sb.append("<msup>");
                    sb.append("<mi>10</mi>");
                    sb.append("<mn>").append(exponente).append("</mn>");
                sb.append("</msup>");                  
            sb.append("</mrow>");
        sb.append("</math><br>");
        txaResultados.getEngine().loadContent(sb.toString());
    }

    @FXML
    private void click_btnLimpiar(ActionEvent event) {
        txfCoeficienteQ1.setText("");
        txfExponenteQ1.setText("");
        txfCoeficienteQ2.setText("");
        txfExponenteQ2.setText("");
        txfDistancia.setText("");
        cleanCarga(circleCarga1, lblCargaSimb1,lblCarga1);
        cleanCarga(circleCarga2, lblCargaSimb2,lblCarga2);
        lblDistancia.setText("r = 0");
        txaResultados.getEngine().loadContent("");
    }
    
    void drawCarga(double coeficiente, double exponente, Circle circle, Label labelSimbolo, Label labelCarga) {
        if (coeficiente >= 0) {
            circle.setFill(javafx.scene.paint.Paint.valueOf(positivo));
            labelSimbolo.setText("+");
        } else {
            circle.setFill(javafx.scene.paint.Paint.valueOf(negativo));
            labelSimbolo.setText("-");
        }
        labelCarga.setText(coeficiente+" x10 "+exponente);
    }

    private void cleanCarga(Circle circle, Label labelSimbolo, Label labelCarga) {
        circle.setFill(javafx.scene.paint.Paint.valueOf(blanco));
        labelSimbolo.setText("");
        labelCarga.setText("0");
    }

    private double convertirDistancia(double valor, String medida) {
        double metro = 0;
        switch (medida) {
            case "m" : metro = valor; break;
            case "dm" : metro = valor / 10; break;
            case "cm" : metro = valor / 100; break;
            case "mm" : metro = valor / 1000; break;
            case "dam" : metro = valor * 10; break;
            case "hm" : metro = valor * 100; break;
            case "km" : metro = valor * 1000; break;
        }
        return metro;
    }
    
    void validar(){
        
    }
}
